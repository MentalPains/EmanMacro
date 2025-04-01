/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ee;
import baritone.ef;
import baritone.ek;
import baritone.em;
import baritone.en;
import java.util.ArrayList;

public final class ev {
    public static void a(double[] dArray, int n) {
        int n2;
        double d = dArray[0];
        int n3 = dArray.length;
        block4: for (n2 = 1; n2 < n3; ++n2) {
            switch (1.a[n - 1]) {
                case 1: {
                    if (!(dArray[n2] <= d)) break;
                    break block4;
                }
                case 2: {
                    if (!(dArray[n2] >= d)) break;
                    break block4;
                }
                default: {
                    throw new ek();
                }
            }
            d = dArray[n2];
        }
        if (n2 != n3) {
            throw new em(dArray[n2], (Number)d, n2, n);
        }
    }

    public static ef a(double[] dArray, double[] dArray2) {
        ev.a(dArray, a.a);
        double[] dArray3 = new double[10];
        for (int i = 0; i < 10; ++i) {
            dArray3[i] = dArray[i + 1] - dArray[i];
        }
        double[] dArray4 = new double[10];
        double[] dArray5 = new double[11];
        dArray4[0] = 0.0;
        dArray5[0] = 0.0;
        for (int i = 1; i < 10; ++i) {
            double d = 2.0 * (dArray[i + 1] - dArray[i - 1]) - dArray3[i - 1] * dArray4[i - 1];
            dArray4[i] = dArray3[i] / d;
            dArray5[i] = (3.0 * (dArray2[i + 1] * dArray3[i - 1] - dArray2[i] * (dArray[i + 1] - dArray[i - 1]) + dArray2[i - 1] * dArray3[i]) / (dArray3[i - 1] * dArray3[i]) - dArray3[i - 1] * dArray5[i - 1]) / d;
        }
        double[] dArray6 = new double[10];
        double[] dArray7 = new double[11];
        double[] dArray8 = new double[10];
        dArray5[10] = 0.0;
        dArray7[10] = 0.0;
        for (int i = 9; i >= 0; --i) {
            dArray7[i] = dArray5[i] - dArray4[i] * dArray7[i + 1];
            dArray6[i] = (dArray2[i + 1] - dArray2[i]) / dArray3[i] - dArray3[i] * (dArray7[i + 1] + 2.0 * dArray7[i]) / 3.0;
            dArray8[i] = (dArray7[i + 1] - dArray7[i]) / (3.0 * dArray3[i]);
        }
        ee[] eeArray = new ee[10];
        dArray3 = new double[4];
        for (int i = 0; i < 10; ++i) {
            dArray3[0] = dArray2[i];
            dArray3[1] = dArray6[i];
            dArray3[2] = dArray7[i];
            dArray3[3] = dArray8[i];
            eeArray[i] = new ee(dArray3);
        }
        return new ef(dArray, eeArray);
    }

    public static Object[] a(Object[] objectArray) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (objectArray != null) {
            for (Object object : objectArray) {
                if (object instanceof Object[]) {
                    for (Object object2 : ev.a((Object[])object)) {
                        arrayList.add(object2);
                    }
                    continue;
                }
                arrayList.add(object);
            }
        }
        return arrayList.toArray();
    }

    public static void a(Object object) {
        if (object == null) {
            throw new en();
        }
    }

    static final class 1 {
        static final /* synthetic */ int[] a;
        private static /* synthetic */ int[] b;

        static {
            b = new int[baritone.ev$b.a().length];
            try {
                1.b[1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.b[0] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            a = new int[baritone.ev$a.a().length];
            try {
                1.a[0] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class b
    extends Enum<b> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] a;

        public static int[] a() {
            return (int[])a.clone();
        }

        static {
            a = new int[]{1, 2};
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class a
    extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] a;

        public static int[] a() {
            return (int[])a.clone();
        }

        static {
            a = new int[]{1, 2};
        }
    }
}
