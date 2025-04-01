/*
 * Decompiled with CFR 0.152.
 */
package baritone;

public static final class cl.b {
    private int a = -1;
    private int b = -1;
    private int c = -1;

    protected cl.b() {
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
