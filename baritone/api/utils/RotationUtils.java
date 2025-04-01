/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  agv
 *  alz
 *  auh
 *  auh$a
 *  aui
 *  bew
 *  cj
 *  df
 *  ns
 *  pk
 */
package baritone.api.utils;

import baritone.api.BaritoneAPI;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.RayTraceUtils;
import baritone.api.utils.Rotation;
import baritone.api.utils.VecUtils;
import java.util.Optional;

public final class RotationUtils {
    public static final double DEG_TO_RAD = Math.PI / 180;
    public static final double RAD_TO_DEG = 57.29577951308232;
    private static final aui[] BLOCK_SIDE_MULTIPLIERS = new aui[]{new aui(0.5, 0.0, 0.5), new aui(0.5, 1.0, 0.5), new aui(0.5, 0.5, 0.0), new aui(0.5, 0.5, 1.0), new aui(0.0, 0.5, 0.5), new aui(1.0, 0.5, 0.5)};

    private RotationUtils() {
    }

    public static Rotation calcRotationFromCoords(cj cj2, cj cj3) {
        return RotationUtils.calcRotationFromVec3d(new aui((df)cj2), new aui((df)cj3));
    }

    public static Rotation wrapAnglesToRelative(Rotation rotation, Rotation rotation2) {
        if (rotation.yawIsReallyClose(rotation2)) {
            return new Rotation(rotation.getYaw(), rotation2.getPitch());
        }
        return rotation2.subtract(rotation).normalize().add(rotation);
    }

    public static Rotation calcRotationFromVec3d(aui aui2, aui aui3, Rotation rotation) {
        return RotationUtils.wrapAnglesToRelative(rotation, RotationUtils.calcRotationFromVec3d(aui2, aui3));
    }

    public static Rotation calcRotationFromVec3d(aui object, aui aui2) {
        double[] dArray = new double[]{object.a - aui2.a, object.b - aui2.b, object.c - aui2.c};
        object = dArray;
        double d = ns.b((double)dArray[0], (double)(-object[2]));
        double d2 = Math.sqrt((double)(object[0] * object[0] + object[2] * object[2]));
        double d3 = ns.b((double)object[1], (double)d2);
        return new Rotation((float)(d * 57.29577951308232), (float)(d3 * 57.29577951308232));
    }

    public static aui calcVec3dFromRotation(Rotation rotation) {
        float f = ns.b((float)(-rotation.getYaw() * ((float)Math.PI / 180) - (float)Math.PI));
        float f2 = ns.a((float)(-rotation.getYaw() * ((float)Math.PI / 180) - (float)Math.PI));
        float f3 = -ns.b((float)(-rotation.getPitch() * ((float)Math.PI / 180)));
        float f4 = ns.a((float)(-rotation.getPitch() * ((float)Math.PI / 180)));
        return new aui((double)(f2 * f3), (double)f4, (double)(f * f3));
    }

    public static Optional<Rotation> reachable(IPlayerContext iPlayerContext, cj cj2) {
        return RotationUtils.reachable(iPlayerContext.player(), cj2, iPlayerContext.playerController().getBlockReachDistance());
    }

    public static Optional<Rotation> reachable(IPlayerContext iPlayerContext, cj cj2, boolean bl) {
        return RotationUtils.reachable(iPlayerContext.player(), cj2, iPlayerContext.playerController().getBlockReachDistance(), bl);
    }

    public static Optional<Rotation> reachable(bew bew2, cj cj2, double d) {
        return RotationUtils.reachable(bew2, cj2, d, false);
    }

    public static Optional<Rotation> reachable(bew bew2, cj cj2, double d, boolean bl) {
        alz alz2;
        Optional<Rotation> optional;
        if (BaritoneAPI.getProvider().getBaritoneForPlayer(bew2).getPlayerContext().isLookingAt(cj2)) {
            optional = new Rotation(bew2.y, bew2.z + 1.0E-4f);
            if (bl) {
                alz2 = RayTraceUtils.rayTraceTowards((pk)bew2, (Rotation)((Object)optional), d, true);
                if (alz2 != null && alz2.a == auh.a.b && alz2.a().equals((Object)cj2)) {
                    return Optional.of(optional);
                }
            } else {
                return Optional.of(optional);
            }
        }
        if ((optional = RotationUtils.reachableCenter((pk)bew2, cj2, d, bl)).isPresent()) {
            return optional;
        }
        alz2 = bew2.o.p(cj2);
        alz2 = alz2.c().a(bew2.o, cj2, alz2);
        aui[] auiArray = BLOCK_SIDE_MULTIPLIERS;
        int n = BLOCK_SIDE_MULTIPLIERS.length;
        for (int i = 0; i < n; ++i) {
            optional = auiArray[i];
            double d2 = alz2.a * ((aui)optional).a + alz2.d * (1.0 - ((aui)optional).a);
            double d3 = alz2.b * ((aui)optional).b + alz2.e * (1.0 - ((aui)optional).b);
            double d4 = alz2.c * ((aui)optional).c + alz2.f * (1.0 - ((aui)optional).c);
            optional = RotationUtils.reachableOffset((pk)bew2, cj2, new aui((df)cj2).b(d2, d3, d4), d, bl);
            if (!optional.isPresent()) continue;
            return optional;
        }
        return Optional.empty();
    }

    public static Optional<Rotation> reachableOffset(pk pk2, cj cj2, aui object, double d, boolean bl) {
        object = RotationUtils.calcRotationFromVec3d(bl ? RayTraceUtils.inferSneakingEyePosition(pk2) : pk2.e(1.0f), object, new Rotation(pk2.y, pk2.z));
        auh auh2 = RayTraceUtils.rayTraceTowards(pk2, (Rotation)object, d, bl);
        if (auh2 != null && auh2.a == auh.a.b) {
            if (auh2.a().equals((Object)cj2)) {
                return Optional.of(object);
            }
            if (pk2.o.p(cj2).c() instanceof agv && auh2.a().equals((Object)cj2.b())) {
                return Optional.of(object);
            }
        }
        return Optional.empty();
    }

    public static Optional<Rotation> reachableCenter(pk pk2, cj cj2, double d, boolean bl) {
        return RotationUtils.reachableOffset(pk2, cj2, VecUtils.calculateBlockCenter(pk2.o, cj2), d, bl);
    }
}
