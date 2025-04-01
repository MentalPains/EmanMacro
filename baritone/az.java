/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afi
 *  ahr
 *  alz
 *  amo
 *  aui
 *  cj
 *  cq
 *  df
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.ax;
import baritone.bv;
import baritone.o;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import baritone.q;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public final class az
extends o {
    public az(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2);
    }

    @Override
    public final double a(CalculationContext calculationContext) {
        bv bv2 = new bv();
        ax.a(calculationContext, this.a.a, this.a.c, this.a.d, this.b.a, this.b.d, bv2);
        if (bv2.b != this.b.c) {
            return 1000000.0;
        }
        return bv2.a;
    }

    @Override
    public final Set<BetterBlockPos> a() {
        HashSet<BetterBlockPos> hashSet = new HashSet<BetterBlockPos>();
        hashSet.add(this.a);
        for (int i = this.a.c - this.b.c; i >= 0; --i) {
            hashSet.add(this.b.up(i));
        }
        return hashSet;
    }

    @Override
    public final q a(q q2) {
        cq cq2;
        az az2;
        BetterBlockPos betterBlockPos;
        block13: {
            super.a(q2);
            if (q2.a != MovementStatus.RUNNING) {
                return q2;
            }
            betterBlockPos = this.a.playerFeet();
            Rotation rotation = RotationUtils.calcRotationFromVec3d(this.a.playerHead(), VecUtils.getBlockPosCenter(this.b), this.a.playerRotations()).withPitch(this.a.playerRotations().getPitch());
            q2.a = new q.a(rotation, false);
            boolean bl = p.b(this.a.world().p((cj)this.b).c());
            if (betterBlockPos.equals((Object)this.b) && (this.a.playerFeetAsVec().b - (double)betterBlockPos.o() < 0.094 || bl)) {
                if (bl) {
                    if (this.a.playerMotion().b >= 0.0) {
                        MovementStatus movementStatus = MovementStatus.SUCCESS;
                        q q3 = q2;
                        q2.a = movementStatus;
                        return q3;
                    }
                } else {
                    MovementStatus movementStatus = MovementStatus.SUCCESS;
                    q q4 = q2;
                    q2.a = movementStatus;
                    return q4;
                }
            }
            betterBlockPos = VecUtils.getBlockPosCenter(this.b).a(0.0, 0.5, 0.0);
            if (Math.abs(this.a.playerFeetAsVec().a + this.a.playerMotion().a - ((aui)betterBlockPos).a) > 0.1 || Math.abs(this.a.playerFeetAsVec().c + this.a.playerMotion().c - ((aui)betterBlockPos).c) > 0.1) {
                if (!this.a.player().C && Math.abs(this.a.playerMotion().b) > 0.4) {
                    q2.a(Input.SNEAK, true);
                }
                p.c(this.a, q2, (aui)betterBlockPos);
            }
            az2 = this;
            for (int i = 0; i < 15; ++i) {
                alz alz2 = az2.a.world().p((cj)az2.a.playerFeet().down(i));
                if (alz2.c() != afi.au) continue;
                cq2 = (cq)alz2.b((amo)ahr.a);
                break block13;
            }
            cq2 = null;
        }
        az2 = Optional.ofNullable(cq2).map(cq::m).orElse(null);
        if (az2 == null) {
            az2 = this.a.b((df)this.b);
        } else if (Math.abs((double)az2.n() * (((aui)betterBlockPos).a - (double)az2.n() / 2.0 - this.a.playerFeetAsVec().a)) + Math.abs((double)az2.p() * (((aui)betterBlockPos).c - (double)az2.p() / 2.0 - this.a.playerFeetAsVec().c)) < 0.6) {
            p.c(this.a, q2, (aui)betterBlockPos);
        } else if (!this.a.player().C) {
            q2.a(Input.SNEAK, false);
        }
        betterBlockPos = new aui(((aui)betterBlockPos).a + 0.125 * (double)az2.n(), ((aui)betterBlockPos).b - 0.5, ((aui)betterBlockPos).c + 0.125 * (double)az2.p());
        p.a(this.a, q2, this.a, (aui)betterBlockPos);
        p.c(this.a, q2, (aui)betterBlockPos);
        return q2;
    }

    @Override
    public final boolean b(q q2) {
        return this.a.playerFeet().equals((Object)this.a) || q2.a != MovementStatus.RUNNING;
    }
}
