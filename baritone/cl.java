/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import java.io.Serializable;

public final class cl {
    public static double[] a(double[] dArray, int n, int n2) {
        if (n > dArray.length) {
            double[] dArray2 = new double[(int)Math.max(Math.min(2L * (long)dArray.length, 0x7FFFFFF7L), (long)n)];
            System.arraycopy(dArray, 0, dArray2, 0, n2);
            return dArray2;
        }
        return dArray;
    }

    static {
        new b();
        new a(0);
    }

    static final class a
    implements Serializable {
        private a() {
        }

        /* synthetic */ a(byte by) {
            this();
        }
    }

    public static final class b {
        private int a = -1;
        private int b = -1;
        private int c = -1;

        protected b() {
        }

        public final String toString() {
            return "Segment [offset=" + this.a + ", length=" + this.b + ", level=" + this.c + "]";
        }

        public static void a(int n, int n2, int n3) {
            if (n2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Start index (" + n2 + ") is negative");
            }
            if (n2 > n3) {
                throw new IllegalArgumentException("Start index (" + n2 + ") is greater than end index (" + n3 + ")");
            }
            if (n3 > n) {
                throw new ArrayIndexOutOfBoundsException("End index (" + n3 + ") is greater than array length (" + n + ")");
            }
        }
    }
}
