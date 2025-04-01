/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adm
 *  bew
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  pk
 *  pr
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.RotationMoveEvent;
import java.util.Optional;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={pr.class})
public abstract class MixinEntityLivingBase
extends pk {
    @Unique
    private RotationMoveEvent jumpRotationEvent;

    public MixinEntityLivingBase(adm adm2) {
        super(adm2);
    }

    @Inject(method={"jump"}, at={@At(value="HEAD")})
    private void preMoveRelative(CallbackInfo callbackInfo) {
        this.getBaritone().ifPresent(iBaritone -> {
            this.jumpRotationEvent = new RotationMoveEvent(RotationMoveEvent.Type.JUMP, this.y, this.z);
            iBaritone.getGameEventHandler().onPlayerRotationMove(this.jumpRotationEvent);
        });
    }

    @Redirect(method={"jump"}, at=@At(value="FIELD", opcode=180, target="net/minecraft/entity/EntityLivingBase.rotationYaw:F"))
    private float overrideYaw(pr pr2) {
        if (pr2 instanceof bew && BaritoneAPI.getProvider().getBaritoneForPlayer((bew)this) != null) {
            return this.jumpRotationEvent.getYaw();
        }
        return pr2.y;
    }

    @Unique
    private Optional<IBaritone> getBaritone() {
        if (bew.class.isInstance((Object)this)) {
            return Optional.ofNullable(BaritoneAPI.getProvider().getBaritoneForPlayer((bew)this));
        }
        return Optional.empty();
    }
}
