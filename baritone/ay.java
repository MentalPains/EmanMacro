/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afh
 *  afi
 *  alz
 *  aui
 *  cj
 *  com.google.common.collect.ImmutableSet
 *  cq
 */
package baritone;

import baritone.a;
import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.bv;
import baritone.o;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import baritone.q;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ay
extends o {
    private static final double a = Math.sqrt(2.0);

    public ay(IBaritone iBaritone, BetterBlockPos betterBlockPos, cq cq2, cq cq3, int n) {
        BetterBlockPos betterBlockPos2 = betterBlockPos;
        this(iBaritone, betterBlockPos2, betterBlockPos2.offset(cq2), cq3, n);
    }

    private ay(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2, cq cq2, int n) {
        this(iBaritone, betterBlockPos, betterBlockPos2.offset(cq2).up(n));
    }

    private ay(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2);
    }

    @Override
    public final void reset() {
        super.reset();
    }

    @Override
    public final double a(CalculationContext calculationContext) {
        bv bv2 = new bv();
        ay.a(calculationContext, this.a.a, this.a.c, this.a.d, this.b.a, this.b.d, bv2);
        if (bv2.b != this.b.c) {
            return 1000000.0;
        }
        return bv2.a;
    }

    @Override
    public final Set<BetterBlockPos> a() {
        BetterBlockPos betterBlockPos = new BetterBlockPos(this.a.a, this.a.c, this.b.d);
        BetterBlockPos betterBlockPos2 = new BetterBlockPos(this.b.a, this.a.c, this.a.d);
        if (this.b.c < this.a.c) {
            return ImmutableSet.of((Object)this.a, (Object)((Object)this.b.up()), (Object)((Object)betterBlockPos), (Object)((Object)betterBlockPos2), (Object)((Object)this.b), (Object)((Object)betterBlockPos.down()), (Object[])new BetterBlockPos[]{betterBlockPos2.down()});
        }
        if (this.b.c > this.a.c) {
            return ImmutableSet.of((Object)this.a, (Object)((Object)this.a.up()), (Object)((Object)betterBlockPos), (Object)((Object)betterBlockPos2), (Object)((Object)this.b), (Object)((Object)betterBlockPos.up()), (Object[])new BetterBlockPos[]{betterBlockPos2.up()});
        }
        return ImmutableSet.of((Object)this.a, (Object)((Object)this.b), (Object)((Object)betterBlockPos), (Object)((Object)betterBlockPos2));
    }

    public static void a(CalculationContext calculationContext, int n, int n2, int n3, int n4, int n5, bv bv2) {
        alz alz2;
        alz alz3;
        if (!p.a(calculationContext, n4, n2 + 1, n5)) {
            return;
        }
        alz alz4 = calculationContext.a(n4, n2, n5);
        boolean bl = false;
        boolean bl2 = false;
        if (!p.a(calculationContext, n4, n2, n5, alz4)) {
            bl = true;
            if (!(calculationContext.h && p.a(calculationContext, n, n2 + 2, n3) && p.c(calculationContext, n4, n2, n5, alz4) && p.a(calculationContext, n4, n2 + 2, n5))) {
                return;
            }
            alz3 = alz4;
            alz2 = calculationContext.a(n, n2 - 1, n3);
        } else {
            alz3 = calculationContext.a(n4, n2 - 1, n5);
            alz2 = calculationContext.a(n, n2 - 1, n3);
            if (!p.c(calculationContext, n4, n2 - 1, n5, alz3)) {
                bl2 = true;
                if (!(calculationContext.g && p.c(calculationContext, n4, n2 - 2, n5) && p.a(calculationContext, n4, n2 - 1, n5, alz3))) {
                    return;
                }
            }
        }
        double d = 4.63284688441047;
        if (alz3.c() == afi.aW) {
            d = 6.949270326615705;
        } else if (alz3.c() == afi.j) {
            d = 4.63284688441047 + calculationContext.c * a;
        }
        alz2 = alz2.c();
        if (alz2 == afi.au || alz2 == afi.bn) {
            return;
        }
        if (alz2 == afi.aW) {
            d += 2.316423442205235;
        }
        if (p.c(calculationContext.a(n, n2 - 1, n5).c())) {
            return;
        }
        if (p.c(calculationContext.a(n4, n2 - 1, n3).c())) {
            return;
        }
        alz2 = calculationContext.a(n, n2, n3);
        boolean bl3 = false;
        if (p.b((afh)alz2) || p.b(alz4.c())) {
            if (bl) {
                return;
            }
            d = calculationContext.a;
            bl3 = true;
        }
        alz4 = calculationContext.a(n, n2, n5);
        alz alz5 = calculationContext.a(n4, n2, n3);
        if (bl) {
            bl = p.a(calculationContext, n, n2 + 2, n5);
            boolean bl4 = p.a(calculationContext, n, n2 + 1, n5);
            boolean bl5 = p.a(calculationContext, n, n2, n5, alz4);
            boolean bl6 = p.a(calculationContext, n4, n2 + 2, n3);
            boolean bl7 = p.a(calculationContext, n4, n2 + 1, n3);
            boolean bl8 = p.a(calculationContext, n4, n2, n3, alz5);
            if ((!bl || !bl4 || !bl5) && (!bl6 || !bl7 || !bl8) || p.a(alz4.c()) || p.a(alz5.c()) || bl && bl4 && p.c(calculationContext, n, n2, n5, alz4) || bl6 && bl7 && p.c(calculationContext, n4, n2, n3, alz5) || !bl && bl4 && bl5 || !bl6 && bl7 && bl8) {
                return;
            }
            bv2.a = d * a + JUMP_ONE_BLOCK_COST;
            bv2.a = n4;
            bv2.c = n5;
            bv2.b = n2 + 1;
            return;
        }
        bl = p.a(calculationContext, n, n2, n5, alz4);
        boolean bl9 = p.a(calculationContext, n4, n2, n3, alz5);
        if (!bl && !bl9) {
            return;
        }
        alz alz6 = calculationContext.a(n, n2 + 1, n5);
        if (!(bl |= p.a(calculationContext, n, n2 + 1, n5, alz6)) && !bl9) {
            return;
        }
        alz alz7 = calculationContext.a(n4, n2 + 1, n3);
        if (bl && (p.a(alz5.c()) && alz5.c() != afi.j || p.a(alz7.c()))) {
            return;
        }
        if (!bl && !(bl9 |= p.a(calculationContext, n4, n2 + 1, n3, alz7))) {
            return;
        }
        if (bl9 && (p.a(alz4.c()) && alz4.c() != afi.j || p.a(alz6.c()))) {
            return;
        }
        boolean bl10 = p.a(alz4);
        if (bl && bl10) {
            return;
        }
        boolean bl11 = p.a(alz5);
        if (bl9 && bl11) {
            return;
        }
        if (!bl || !bl9) {
            d *= a + 1.0;
            if (alz2 == afi.au || alz2 == afi.bn) {
                return;
            }
        } else if (calculationContext.b && !bl3) {
            d *= 0.7692444761225944;
        }
        bv2.a = d * a;
        if (bl2) {
            bv2.a += Math.max(FALL_N_BLOCKS_COST[1], 0.9265693768820937);
            bv2.b = n2 - 1;
        } else {
            bv2.b = n2;
        }
        bv2.a = n4;
        bv2.c = n5;
    }

    @Override
    public final q a(q q2) {
        super.a(q2);
        if (q2.a != MovementStatus.RUNNING) {
            return q2;
        }
        if (this.a.playerFeet().equals((Object)this.b)) {
            MovementStatus movementStatus;
            v0.a = movementStatus = MovementStatus.SUCCESS;
            return q2;
        }
        if (!(this.a() || p.c((IPlayerContext)this.a, (cj)this.a) && this.b().contains((Object)this.a.playerFeet().up()))) {
            MovementStatus movementStatus;
            v1.a = movementStatus = MovementStatus.UNREACHABLE;
            return q2;
        }
        if (this.b.c > this.a.c && this.a.playerFeetAsVec().b < (double)this.a.c + 0.1 && this.a.player().D) {
            q2.a(Input.JUMP, true);
        }
        ay ay2 = this;
        if (!p.c((IPlayerContext)ay2.a, ay2.a.playerFeet()) || (Boolean)baritone.a.a().sprintInWater.value != false) {
            q2.a(Input.SPRINT, true);
        }
        ay2 = VecUtils.getBlockPosCenter(this.b).a(0.0, 0.5, 0.0);
        Rotation rotation = RotationUtils.calcRotationFromVec3d(this.a.playerHead(), (aui)ay2, this.a.playerRotations()).withPitch(this.a.playerRotations().getPitch());
        q2.a = new q.a(rotation, false);
        if ((double)Math.abs(this.a.getLookBehavior().getAimProcessor().interpolate(this.a.playerRotations(), rotation).subtract(rotation).normalize().getYaw()) <= (Double)baritone.a.a().randomLooking.value + (Double)baritone.a.a().randomLooking113.value + (Double)baritone.a.a().maxYawOffsetForForward.value) {
            q2.a(Input.MOVE_FORWARD, true);
            return q2;
        }
        p.b((IPlayerContext)this.a, q2, (aui)ay2);
        return q2;
    }

    @Override
    public final boolean b(q q2) {
        return q2.a != MovementStatus.RUNNING;
    }

    @Override
    public final boolean a(q q2) {
        return true;
    }
}
