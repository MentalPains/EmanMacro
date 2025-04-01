/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afh
 *  afi
 *  agh
 *  agu
 *  ahr
 *  alz
 *  amo
 *  aui
 *  cj
 *  com.google.common.collect.ImmutableSet
 *  cq
 *  df
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
import java.util.Optional;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bb
extends o {
    public bb(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        super(iBaritone, betterBlockPos, betterBlockPos2);
    }

    @Override
    public final void reset() {
        super.reset();
    }

    @Override
    public final double a(CalculationContext calculationContext) {
        return bb.a(calculationContext, this.a.a, this.a.c, this.a.d, this.b.a, this.b.d);
    }

    @Override
    public final Set<BetterBlockPos> a() {
        return ImmutableSet.of((Object)((Object)this.a), (Object)((Object)this.b));
    }

    public static double a(CalculationContext calculationContext, int n, int n2, int n3, int n4, int n5) {
        alz alz2 = calculationContext.a(n4, n2 + 1, n5);
        alz alz3 = calculationContext.a(n4, n2, n5);
        alz alz4 = calculationContext.a(n4, n2 - 1, n5);
        afh afh2 = calculationContext.a(n, n2 - 1, n3).c();
        if (p.c(calculationContext, n4, n2 - 1, n5, alz4)) {
            double d = 4.63284688441047;
            n3 = 0;
            if (p.b(alz2.c())) {
                d = calculationContext.a;
                n3 = 1;
            } else {
                if (alz4.c() == afi.aW) {
                    d = 6.949270326615705;
                } else if (alz4.c() == afi.j) {
                    d = 4.63284688441047 + calculationContext.c;
                }
                if (afh2 == afi.aW) {
                    d += 2.316423442205235;
                }
            }
            if (!p.a(calculationContext, n4, n2, n5, alz3)) {
                return 1000000.0;
            }
            if (!p.a(calculationContext, n4, n2 + 1, n5, alz2)) {
                return 1000000.0;
            }
            if (n3 == 0 && calculationContext.b) {
                d *= 0.7692444761225944;
            }
            return d;
        }
        return 1000000.0;
    }

    @Override
    public final q a(q q2) {
        Optional<Rotation> optional;
        BetterBlockPos betterBlockPos;
        super.a(q2);
        if (q2.a != MovementStatus.RUNNING) {
            return q2;
        }
        afh afh2 = bj.a(this.a, this.a.down()).c();
        boolean bl = afh2 == afi.au || afh2 == afi.bn;
        Object object = this.b.up();
        Object object2 = bj.a(this.a, (cj)object);
        Object object3 = bj.a(this.a, this.b);
        if (object2.c() instanceof agh || object3.c() instanceof agh) {
            boolean bl2;
            boolean bl3 = object2.c() instanceof agh && !p.a(this.a, this.a, this.b) || object3.c() instanceof agh && !p.a(this.a, this.b, this.a);
            boolean bl4 = bl2 = !afi.aA.equals(object2.c()) && !afi.aA.equals(object3.c());
            if (bl3 && bl2) {
                object3 = new q.a(RotationUtils.calcRotationFromVec3d(this.a.playerHead(), VecUtils.calculateBlockCenter(this.a.world(), (cj)object), this.a.playerRotations()), true);
                object2 = q2;
                q2.a = object3;
                return ((q)object2).a(Input.CLICK_RIGHT, true);
            }
        }
        if ((object2.c() instanceof agu || object3.c() instanceof agu) && (!p.b(this.a, (cj)object, this.a.up()) ? object : (betterBlockPos = !p.b(this.a, this.b, this.a) ? this.b : null)) != null && (optional = RotationUtils.reachable(this.a, betterBlockPos)).isPresent()) {
            object3 = new q.a(optional.get(), true);
            object2 = q2;
            q2.a = object3;
            return ((q)object2).a(Input.CLICK_RIGHT, true);
        }
        BetterBlockPos betterBlockPos2 = this.a.playerFeet();
        if (betterBlockPos2.o() != this.b.o() && !bl) {
            if (betterBlockPos2.o() < this.b.o()) {
                return q2.a(Input.JUMP, true);
            }
            return q2;
        }
        alz alz2 = bj.a(this.a, this.b.down());
        if (betterBlockPos2.equals((Object)this.b)) {
            object3 = MovementStatus.SUCCESS;
            object2 = q2;
            q2.a = object3;
            return object2;
        }
        if (((Boolean)baritone.a.a().overshootTraverse.value).booleanValue() && (betterBlockPos2.equals(this.b.a((df)this.getDirection())) || betterBlockPos2.equals(this.b.a((df)this.getDirection()).a((df)this.getDirection())))) {
            object3 = MovementStatus.SUCCESS;
            object2 = q2;
            q2.a = object3;
            return object2;
        }
        object2 = bj.a(this.a, this.a).c();
        object3 = bj.a(this.a, this.a.up()).c();
        if (this.a.playerFeetAsVec().b > (double)this.a.c + 0.1 && !this.a.player().C && (object2 == afi.bn || object2 == afi.au || object3 == afi.bn || object3 == afi.au)) {
            return q2;
        }
        object2 = this.b.b((df)this.a).a((df)this.b);
        object3 = bj.a(this.a, (cj)object2);
        object2 = bj.a(this.a, object2.a());
        if (!(p.c(this.a, betterBlockPos2) && !((Boolean)baritone.a.a().sprintInWater.value).booleanValue() || p.a((afh)object3) && !p.b((afh)object3) || p.a((afh)object2))) {
            q2.a(Input.SPRINT, true);
        }
        if (betterBlockPos2.o() != this.b.o() && bl && (alz2.c() == afi.bn || alz2.c() == afi.au)) {
            CalculationContext calculationContext;
            Object object4 = alz2.c() == afi.bn ? ((calculationContext = new CalculationContext(this.a)).a(((BetterBlockPos)((Object)(object = this.b.down()))).north()).c().u() ? ((BetterBlockPos)((Object)object)).north() : (calculationContext.a(((BetterBlockPos)((Object)object)).south()).c().u() ? ((BetterBlockPos)((Object)object)).south() : (calculationContext.a(((BetterBlockPos)((Object)object)).east()).c().u() ? ((BetterBlockPos)((Object)object)).east() : (calculationContext.a(((BetterBlockPos)((Object)object)).west()).c().u() ? ((BetterBlockPos)((Object)object)).west() : null)))) : (object = this.b.offset(((cq)alz2.b((amo)ahr.a)).d()));
            if (object4 == null) {
                this.logDirect("Unable to climb vines. Consider disabling allowVines.");
                object3 = MovementStatus.UNREACHABLE;
                object2 = q2;
                q2.a = object3;
                return object2;
            }
        }
        aui aui2 = VecUtils.getBlockPosCenter((cj)object).a(0.0, 0.5, 0.0);
        object = RotationUtils.calcRotationFromVec3d(this.a.playerHead(), aui2, this.a.playerRotations()).withPitch(this.a.playerRotations().getPitch());
        q2.a = new q.a((Rotation)object, false);
        if ((double)Math.abs(this.a.getLookBehavior().getAimProcessor().interpolate(this.a.playerRotations(), (Rotation)object).subtract((Rotation)object).normalize().getYaw()) <= (Double)baritone.a.a().randomLooking.value + (Double)baritone.a.a().randomLooking113.value + (Double)baritone.a.a().maxYawOffsetForForward.value) {
            q2.a(Input.MOVE_FORWARD, true);
            return q2;
        }
        p.b(this.a, q2, aui2);
        return q2;
    }

    @Override
    public final boolean b(q q2) {
        BetterBlockPos betterBlockPos = this.b.down();
        return q2.a != MovementStatus.RUNNING || p.a(new bj(this.a), betterBlockPos.a, betterBlockPos.c, betterBlockPos.d);
    }

    @Override
    public final boolean a(q q2) {
        return true;
    }
}
