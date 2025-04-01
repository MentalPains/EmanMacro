/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  auh
 *  aui
 *  pk
 */
package baritone.api.utils;

import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.api.utils.RotationUtils;

public final class RayTraceUtils {
    private RayTraceUtils() {
    }

    public static auh rayTraceTowards(pk pk2, Rotation rotation, double d) {
        return RayTraceUtils.rayTraceTowards(pk2, rotation, d, false);
    }

    public static auh rayTraceTowards(pk pk2, Rotation rotation, double d, boolean bl) {
        aui aui2 = bl ? RayTraceUtils.inferSneakingEyePosition(pk2) : pk2.e(1.0f);
        rotation = RotationUtils.calcVec3dFromRotation(rotation);
        rotation = aui2.b(((aui)rotation).a * d, ((aui)rotation).b * d, ((aui)rotation).c * d);
        return pk2.o.a(aui2, (aui)rotation, false, false, true);
    }

    public static aui inferSneakingEyePosition(pk pk2) {
        return new aui(pk2.s, pk2.t + IPlayerContext.eyeHeight(true), pk2.u);
    }
}
