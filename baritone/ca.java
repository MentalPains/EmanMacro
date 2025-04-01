/*
 * Decompiled with CFR 0.152.
 */
package baritone;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ca {
    public static final long a(long l) {
        long l2 = l * -7046029254386353131L;
        long l3 = l2 ^ l2 >>> 32;
        return l3 ^ l3 >>> 16;
    }

    public static final int a(double d) {
        long l = Double.doubleToRawLongBits(d);
        return (int)(l ^ l >>> 32);
    }

    public static final int a(long l) {
        long l2 = l;
        return (int)(l2 ^ l2 >>> 32);
    }

    public static long b(long l) {
        if (l == 0L) {
            return 1L;
        }
        long l2 = l - 1L;
        long l3 = l2 | l2 >> 1;
        long l4 = l3 | l3 >> 2;
        long l5 = l4 | l4 >> 4;
        long l6 = l5 | l5 >> 8;
        long l7 = l6 | l6 >> 16;
        return (l7 | l7 >> 32) + 1L;
    }

    public static int a(int n, float f) {
        return Math.min((int)Math.ceil((float)n * f), n - 1);
    }

    public static int b(int n, float f) {
        long l = Math.max(2L, ca.b((long)Math.ceil((float)n / f)));
        if (l > 0x40000000L) {
            throw new IllegalArgumentException("Too large (" + n + " expected elements with load factor " + f + ")");
        }
        return (int)l;
    }

    static {
        new Object();
    }
}
