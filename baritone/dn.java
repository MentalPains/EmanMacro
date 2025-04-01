/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import java.io.Serializable;

public final class dn {
    public static long[] a(long[] lArray, int n, int n2) {
        if (n > lArray.length) {
            long[] lArray2 = new long[(int)Math.max(Math.min(2L * (long)lArray.length, 0x7FFFFFF7L), (long)n)];
            System.arraycopy(lArray, 0, lArray2, 0, n2);
            return lArray2;
        }
        return lArray;
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
    }
}
