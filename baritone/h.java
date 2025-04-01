/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongSupplier;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class h {
    public final long[] a;

    public h() {
        this(System.nanoTime() ^ System.currentTimeMillis());
    }

    private h(long l) {
        LongSupplier longSupplier = () -> h.a(new AtomicLong(l));
        this.a = new long[]{longSupplier.getAsLong(), longSupplier.getAsLong(), longSupplier.getAsLong(), longSupplier.getAsLong()};
    }

    public h(long[] lArray) {
        this.a = lArray;
    }

    public final double a() {
        return (double)(this.a() >>> 11) * (double)1.110223E-16f;
    }

    private long a() {
        long l = h.a(this.a[0] + this.a[3], 23) + this.a[0];
        long l2 = this.a[1] << 17;
        this.a[2] = this.a[2] ^ this.a[0];
        this.a[3] = this.a[3] ^ this.a[1];
        this.a[1] = this.a[1] ^ this.a[2];
        this.a[0] = this.a[0] ^ this.a[3];
        this.a[2] = this.a[2] ^ l2;
        this.a[3] = h.a(this.a[3], 45);
        return l;
    }

    private static long a(long l, int n) {
        return l << n | l >>> 64 - n;
    }

    private static /* synthetic */ long a(AtomicLong atomicLong) {
        long l = atomicLong.addAndGet(-7046029254386353131L);
        long l2 = (l ^ l >>> 30) * -4658895280553007687L;
        long l3 = (l2 ^ l2 >>> 27) * -7723592293110705685L;
        return l3 ^ l3 >>> 31;
    }
}
