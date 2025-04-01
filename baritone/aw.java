/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afi
 *  com.google.common.collect.ImmutableSet
 *  cq
 *  df
 *  pe
 */
package baritone;

import baritone.a;
import baritone.api.IBaritone;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.bj;
import baritone.o;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import baritone.q;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

public final class aw
extends o {
    public aw(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2);
    }

    @Override
    public final void reset() {
        super.reset();
    }

    @Override
    public final double a(CalculationContext calculationContext) {
        return aw.a(calculationContext, this.a.a, this.a.c, this.a.d, this.b.a, this.b.d);
    }

    @Override
    public final Set<BetterBlockPos> a() {
        BetterBlockPos betterBlockPos;
        BetterBlockPos betterBlockPos2 = betterBlockPos = new BetterBlockPos(this.a.b((df)this.getDirection()).a());
        return ImmutableSet.of((Object)((Object)this.a), (Object)((Object)this.a.up()), (Object)((Object)this.b), (Object)((Object)betterBlockPos2), (Object)((Object)betterBlockPos2.up()));
    }

    /*
     * Unable to fully structure code
     */
    public static double a(CalculationContext var0, int var1_1, int var2_4, int var3_5, int var4_6, int var5_7) {
        block9: {
            block8: {
                var6_8 = var0.a(var4_6, var2_4, var5_7);
                if (!p.c(var0, var4_6, var2_4, var5_7, var6_8)) {
                    return 1000000.0;
                }
                var7_9 = var0.a(var1_1, var2_4 + 2, var3_5);
                if (!p.a(var0, var1_1, var2_4 + 2, var3_5, var7_9)) {
                    return 1000000.0;
                }
                if (!p.a(var0, var4_6, var2_4 + 1, var5_7)) {
                    return 1000000.0;
                }
                if (!p.a(var0, var4_6, var2_4 + 2, var5_7)) {
                    return 1000000.0;
                }
                var1_2 = var0.a(var1_1, var2_4 - 1, var3_5);
                if (var1_2.c() == afi.au || var1_2.c() == afi.bn) {
                    return 1000000.0;
                }
                var1_3 = p.a(var1_2);
                var2_4 = (int)p.a(var6_8);
                if (var1_3 && var2_4 == 0) {
                    return 1000000.0;
                }
                if (var2_4 == 0) break block8;
                if (var1_3) ** GOTO lbl-1000
                var8_10 = 4.63284688441047;
                break block9;
            }
            if (var6_8.c() == afi.aW) {
                var8_10 = 9.26569376882094;
            } else lbl-1000:
            // 2 sources

            {
                var8_10 = Math.max(aw.JUMP_ONE_BLOCK_COST, 4.63284688441047);
            }
            var8_10 += var0.b;
        }
        return var8_10;
    }

    @Override
    public final q a(q q2) {
        boolean bl;
        double d;
        double d2;
        block13: {
            int n;
            if (this.a.playerFeet().c < this.a.c) {
                MovementStatus movementStatus = MovementStatus.UNREACHABLE;
                q q3 = q2;
                q2.a = movementStatus;
                return q3;
            }
            super.a(q2);
            if (q2.a != MovementStatus.RUNNING) {
                return q2;
            }
            int n2 = n = this.a.player().bl() != null && this.a.player().b(pe.j) != null && this.a.player().b(pe.j).c() > 0 && !this.a.player().C ? 1 : 0;
            if ((this.a.playerFeet().equals((Object)this.b) || this.a.playerFeet().equals(this.b.a((df)this.getDirection().b()))) && n == 0) {
                MovementStatus movementStatus = MovementStatus.SUCCESS;
                q q4 = q2;
                q2.a = movementStatus;
                return q4;
            }
            Object object = VecUtils.getBlockPosCenter(this.b).a(0.0, 0.5, 0.0);
            object = RotationUtils.calcRotationFromVec3d(this.a.playerHead(), object, this.a.playerRotations()).withPitch(this.a.playerRotations().getPitch());
            if (n == 0) {
                q2.a = new q.a((Rotation)object, false);
            }
            if ((double)Math.abs(this.a.getLookBehavior().getAimProcessor().interpolate(this.a.playerRotations(), (Rotation)object).subtract((Rotation)object).normalize().getYaw()) <= (Double)baritone.a.a().randomLooking.value + (Double)baritone.a.a().randomLooking113.value + (Double)baritone.a.a().maxYawOffsetForForward.value) {
                q2.a(Input.MOVE_FORWARD, true);
            } else {
                p.c(this.a, q2, VecUtils.getBlockPosCenter(this.a).b((double)this.getDirection().n() * 0.42, 0.0, (double)this.getDirection().p() * 0.42));
            }
            if (p.a(bj.a(this.a, this.b.down())) && !p.a(bj.a(this.a, this.a.down()))) {
                return q2;
            }
            if (((Boolean)baritone.a.a().assumeStep.value).booleanValue() || this.a.playerFeet().equals((Object)this.a.up())) {
                return q2;
            }
            n = Math.abs(this.a.n() - this.b.n());
            int n3 = Math.abs(this.a.p() - this.b.p());
            d2 = (double)n * Math.abs((double)this.b.n() + 0.5 - this.a.playerFeetAsVec().a) + (double)n3 * Math.abs((double)this.b.p() + 0.5 - this.a.playerFeetAsVec().c);
            d = (double)n3 * Math.abs((double)this.b.n() + 0.5 - this.a.playerFeetAsVec().a) + (double)n * Math.abs((double)this.b.p() + 0.5 - this.a.playerFeetAsVec().c);
            if (Math.abs((double)n * this.a.playerMotion().c + (double)n3 * this.a.playerMotion().a) > 0.1) {
                return q2;
            }
            if (this.a.playerFeetAsVec().b > (double)this.a.c + 0.5) {
                return q2;
            }
            aw aw2 = this;
            BetterBlockPos betterBlockPos = aw2.a.up(2);
            for (int i = 0; i < 4; ++i) {
                BetterBlockPos betterBlockPos2 = betterBlockPos.offset(cq.b((int)i));
                if (p.a(aw2.a, betterBlockPos2)) continue;
                bl = false;
                break block13;
            }
            bl = true;
        }
        if (bl) {
            return q2.a(Input.JUMP, true);
        }
        if (d2 > 1.2 || d > 0.2) {
            return q2;
        }
        return q2.a(Input.JUMP, true);
    }

    @Override
    public final boolean b(q q2) {
        return q2.a != MovementStatus.RUNNING;
    }
}
