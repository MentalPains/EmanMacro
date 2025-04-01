/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adm
 *  agv
 *  alz
 *  aui
 *  cj
 *  pk
 */
package baritone.api.utils;

public final class VecUtils {
    private VecUtils() {
    }

    public static aui calculateBlockCenter(adm adm2, cj cj2) {
        alz alz2 = adm2.p(cj2);
        adm2 = alz2.c().a(adm2, cj2, alz2);
        double d = (adm2.a + adm2.d) / 2.0;
        double d2 = (adm2.b + adm2.e) / 2.0;
        double d3 = (adm2.c + adm2.f) / 2.0;
        if (alz2.c() instanceof agv) {
            d2 = 0.0;
        }
        return new aui((double)cj2.n() + d, (double)cj2.o() + d2, (double)cj2.p() + d3);
    }

    public static aui getBlockPosCenter(cj cj2) {
        return new aui((double)cj2.n() + 0.5, (double)cj2.o() + 0.5, (double)cj2.p() + 0.5);
    }

    public static double distanceToCenter(cj cj2, double d, double d2, double d3) {
        double d4 = (double)cj2.n() + 0.5 - d;
        double d5 = (double)cj2.o() + 0.5 - d2;
        double d6 = (double)cj2.p() + 0.5 - d3;
        double d7 = d4;
        double d8 = d5;
        double d9 = d6;
        return Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
    }

    public static double entityDistanceToCenter(pk pk2, cj cj2) {
        return VecUtils.distanceToCenter(cj2, pk2.s, pk2.t, pk2.u);
    }

    public static double entityFlatDistanceToCenter(pk pk2, cj cj2) {
        return VecUtils.distanceToCenter(cj2, pk2.s, (double)cj2.o() + 0.5, pk2.u);
    }
}
