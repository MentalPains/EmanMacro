/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ave
 *  axu
 *  bdb
 *  bew
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Slice
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.PlayerUpdateEvent;
import baritone.api.event.events.TickEvent;
import baritone.api.event.events.WorldEvent;
import baritone.api.event.events.type.EventState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ave.class})
public class MixinMinecraft {
    @Shadow
    public bew h;
    @Shadow
    public axu m;
    @Shadow
    public bdb f;

    @Inject(method={"startGame"}, at={@At(value="RETURN")})
    private void postInit(CallbackInfo callbackInfo) {
        BaritoneAPI.getProvider().getPrimaryBaritone();
    }

    @Inject(method={"runTick"}, at={@At(value="FIELD", opcode=180, target="net/minecraft/client/Minecraft.currentScreen:Lnet/minecraft/client/gui/GuiScreen;", ordinal=0, shift=At.Shift.BEFORE)}, slice={@Slice(from=@At(value="FIELD", opcode=181, target="Lnet/minecraft/client/Minecraft;leftClickCounter:I"))})
    private void runTick(CallbackInfo object) {
        object = TickEvent.createNextProvider();
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            TickEvent.Type type = iBaritone.getPlayerContext().player() != null && iBaritone.getPlayerContext().world() != null ? TickEvent.Type.IN : TickEvent.Type.OUT;
            iBaritone.getGameEventHandler().onTick((TickEvent)object.apply(EventState.PRE, type));
        }
    }

    @Inject(method={"runTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/WorldClient;updateEntities()V", shift=At.Shift.AFTER)})
    private void postUpdateEntities(CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForPlayer(this.h);
        if (object != null) {
            object.getGameEventHandler().onPlayerUpdate(new PlayerUpdateEvent(EventState.POST));
        }
    }

    @Inject(method={"loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V"}, at={@At(value="HEAD")})
    private void preLoadWorld(bdb bdb2, String string, CallbackInfo callbackInfo) {
        if (this.f == null && bdb2 == null) {
            return;
        }
        BaritoneAPI.getProvider().getPrimaryBaritone().getGameEventHandler().onWorldEvent(new WorldEvent(bdb2, EventState.PRE));
    }

    @Inject(method={"loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V"}, at={@At(value="RETURN")})
    private void postLoadWorld(bdb bdb2, String string, CallbackInfo callbackInfo) {
        BaritoneAPI.getProvider().getPrimaryBaritone().getGameEventHandler().onWorldEvent(new WorldEvent(bdb2, EventState.POST));
    }
}
