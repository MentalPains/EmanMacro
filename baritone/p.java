/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afh
 *  afi
 *  afr
 *  agh
 *  agn
 *  agu
 *  agx
 *  ahh
 *  ahh$a
 *  ahv
 *  ajm
 *  ajp
 *  aju
 *  akh
 *  akn
 *  alz
 *  amk
 *  aml
 *  amo
 *  aui
 *  cj
 *  com.google.common.base.Predicate
 *  cq
 *  cq$a
 *  cq$c
 *  nz
 *  pr
 */
package baritone;

import baritone.a;
import baritone.api.pathing.movement.ActionCosts;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.bf;
import baritone.bg;
import baritone.bj;
import baritone.bl;
import baritone.bn;
import baritone.br;
import baritone.pathing.movement.CalculationContext;
import baritone.q;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface p
extends ActionCosts,
Helper {
    public static boolean a(IPlayerContext object, BetterBlockPos betterBlockPos) {
        int n = betterBlockPos.d;
        int n2 = betterBlockPos.c;
        int n3 = betterBlockPos.a;
        object = new bj((IPlayerContext)object);
        alz alz2 = ((bj)object).a(n3, n2, n);
        int n4 = p.a(alz2);
        if (n4 == bg.a) {
            return true;
        }
        if (n4 == bg.c) {
            return false;
        }
        return p.a((bj)object, n3, n2, n, alz2);
    }

    public static boolean a(CalculationContext calculationContext, int n, int n2, int n3, alz alz2) {
        return calculationContext.a.a(calculationContext.a, n, n2, n3, alz2);
    }

    public static boolean a(CalculationContext calculationContext, int n, int n2, int n3) {
        return calculationContext.a.a(calculationContext.a, n, n2, n3, calculationContext.a(n, n2, n3));
    }

    public static int a(alz alz2) {
        afh afh2 = alz2.c();
        if (afh2 == afi.a) {
            return bg.a;
        }
        if (afh2 == afi.ab || afh2 == afi.bS || afh2 == afi.G || afh2 == afi.bF || afh2 == afi.bN || afh2 instanceof ajm || afh2 instanceof akh || afh2 instanceof agx) {
            return bg.c;
        }
        if (((List)a.a().blocksToAvoid.value).contains(afh2)) {
            return bg.c;
        }
        if (afh2 instanceof agh || afh2 instanceof agu) {
            if (afh2 == afi.aA) {
                return bg.c;
            }
            return bg.a;
        }
        if (afh2 == afi.cy) {
            return bg.b;
        }
        if (afh2 instanceof ajp) {
            return bg.b;
        }
        if (afh2 instanceof ahv) {
            if ((Integer)alz2.b((amo)ahv.b) != 0) {
                return bg.c;
            }
            return bg.b;
        }
        if (afh2 instanceof afr) {
            return bg.c;
        }
        try {
            if (afh2.b(null, null)) {
                return bg.a;
            }
            return bg.c;
        }
        catch (Throwable throwable) {
            System.out.println("The block " + alz2.c().f() + " requires a special case due to the exception " + throwable.getMessage());
            return bg.b;
        }
    }

    public static boolean a(bj bj2, int n, int n2, int n3, alz alz2) {
        afh afh2 = alz2.c();
        if (afh2 == afi.cy) {
            return p.a(bj2, n, n2 - 1, n3);
        }
        if (afh2 instanceof ajp) {
            if (!bj2.a(n, n3)) {
                return true;
            }
            if ((Integer)alz2.b((amo)ajp.a) >= 3) {
                return false;
            }
            return p.a(bj2, n, n2 - 1, n3);
        }
        if (afh2 instanceof ahv) {
            if (p.a(n, n2, n3, alz2, bj2)) {
                return false;
            }
            if (((Boolean)a.a().assumeWalkOnWater.value).booleanValue()) {
                return false;
            }
            if ((bj2 = bj2.a(n, n2 + 1, n3)).c() instanceof ahv || bj2.c() instanceof akn) {
                return false;
            }
            return afh2 == afi.j || afh2 == afi.i;
        }
        return afh2.b(bj2.a, (cj)bj2.a.c(n, n2, n3));
    }

    public static int b(alz alz2) {
        afh afh2 = alz2.c();
        if (afh2 == afi.a) {
            return bg.a;
        }
        if (afh2 == afi.ab || afh2 == afi.bS || afh2 == afi.G || afh2 == afi.bn || afh2 == afi.au || afh2 == afi.bN || afh2 instanceof agh || afh2 instanceof agu || afh2 instanceof ajp || afh2 instanceof ahv || afh2 instanceof akh || afh2 instanceof agn || afh2 instanceof ajm || afh2 instanceof agx) {
            return bg.c;
        }
        try {
            if (afh2.b(null, null)) {
                return bg.a;
            }
            return bg.c;
        }
        catch (Throwable throwable) {
            System.out.println("The block " + alz2.c().f() + " requires a special case due to the exception " + throwable.getMessage());
            return bg.b;
        }
    }

    public static boolean b(CalculationContext calculationContext, int n, int n2, int n3) {
        return p.b(calculationContext, n, n2, n3, calculationContext.a(n, n2, n3));
    }

    public static boolean b(CalculationContext calculationContext, int n, int n2, int n3, alz alz2) {
        return calculationContext.a.b(calculationContext.a, n, n2, n3, alz2);
    }

    public static boolean a(IPlayerContext iPlayerContext, cj cj2) {
        alz alz2 = iPlayerContext.world().p(cj2);
        int n = p.b(alz2);
        if (n == bg.a) {
            return true;
        }
        if (n == bg.c) {
            return false;
        }
        return p.b(new bj(iPlayerContext), cj2.n(), cj2.o(), cj2.p(), alz2);
    }

    public static boolean b(bj bj2, int n, int n2, int n3, alz alz2) {
        return alz2.c().b(bj2.a, (cj)bj2.a.c(n, n2, n3));
    }

    public static boolean a(IPlayerContext iPlayerContext, cj object, cj cj2) {
        if (cj2.equals(object)) {
            return false;
        }
        if (!((iPlayerContext = bj.a(iPlayerContext, object)).c() instanceof agh)) {
            return true;
        }
        cj cj3 = object;
        amk amk2 = agh.b;
        object = iPlayerContext;
        iPlayerContext = cj3;
        if (!cj2.equals((Object)iPlayerContext)) {
            cq.a a2 = ((cq)object.b((amo)aml.a((String)"facing", (Predicate)cq.c.a))).k();
            boolean bl = (Boolean)object.b((amo)amk2);
            if (cj2.c().equals((Object)iPlayerContext) || cj2.d().equals((Object)iPlayerContext)) {
                iPlayerContext = cq.a.c;
            } else if (cj2.f().equals((Object)iPlayerContext) || cj2.e().equals((Object)iPlayerContext)) {
                iPlayerContext = cq.a.a;
            } else {
                return true;
            }
            if (a2 == iPlayerContext == bl) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(IPlayerContext iPlayerContext, cj cj2, cj cj3) {
        if (cj3.equals((Object)cj2)) {
            return false;
        }
        if (!((iPlayerContext = bj.a(iPlayerContext, cj2)).c() instanceof agu)) {
            return true;
        }
        return (Boolean)iPlayerContext.b((amo)agu.a);
    }

    public static boolean a(afh afh2) {
        return afh2 instanceof ahv || afh2 == afi.aK || afh2 == afi.ab || afh2 == afi.bF || afh2 == afi.G;
    }

    public static boolean c(bj bj2, int n, int n2, int n3, alz alz2) {
        int n4 = p.c(alz2);
        if (n4 == bg.a) {
            return true;
        }
        if (n4 == bg.c) {
            return false;
        }
        return p.d(bj2, n, n2, n3, alz2);
    }

    public static int c(alz alz2) {
        afh afh2 = alz2.c();
        if (afh2 == afi.cE) {
            return bg.c;
        }
        if (alz2.c().u()) {
            return bg.a;
        }
        if (afh2 == afi.au || afh2 == afi.bn && ((Boolean)a.a().allowVines.value).booleanValue()) {
            return bg.a;
        }
        if (afh2 == afi.ak || afh2 == afi.c) {
            return bg.a;
        }
        if (afh2 == afi.bQ || afh2 == afi.ae || afh2 == afi.cg) {
            return bg.a;
        }
        if (afh2 == afi.w || afh2 == afi.cG) {
            return bg.a;
        }
        if (afh2 instanceof aju) {
            return bg.a;
        }
        if (afh2 == afi.ca) {
            return bg.a;
        }
        if (p.b(afh2)) {
            return bg.b;
        }
        if (p.c(afh2) && ((Boolean)a.a().assumeWalkOnLava.value).booleanValue()) {
            return bg.b;
        }
        if (afh2 instanceof ahh) {
            if (!((Boolean)a.a().allowWalkOnBottomSlab.value).booleanValue()) {
                if (((ahh)afh2).l()) {
                    return bg.a;
                }
                if (alz2.b((amo)ahh.a) != ahh.a.b) {
                    return bg.a;
                }
                return bg.c;
            }
            return bg.a;
        }
        return bg.c;
    }

    public static boolean d(bj bj2, int n, int n2, int n3, alz alz2) {
        afh afh2 = alz2.c();
        if (p.b(afh2)) {
            afh afh3 = bj2.a(n, n2 + 1, n3).c();
            if (afh3 == afi.bx || afh3 == afi.cy) {
                return true;
            }
            if (p.a(n, n2, n3, alz2, bj2) || afh2 == afi.i) {
                return p.b(afh3) && (Boolean)a.a().assumeWalkOnWater.value == false;
            }
            return p.b(afh3) ^ (Boolean)a.a().assumeWalkOnWater.value;
        }
        return p.c(afh2) && !p.a(n, n2, n3, alz2, bj2) && (Boolean)a.a().assumeWalkOnLava.value != false;
    }

    public static boolean c(CalculationContext object, int n, int n2, int n3, alz alz2) {
        alz alz3 = alz2;
        int n4 = n3;
        n3 = n2;
        n2 = n;
        bj bj2 = ((CalculationContext)object).a;
        object = ((CalculationContext)object).a;
        int n5 = ((bf)object).a.indexOf(alz3);
        int n6 = ((bf)object).a[n5];
        if ((n6 & 1) == 0) {
            n6 = ((bf)object).a(n5, alz3);
        }
        if ((n6 & 4) != 0) {
            return p.d(bj2, n2, n3, n4, alz3);
        }
        return (n6 & 2) != 0;
    }

    public static boolean c(CalculationContext calculationContext, int n, int n2, int n3) {
        return p.c(calculationContext, n, n2, n3, calculationContext.a(n, n2, n3));
    }

    public static boolean b(IPlayerContext iPlayerContext, cj cj2) {
        return p.a(new bj(iPlayerContext), cj2.n(), cj2.o(), cj2.p());
    }

    public static boolean b(IPlayerContext iPlayerContext, BetterBlockPos betterBlockPos) {
        return p.a(new bj(iPlayerContext), betterBlockPos.a, betterBlockPos.c, betterBlockPos.d);
    }

    public static boolean a(bj bj2, int n, int n2, int n3) {
        return p.c(bj2, n, n2, n3, bj2.a(n, n2, n3));
    }

    public static boolean a(alz alz2) {
        return alz2.c() instanceof ahh && !((ahh)alz2.c()).l() && alz2.b((amo)ahh.a) == ahh.a.b;
    }

    public static void a(IPlayerContext iPlayerContext, q q2, aui aui2) {
        q2.a = new q.a(RotationUtils.calcRotationFromVec3d(iPlayerContext.playerHead(), aui2, iPlayerContext.playerRotations()).withPitch(iPlayerContext.playerRotations().getPitch()), false);
    }

    public static void a(IPlayerContext iPlayerContext, q q2, BetterBlockPos betterBlockPos, aui aui2) {
        q2.a = new q.a(RotationUtils.calcRotationFromVec3d(VecUtils.getBlockPosCenter(betterBlockPos), aui2, iPlayerContext.playerRotations()).withPitch(iPlayerContext.playerRotations().getPitch()), false);
    }

    public static void b(IPlayerContext iPlayerContext, q q2, aui aui2) {
        br br2 = new br(iPlayerContext.world());
        Enum[] enumArray = bl.values();
        nz nz2 = null;
        for (Enum enum_ : enumArray) {
            if (!((Boolean)a.a().allowSprint.value).booleanValue() && Arrays.asList(((bl)enum_).a).contains((Object)Input.SPRINT)) continue;
            br2.a((pr)iPlayerContext.player(), iPlayerContext);
            double d = ((bl)enum_).a(br2, iPlayerContext).f(aui2);
            if (nz2 != null && !(d < (Double)nz2.b())) continue;
            nz2 = new nz((Object)enum_, (Object)d);
        }
        if (nz2 != null) {
            enumArray = ((bl)((Object)((Object)nz2.a()))).a;
            int n = ((bl)((Object)((Object)nz2.a()))).a.length;
            for (int i = 0; i < n; ++i) {
                Enum enum_;
                enum_ = enumArray[i];
                q2.a((Input)enum_, true);
            }
        }
    }

    public static void c(IPlayerContext iPlayerContext, q q2, aui aui2) {
        Enum enum_;
        int n;
        br br2 = new br(iPlayerContext.world());
        bl[] blArray = bl.values();
        nz nz2 = null;
        Enum[] enumArray = blArray;
        int n2 = blArray.length;
        for (n = 0; n < n2; ++n) {
            enum_ = enumArray[n];
            if (!((Boolean)a.a().allowSprint.value).booleanValue() && Arrays.asList(((bl)enum_).a).contains((Object)Input.SPRINT)) continue;
            bl[] blArray2 = blArray;
            int n3 = blArray.length;
            for (int i = 0; i < n3; ++i) {
                bl bl2 = blArray2[i];
                if (!((Boolean)a.a().allowSprint.value).booleanValue() && Arrays.asList(bl2.a).contains((Object)Input.SPRINT)) continue;
                br2.a((pr)iPlayerContext.player(), iPlayerContext);
                ((bl)enum_).a(br2, iPlayerContext);
                double d = bl2.a(br2, iPlayerContext).f(aui2);
                if (nz2 != null && !(d < (Double)nz2.b())) continue;
                nz2 = new nz((Object)enum_, (Object)d);
            }
        }
        if (nz2 != null) {
            enumArray = ((bl)((Object)((Object)nz2.a()))).a;
            n2 = ((bl)((Object)((Object)nz2.a()))).a.length;
            for (n = 0; n < n2; ++n) {
                enum_ = enumArray[n];
                q2.a((Input)enum_, true);
            }
        }
    }

    public static void a(q q2, IPlayerContext iPlayerContext) {
        br br2 = new br(iPlayerContext.world());
        Enum[] enumArray = bl.values();
        nz nz2 = null;
        for (Enum enum_ : enumArray) {
            if (!((Boolean)a.a().allowSprint.value).booleanValue() && Arrays.asList(((bl)enum_).a).contains((Object)Input.SPRINT)) continue;
            br2.a((pr)iPlayerContext.player(), iPlayerContext);
            ((bl)enum_).a(br2, iPlayerContext);
            double d = br2.d * br2.d + br2.e * br2.e;
            if (nz2 != null && !(d < (Double)nz2.b())) continue;
            nz2 = new nz((Object)enum_, (Object)d);
        }
        if (nz2 != null) {
            enumArray = ((bl)((Object)((Object)nz2.a()))).a;
            int n = ((bl)((Object)((Object)nz2.a()))).a.length;
            for (int i = 0; i < n; ++i) {
                Enum enum_;
                enum_ = enumArray[i];
                q2.a((Input)enum_, true);
            }
        }
    }

    public static void a(bn bn2, IPlayerContext iPlayerContext) {
        br br2 = new br(iPlayerContext.world());
        Enum[] enumArray = bl.values();
        nz nz2 = null;
        for (Enum enum_ : enumArray) {
            if (!((Boolean)a.a().allowSprint.value).booleanValue() && Arrays.asList(((bl)enum_).a).contains((Object)Input.SPRINT)) continue;
            br2.a((pr)iPlayerContext.player(), iPlayerContext);
            ((bl)enum_).a(br2, iPlayerContext);
            double d = br2.d * br2.d + br2.e * br2.e;
            if (nz2 != null && !(d < (Double)nz2.b())) continue;
            nz2 = new nz((Object)enum_, (Object)d);
        }
        if (nz2 != null) {
            enumArray = ((bl)((Object)((Object)nz2.a()))).a;
            int n = ((bl)((Object)((Object)nz2.a()))).a.length;
            for (int i = 0; i < n; ++i) {
                Enum enum_;
                enum_ = enumArray[i];
                bn2.setInputForceState((Input)enum_, true);
            }
        }
    }

    public static boolean b(afh afh2) {
        return afh2 == afi.i || afh2 == afi.j;
    }

    public static boolean c(afh afh2) {
        return afh2 == afi.k || afh2 == afi.l;
    }

    public static boolean c(IPlayerContext iPlayerContext, cj cj2) {
        return bj.a(iPlayerContext, cj2) instanceof ahv;
    }

    public static boolean b(alz alz2) {
        return alz2.c() instanceof ahv && (Integer)alz2.b((amo)ahv.b) != 0;
    }

    public static boolean a(int n, int n2, int n3, alz alz2, bj bj2) {
        if (!(alz2.c() instanceof ahv)) {
            return false;
        }
        if ((Integer)alz2.b((amo)ahv.b) != 0) {
            return true;
        }
        return p.b(bj2.a(n + 1, n2, n3)) || p.b(bj2.a(n - 1, n2, n3)) || p.b(bj2.a(n, n2, n3 + 1)) || p.b(bj2.a(n, n2, n3 - 1));
    }
}
