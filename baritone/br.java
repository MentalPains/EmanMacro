/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adm
 *  agt
 *  agu
 *  akl
 *  arm
 *  aug
 *  cj
 *  ns
 *  pk
 *  pr
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.utils.IPlayerContext;
import java.util.Iterator;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class br {
    private adm a;
    public double a;
    public double b;
    public double c;
    public double d;
    private double f;
    public double e;
    private aug a;
    private boolean b;
    public float a;
    public float b;
    private float e;
    private boolean c;
    private boolean d;
    private boolean e;
    private float f;
    private boolean f;
    public boolean a;
    private float g;
    public float c;
    public float d;

    public br(adm adm2) {
        this.a = adm2;
    }

    public final void a(pr pr2, IPlayerContext iPlayerContext) {
        this.a = pr2.s;
        this.b = pr2.t;
        this.c = pr2.u;
        this.d = pr2.v;
        this.f = pr2.w;
        this.e = pr2.x;
        this.a = pr2.aR();
        this.b = pr2.C;
        this.a = pr2.aM;
        this.b = pr2.bI();
        this.e = pr2.O;
        this.c = pr2.F;
        this.d = pr2.D;
        this.e = pr2.E;
        this.f = iPlayerContext.playerRotations().getYaw();
        this.f = pr2.T;
        this.a = pr2.av();
        this.g = pr2.S;
        this.c = 0.0f;
        this.d = 0.0f;
    }

    private boolean a() {
        return this.a.a(this.a.b((double)-0.1f, (double)-0.4f, (double)-0.1f), arm.i);
    }

    private boolean b() {
        return this.a.a(this.a.b((double)-0.1f, (double)-0.4f, (double)-0.1f), arm.h);
    }

    private boolean a(double d, double d2, double d3) {
        aug aug2 = this.a.c(d, d2, d3);
        return this.a.a(aug2.b((double)-0.1f, (double)-0.4f, (double)-0.1f), arm.h) || this.a.a(aug2.b((double)-0.1f, (double)-0.4f, (double)-0.1f), arm.i);
    }

    public final void a() {
        if (Math.abs(this.d) < 0.005) {
            this.d = 0.0;
        }
        if (Math.abs(this.f) < 0.005) {
            this.f = 0.0;
        }
        if (Math.abs(this.e) < 0.005) {
            this.e = 0.0;
        }
        this.c *= 0.98f;
        this.d *= 0.98f;
        br br2 = this;
        br2.a(br2.c, this.d);
    }

    private void a(float f, float f2) {
        if (!this.b()) {
            if (!this.a()) {
                float f3 = 0.91f;
                if (this.b) {
                    f3 = this.a.p((cj)new cj((int)ns.c((double)this.a), (int)(ns.c((double)this.a.b) - 1), (int)ns.c((double)this.c))).c().L * 0.91f;
                }
                float f4 = f3;
                float f5 = 0.16277136f / (f4 * f4 * f3);
                float f6 = this.b ? this.b * f5 : this.a;
                this.a(f, f2, f6);
                f3 = 0.91f;
                if (this.b) {
                    f3 = this.a.p((cj)new cj((int)ns.c((double)this.a), (int)(ns.c((double)this.a.b) - 1), (int)ns.c((double)this.c))).c().L * 0.91f;
                }
                br br2 = this;
                br2.a(br2.d, this.f, this.e);
                double d = !(!this.a.D || this.a.e(new cj((int)this.a, 0, (int)this.c)) && this.a.f(new cj((int)this.a, 0, (int)this.c)).o()) ? (this.b > 0.0 ? -0.1 : 0.0) : (this.f = this.f - 0.08);
                this.f = d;
                this.f *= (double)0.98f;
                this.d *= (double)f3;
                this.e *= (double)f3;
                return;
            }
            double d = this.b;
            this.a(f, f2, 0.02f);
            br br3 = this;
            br3.a(br3.d, this.f, this.e);
            this.d *= 0.5;
            this.f *= 0.5;
            this.e *= 0.5;
            this.f -= 0.02;
            if (this.d) {
                br br4 = this;
                if (br4.a(br4.d, this.f + (double)0.6f - this.b + d, this.e)) {
                    this.f = 0.3f;
                }
            }
            return;
        }
        double d = this.b;
        float f7 = 1.0f;
        if (!this.b) {
            f7 = 0.5f;
        }
        float f8 = 0.8f + -0.25399995f * f7 / 3.0f;
        f7 = 0.02f + (this.b - 0.02f) * f7 / 3.0f;
        this.a(f, f2, f7);
        br br5 = this;
        br5.a(br5.d, this.f, this.e);
        this.d *= (double)f8;
        this.f *= (double)0.8f;
        this.e *= (double)f8;
        this.f -= 0.02;
        if (this.d) {
            br br6 = this;
            if (br6.a(br6.d, this.f + (double)0.6f - this.b + d, this.e)) {
                this.f = 0.3f;
            }
        }
    }

    private void a(float f, float f2, float f3) {
        float f4;
        float f5 = f;
        float f6 = f2;
        float f7 = f5 * f5 + f6 * f6;
        if (f4 >= 1.0E-4f) {
            float f8;
            f7 = ns.c((float)f7);
            if (f8 < 1.0f) {
                f7 = 1.0f;
            }
            f7 = f3 / f7;
            f3 = ns.a((float)(this.f * (float)Math.PI / 180.0f));
            float f9 = ns.b((float)(this.f * (float)Math.PI / 180.0f));
            this.d += (double)((f *= f7) * f9 - (f2 *= f7) * f3);
            this.e += (double)(f2 * f9 + f * f3);
        }
    }

    private void a(double d, double d2, double d3) {
        Object object = BaritoneAPI.getProvider().getPrimaryBaritone().getPlayerContext().player();
        if (this.f) {
            this.a = this.a.c(d, d2, d3);
            this.b();
            return;
        }
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        if (this.b && this.a) {
            while (d != 0.0 && this.a.a((pk)object, this.a.c(d, -1.0, 0.0)).isEmpty()) {
                d = d < 0.05 && d >= -0.05 ? 0.0 : (d > 0.0 ? d - 0.05 : d + 0.05);
                d4 = d;
            }
            while (d3 != 0.0 && this.a.a((pk)object, this.a.c(0.0, -1.0, d3)).isEmpty()) {
                d3 = d3 < 0.05 && d3 >= -0.05 ? 0.0 : (d3 > 0.0 ? d3 - 0.05 : d3 + 0.05);
                d6 = d3;
            }
            while (d != 0.0 && d3 != 0.0 && this.a.a((pk)object, this.a.c(d, -1.0, d3)).isEmpty()) {
                d = d < 0.05 && d >= -0.05 ? 0.0 : (d > 0.0 ? d - 0.05 : d + 0.05);
                d4 = d;
                d3 = d3 < 0.05 && d3 >= -0.05 ? 0.0 : (d3 > 0.0 ? d3 - 0.05 : d3 + 0.05);
                d6 = d3;
            }
        }
        List list = this.a.a((pk)object, this.a.a(d, d2, d3));
        aug aug2 = this.a;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            d2 = ((aug)iterator.next()).b(this.a, d2);
        }
        this.a = this.a.c(0.0, d2, 0.0);
        boolean bl = this.b || d5 != d2 && d5 < 0.0;
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            d = ((aug)iterator2.next()).a(this.a, d);
        }
        this.a = this.a.c(d, 0.0, 0.0);
        iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            d3 = ((aug)iterator2.next()).c(this.a, d3);
        }
        this.a = this.a.c(0.0, 0.0, d3);
        if (this.g > 0.0f && bl && (d4 != d || d6 != d3)) {
            double d7 = d;
            double d8 = d2;
            double d9 = d3;
            list = this.a;
            this.a = aug2;
            d2 = this.g;
            object = this.a.a((pk)object, this.a.a(d4, d2, d6));
            aug2 = this.a;
            aug aug3 = aug2.a(d4, 0.0, d6);
            double d10 = d2;
            Iterator iterator3 = object.iterator();
            while (iterator3.hasNext()) {
                d10 = ((aug)iterator3.next()).b(aug3, d10);
            }
            aug2 = aug2.c(0.0, d10, 0.0);
            double d11 = d4;
            Iterator iterator4 = object.iterator();
            while (iterator4.hasNext()) {
                d11 = ((aug)iterator4.next()).a(aug2, d11);
            }
            aug2 = aug2.c(d11, 0.0, 0.0);
            double d12 = d6;
            aug aug4 = object.iterator();
            while (aug4.hasNext()) {
                d12 = ((aug)aug4.next()).c(aug2, d12);
            }
            aug2 = aug2.c(0.0, 0.0, d12);
            aug4 = this.a;
            double d13 = d2;
            Iterator iterator5 = object.iterator();
            while (iterator5.hasNext()) {
                d13 = ((aug)iterator5.next()).b(aug4, d13);
            }
            aug4 = aug4.c(0.0, d13, 0.0);
            double d14 = d4;
            Iterator iterator6 = object.iterator();
            while (iterator6.hasNext()) {
                d14 = ((aug)iterator6.next()).a(aug4, d14);
            }
            aug4 = aug4.c(d14, 0.0, 0.0);
            double d15 = d6;
            Iterator iterator7 = object.iterator();
            while (iterator7.hasNext()) {
                d15 = ((aug)iterator7.next()).c(aug4, d15);
            }
            aug4 = aug4.c(0.0, 0.0, d15);
            double d16 = d11;
            double d17 = d12;
            double d18 = d16 * d16 + d17 * d17;
            double d19 = d14;
            double d20 = d15;
            double d21 = d19 * d19 + d20 * d20;
            if (d18 > d21) {
                d = d11;
                d3 = d12;
                d2 = -d10;
                this.a = aug2;
            } else {
                d = d14;
                d3 = d15;
                d2 = -d13;
                this.a = aug4;
            }
            object = object.iterator();
            while (object.hasNext()) {
                d2 = ((aug)object.next()).b(this.a, d2);
            }
            this.a = this.a.c(0.0, d2, 0.0);
            double d22 = d7;
            double d23 = d9;
            double d24 = d;
            double d25 = d3;
            if (d22 * d22 + d23 * d23 >= d24 * d24 + d25 * d25) {
                d = d7;
                d2 = d8;
                d3 = d9;
                this.a = list;
            }
        }
        this.b();
        this.d = d4 != d || d6 != d3;
        this.e = d5 != d2;
        this.b = this.e && d5 < 0.0;
        this.c = this.d || this.e;
        int n = ns.c((double)this.a);
        int n2 = ns.c((double)(this.b - (double)0.2f));
        int n3 = ns.c((double)this.c);
        cj cj2 = new cj(n, n2, n3);
        if (this.a.p(cj2).c().t() == arm.a && ((object = this.a.p(cj2.b()).c()) instanceof agt || object instanceof akl || object instanceof agu)) {
            cj2.b();
        }
        boolean bl2 = this.b;
        double d26 = d2;
        object = this;
        if (bl2) {
            if (((br)object).e > 0.0f) {
                ((br)object).e = 0.0f;
            }
        } else if (d26 < 0.0) {
            ((br)object).e = (float)((double)((br)object).e - d26);
        }
        if (d4 != d) {
            this.d = 0.0;
        }
        if (d6 != d3) {
            this.e = 0.0;
        }
        if (d5 != d2) {
            this.f = 0.0;
        }
    }

    private void b() {
        this.a = (this.a.a + this.a.d) / 2.0;
        this.b = this.a.b;
        this.c = (this.a.c + this.a.f) / 2.0;
    }
}
