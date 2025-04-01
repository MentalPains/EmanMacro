/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bew
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  pk
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.RotationMoveEvent;
import java.util.Optional;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={pk.class})
public class MixinEntity {
    @Shadow
    public float y;
    @Shadow
    public float z;
    @Unique
    private RotationMoveEvent motionUpdateRotationEvent;

    @Inject(method={"moveFlying"}, at={@At(value="HEAD")})
    private void moveFlyingHead(float f, float f2, float f3, CallbackInfo callbackInfo) {
        this.getBaritone().ifPresent(iBaritone -> {
            this.motionUpdateRotationEvent = new RotationMoveEvent(RotationMoveEvent.Type.MOTION_UPDATE, this.y, this.z);
            iBaritone.getGameEventHandler().onPlayerRotationMove(this.motionUpdateRotationEvent);
            this.y = this.motionUpdateRotationEvent.getYaw();
            this.z = this.motionUpdateRotationEvent.getPitch();
        });
    }

    @Inject(method={"moveFlying"}, at={@At(value="RETURN")})
    private void moveFlyingReturn(float f, float f2, float f3, CallbackInfo callbackInfo) {
        if (this.motionUpdateRotationEvent != null) {
            this.y = this.motionUpdateRotationEvent.getOriginal().getYaw();
            this.z = this.motionUpdateRotationEvent.getOriginal().getPitch();
            this.motionUpdateRotationEvent = null;
        }
    }

    @Unique
    private Optional<IBaritone> getBaritone() {
        if (bew.class.isInstance(this)) {
            return Optional.ofNullable(BaritoneAPI.getProvider().getBaritoneForPlayer((bew)this));
        }
        return Optional.empty();
    }
}
