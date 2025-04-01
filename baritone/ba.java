/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afh
 *  afi
 *  aju
 *  alz
 *  aui
 *  cj
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
import baritone.bj;
import baritone.bv;
import baritone.o;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import baritone.q;
import java.util.HashSet;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ba
extends o {
    private final cq a;
    private final int a;
    private final boolean a;

    private ba(IBaritone iBaritone, BetterBlockPos betterBlockPos, int n, cq cq2, boolean bl) {
        BetterBlockPos betterBlockPos2 = betterBlockPos;
        super(iBaritone, betterBlockPos2, betterBlockPos2.offset(cq2, n).up(bl ? 1 : 0));
        this.a = cq2;
        this.a = n;
        this.a = bl;
    }

    public static ba a(CalculationContext calculationContext, BetterBlockPos betterBlockPos, cq cq2) {
        bv bv2 = new bv();
        ba.a(calculationContext, betterBlockPos.a, betterBlockPos.c, betterBlockPos.d, cq2, bv2);
        int n = Math.abs(bv2.a - betterBlockPos.a) + Math.abs(bv2.c - betterBlockPos.d);
        return new ba(calculationContext.a, betterBlockPos, n, cq2, bv2.b > betterBlockPos.c);
    }

    public static void a(CalculationContext calculationContext, int n, int n2, int n3, cq cq2, bv bv2) {
        int n4;
        int n5;
        int n6;
        if (!calculationContext.c) {
            return;
        }
        if (n2 == 256 && !calculationContext.d) {
            return;
        }
        int n7 = cq2.g();
        if (!p.b(calculationContext, n + n7, n2, n3 + (n6 = cq2.i()))) {
            return;
        }
        alz alz2 = calculationContext.a(n + n7, n2 - 1, n3 + n6);
        if (p.c(calculationContext, n + n7, n2 - 1, n3 + n6, alz2)) {
            return;
        }
        if (p.a((afh)(alz2 = alz2.c())) && !p.b((afh)alz2)) {
            return;
        }
        if (!p.b(calculationContext, n + n7, n2 + 1, n3 + n6)) {
            return;
        }
        if (!p.b(calculationContext, n + n7, n2 + 2, n3 + n6)) {
            return;
        }
        if (!p.b(calculationContext, n, n2 + 2, n3)) {
            return;
        }
        alz2 = calculationContext.a(n, n2 - 1, n3);
        afh afh2 = alz2.c();
        if (afh2 == afi.bn || afh2 == afi.au || afh2 instanceof aju || p.a(alz2)) {
            return;
        }
        if (calculationContext.f && !p.b(afh2)) {
            return;
        }
        if (p.b(calculationContext.a(n, n2, n3))) {
            return;
        }
        int n8 = alz2.c() == afi.aW ? 2 : (calculationContext.b ? 4 : 3);
        for (int i = 2; i <= n8 && p.b(calculationContext, n5 = n + n7 * i, n2 + 1, n4 = n3 + n6 * i) && p.b(calculationContext, n5, n2 + 2, n4); ++i) {
            alz alz3 = calculationContext.a.a(n5, n2, n4);
            if (!p.b(calculationContext, n5, n2, n4, alz3)) {
                if (i > 3 || !calculationContext.e || !calculationContext.b || !p.c(calculationContext, n5, n2, n4, alz3) || !ba.b(calculationContext.a, n5 + n7, n2 + 1, n4 + n6)) break;
                bv2.a = n5;
                bv2.b = n2 + 1;
                bv2.c = n4;
                bv2.a = (double)i * 3.563791874554526 + calculationContext.b;
                return;
            }
            alz3 = calculationContext.a.a(n5, n2 - 1, n4);
            if (alz3.c() != afi.ak && p.c(calculationContext, n5, n2 - 1, n4, alz3)) {
                if (!ba.b(calculationContext.a, n5 + n7, n2, n4 + n6)) break;
                if (!(!((Boolean)baritone.a.a().checkOvershootParkour.value).booleanValue() || p.c(calculationContext, n5 + n7, n2 - 1, n4 + n6) && ba.b(calculationContext.a, n5 + 2 * n7, n2, n4 + 2 * n6))) {
                    return;
                }
                bv2.a = n5;
                bv2.b = n2;
                bv2.c = n4;
                bv2.a = ba.a(i) + calculationContext.b;
                return;
            }
            if (!p.b(calculationContext, n5, n2 + 3, n4)) break;
        }
    }

    private static boolean b(bj bj2, int n, int n2, int n3) {
        return !p.a(bj2.a(n, n2, n3).c()) && !p.a(bj2.a(n, n2 + 1, n3).c());
    }

    private static double a(int n) {
        switch (n) {
            case 2: {
                return 9.26569376882094;
            }
            case 3: {
                return 13.89854065323141;
            }
            case 4: {
                return 14.255167498218103;
            }
        }
        throw new IllegalStateException("LOL ".concat(String.valueOf(n)));
    }

    @Override
    public final double a(CalculationContext calculationContext) {
        bv bv2 = new bv();
        ba.a(calculationContext, this.a.a, this.a.c, this.a.d, this.a, bv2);
        if (bv2.a != this.b.a || bv2.b != this.b.c || bv2.c != this.b.d) {
            return 1000000.0;
        }
        return bv2.a;
    }

    @Override
    public final Set<BetterBlockPos> a() {
        HashSet<BetterBlockPos> hashSet = new HashSet<BetterBlockPos>();
        for (int i = 0; i <= this.a; ++i) {
            for (int j = 0; j < 2; ++j) {
                hashSet.add(this.a.offset(this.a, i).up(j));
            }
        }
        return hashSet;
    }

    @Override
    public final boolean b(q q2) {
        return q2.a != MovementStatus.RUNNING;
    }

    @Override
    public final q a(q q2) {
        double d;
        super.a(q2);
        if (q2.a != MovementStatus.RUNNING) {
            return q2;
        }
        if (this.a.playerFeet().c < this.a.c) {
            MovementStatus movementStatus = MovementStatus.UNREACHABLE;
            q q3 = q2;
            q2.a = movementStatus;
            return q3;
        }
        if (this.a >= 4 || this.a) {
            q2.a(Input.SPRINT, true);
        }
        Object object = VecUtils.getBlockPosCenter(this.b);
        p.a((IPlayerContext)this.a, q2, object);
        Object object2 = RotationUtils.calcRotationFromVec3d(this.a.playerHead(), object, this.a.playerRotations());
        if ((double)Math.abs(this.a.playerRotations().subtract((Rotation)object2).normalize().getYaw()) <= (Double)baritone.a.a().randomLooking113.value + (Double)baritone.a.a().randomLooking.value) {
            double d2;
            d = this.a.playerFeetAsVec().f(object);
            if (d2 < 0.5) {
                p.a(q2, (IPlayerContext)this.a);
                q2.a(Input.SNEAK, true);
            } else if (d < 1.0 && this.a.playerMotion().b() > 0.15) {
                q2.a(Input.MOVE_BACK, true);
            } else {
                q2.a(Input.MOVE_FORWARD, true);
            }
        }
        if (this.a.playerFeet().equals((Object)this.b)) {
            if (this.a.playerMotion().b() > 0.1) {
                p.a(q2, (IPlayerContext)this.a);
                q2.a(Input.SNEAK, true);
                return q2;
            }
            afh afh2 = bj.a((IPlayerContext)this.a, this.b);
            if (afh2 == afi.bn || afh2 == afi.au) {
                object2 = MovementStatus.SUCCESS;
                object = q2;
                q2.a = object2;
                return object;
            }
            if (this.a.playerFeetAsVec().b - (double)this.a.playerFeet().o() < 0.094) {
                q2.a = MovementStatus.SUCCESS;
            }
        } else if (!this.a.playerFeet().equals(this.a)) {
            if (this.a.playerFeet().equals((Object)this.a.offset(this.a)) || this.a.playerFeetAsVec().b - (double)this.a.c > 1.0E-4) {
                if (this.a == 3 && !this.a) {
                    d = (double)this.a.a + 0.5 - this.a.playerFeetAsVec().a;
                    double d3 = (double)this.a.d + 0.5 - this.a.playerFeetAsVec().c;
                    if (Math.max(Math.abs(d), Math.abs(d3)) < 0.7) {
                        return q2;
                    }
                }
                q2.a(Input.JUMP, true);
            } else if (!this.a.playerFeet().equals((Object)this.b.offset(this.a, -1))) {
                q2.a(Input.SPRINT, false);
                if (this.a.playerFeet().equals((Object)this.a.offset(this.a, -1))) {
                    aui aui2 = VecUtils.getBlockPosCenter((cj)this.a).a(0.0, 0.5, 0.0);
                    p.a((IPlayerContext)this.a, q2, aui2);
                    p.c((IPlayerContext)this.a, q2, aui2);
                } else {
                    aui aui3 = VecUtils.getBlockPosCenter(this.a.offset(this.a, -1)).a(0.0, 0.5, 0.0);
                    p.a((IPlayerContext)this.a, q2, aui3);
                    p.c((IPlayerContext)this.a, q2, aui3);
                }
            }
        }
        return q2;
    }
}
