/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ack
 *  adm
 *  afh
 *  alz
 *  bew
 *  cj
 *  pk
 */
package baritone.pathing.movement;

import baritone.a;
import baritone.api.IBaritone;
import baritone.b;
import baritone.bf;
import baritone.bj;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
@b
public class CalculationContext {
    public final boolean a;
    public final IBaritone a;
    public final adm a;
    public final bj a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    private boolean i;
    public final int a;
    public final double a;
    private double d;
    public final double b;
    public final double c;
    public final bf a = new bf();

    public CalculationContext(IBaritone iBaritone) {
        this(iBaritone, false);
    }

    public CalculationContext(IBaritone iBaritone, boolean bl) {
        this.a = bl;
        this.a = iBaritone;
        bew bew2 = iBaritone.getPlayerContext().player();
        this.a = iBaritone.getPlayerContext().world();
        this.a = new bj(iBaritone.getPlayerContext(), bl);
        this.b = (Boolean)baritone.a.a().allowSprint.value != false && bew2.cl().a() > 6;
        this.c = (Boolean)baritone.a.a().allowParkour.value;
        this.d = (Boolean)baritone.a.a().allowJumpAt256.value;
        this.e = (Boolean)baritone.a.a().allowParkourAscend.value;
        this.f = (Boolean)baritone.a.a().assumeWalkOnWater.value;
        this.g = (Boolean)baritone.a.a().allowDiagonalDescend.value;
        this.h = (Boolean)baritone.a.a().allowDiagonalAscend.value;
        this.i = (Boolean)baritone.a.a().allowDownward.value;
        this.a = (Integer)baritone.a.a().maxFallHeightNoWater.value;
        int n = ack.b((pk)bew2);
        if (n > 3) {
            n = 3;
        }
        float f = (float)n / 3.0f;
        this.a = 9.09090909090909 * (double)(1.0f - f) + 4.63284688441047 * (double)f;
        this.d = (Double)baritone.a.a().backtrackCostFavoringCoefficient.value;
        this.b = (Double)baritone.a.a().jumpPenalty.value;
        this.c = (Double)baritone.a.a().walkOnWaterOnePenalty.value;
    }

    public final alz a(int n, int n2, int n3) {
        return this.a.a(n, n2, n3);
    }

    public final boolean a(int n, int n2) {
        return this.a.b(n, n2);
    }

    public final alz a(cj cj2) {
        return this.a(cj2.n(), cj2.o(), cj2.p());
    }

    public final afh a(int n, int n2, int n3) {
        return this.a(n, n2, n3).c();
    }
}
