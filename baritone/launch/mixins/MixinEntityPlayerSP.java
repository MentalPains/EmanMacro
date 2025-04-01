/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bew
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.ChatEvent;
import baritone.api.event.events.PlayerUpdateEvent;
import baritone.api.event.events.type.Cancellable;
import baritone.api.event.events.type.EventState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={bew.class})
public class MixinEntityPlayerSP {
    @Inject(method={"sendChatMessage"}, at={@At(value="HEAD")}, cancellable=true)
    public void onSendChatMessage(String object, CallbackInfo callbackInfo) {
        IBaritone iBaritone = BaritoneAPI.getProvider().getBaritoneForPlayer((bew)this);
        if (iBaritone == null) {
            return;
        }
        object = new ChatEvent((String)object);
        iBaritone.getGameEventHandler().onSendChatMessage((ChatEvent)object);
        if (((Cancellable)object).isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onUpdate"}, at={@At(value="INVOKE", target="net/minecraft/client/entity/AbstractClientPlayer.onUpdate()V", shift=At.Shift.AFTER)})
    private void onPreUpdate(CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForPlayer((bew)this);
        if (object != null) {
            object.getGameEventHandler().onPlayerUpdate(new PlayerUpdateEvent(EventState.PRE));
        }
    }
}
