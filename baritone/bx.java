/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  auh
 *  ave
 *  bew
 *  cj
 *  pk
 */
package baritone;

import baritone.a;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.IPlayerController;
import baritone.api.utils.RayTraceUtils;
import baritone.api.utils.Rotation;
import baritone.by;
import baritone.d;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bx
implements IPlayerContext {
    private final a a;
    private final ave a;
    private final IPlayerController a;

    public bx(a a2, ave ave2) {
        this.a = a2;
        this.a = ave2;
        this.a = new by(ave2);
    }

    @Override
    public final ave minecraft() {
        return this.a;
    }

    @Override
    public final bew player() {
        return this.a.h;
    }

    @Override
    public final IPlayerController playerController() {
        return this.a;
    }

    @Override
    public final BetterBlockPos viewerPos() {
        pk pk2 = this.a.ac();
        if (pk2 == null) {
            return this.playerFeet();
        }
        return BetterBlockPos.from(new cj(pk2));
    }

    @Override
    public final Rotation playerRotations() {
        d d2 = this.a.a;
        return ((Boolean)baritone.a.a().freeLook.value != false ? Optional.ofNullable(d2.a) : Optional.empty()).orElseGet(() -> IPlayerContext.super.playerRotations());
    }

    @Override
    public final auh objectMouseOver() {
        return RayTraceUtils.rayTraceTowards((pk)this.player(), this.playerRotations(), this.playerController().getBlockReachDistance());
    }
}
