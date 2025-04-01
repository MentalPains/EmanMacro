/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.cd;
import baritone.ci;
import baritone.cj;
import baritone.cp;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class cs
extends ci
implements Serializable,
Cloneable {
    protected transient double[] a;
    protected transient int a;
    protected transient boolean a;
    protected transient int b = ca.b(16, 0.75f);
    private transient int d;
    protected int c;
    private float a = this.b - 1;

    private cs() {
        this.d = ca.a(this.b, 0.75f);
        this.a = new double[this.b + 1];
    }

    public cs(byte by) {
        this();
    }

    private int a() {
        if (this.a) {
            return this.c - 1;
        }
        return this.c;
    }

    @Override
    public final boolean addAll(Collection<? extends Double> collection) {
        if ((double)this.a <= 0.5) {
            int n = collection.size();
            cs cs2 = this;
            int n2 = ca.b(n, cs2.a);
            if (n2 > cs2.b) {
                cs2.a(n2);
            }
        } else {
            cs cs3 = this;
            long l = cs3.size() + collection.size();
            cs cs4 = cs3;
            int n = (int)Math.min(0x40000000L, Math.max(2L, ca.b((long)Math.ceil((float)l / cs4.a))));
            if (n > cs4.b) {
                cs4.a(n);
            }
        }
        return super.addAll(collection);
    }

    @Override
    public final boolean a(double d) {
        if (Double.doubleToLongBits(d) == 0L) {
            if (this.a) {
                return false;
            }
            this.a = true;
        } else {
            double[] dArray = this.a;
            int n = (int)ca.a(Double.doubleToRawLongBits(d)) & this.a;
            double d2 = this.a[n];
            if (Double.doubleToLongBits(d2) != 0L) {
                if (Double.doubleToLongBits(d2) == Double.doubleToLongBits(d)) {
                    return false;
                }
                while (Double.doubleToLongBits(d2 = dArray[n = n + 1 & this.a]) != 0L) {
                    if (Double.doubleToLongBits(d2) != Double.doubleToLongBits(d)) continue;
                    return false;
                }
            }
            dArray[n] = d;
        }
        if (this.c++ >= this.d) {
            cs cs2 = this;
            cs2.a(ca.b(cs2.c + 1, this.a));
        }
        return true;
    }

    private boolean a(int n) {
        --this.c;
        int n2 = n;
        cs cs2 = this;
        double[] dArray = cs2.a;
        block0: while (true) {
            double d;
            int n3 = n2;
            n2 = n3 + 1 & cs2.a;
            while (true) {
                if (Double.doubleToLongBits(d = dArray[n2]) == 0L) break block0;
                int n4 = (int)ca.a(Double.doubleToRawLongBits(d)) & cs2.a;
                if (n3 > n2 ? n3 >= n4 && n4 > n2 : n3 >= n4 || n4 > n2) break;
                n2 = n2 + 1 & cs2.a;
            }
            dArray[n3] = d;
        }
        dArray[n3] = 0.0;
        if (this.c < this.d / 4 && this.b > 16) {
            cs cs3 = this;
            cs3.a(cs3.b / 2);
        }
        return true;
    }

    @Override
    public final boolean c(double d) {
        if (Double.doubleToLongBits(d) == 0L) {
            if (this.a) {
                cs cs2 = this;
                this.a = false;
                cs2.a[cs2.b] = 0.0;
                --cs2.c;
                if (cs2.c < cs2.d / 4 && cs2.b > 16) {
                    cs cs3 = cs2;
                    cs3.a(cs3.b / 2);
                }
                return true;
            }
            return false;
        }
        double[] dArray = this.a;
        int n = (int)ca.a(Double.doubleToRawLongBits(d)) & this.a;
        double d2 = this.a[n];
        if (Double.doubleToLongBits(d2) == 0L) {
            return false;
        }
        if (Double.doubleToLongBits(d) == Double.doubleToLongBits(d2)) {
            return this.a(n);
        }
        do {
            if (Double.doubleToLongBits(d2 = dArray[n = n + 1 & this.a]) != 0L) continue;
            return false;
        } while (Double.doubleToLongBits(d) != Double.doubleToLongBits(d2));
        return this.a(n);
    }

    @Override
    public final boolean b(double d) {
        if (Double.doubleToLongBits(d) == 0L) {
            return this.a;
        }
        double[] dArray = this.a;
        int n = (int)ca.a(Double.doubleToRawLongBits(d)) & this.a;
        double d2 = this.a[n];
        if (Double.doubleToLongBits(d2) == 0L) {
            return false;
        }
        if (Double.doubleToLongBits(d) == Double.doubleToLongBits(d2)) {
            return true;
        }
        do {
            if (Double.doubleToLongBits(d2 = dArray[n = n + 1 & this.a]) != 0L) continue;
            return false;
        } while (Double.doubleToLongBits(d) != Double.doubleToLongBits(d2));
        return true;
    }

    @Override
    public final void clear() {
        if (this.c == 0) {
            return;
        }
        this.c = 0;
        this.a = false;
        Arrays.fill(this.a, 0.0);
    }

    @Override
    public final int size() {
        return this.c;
    }

    @Override
    public final boolean isEmpty() {
        return this.c == 0;
    }

    @Override
    public final cp a() {
        return new a(this, 0);
    }

    private void a(int n) {
        double[] dArray = this.a;
        int n2 = n - 1;
        double[] dArray2 = new double[n + 1];
        int n3 = this.b;
        int n4 = this.a();
        while (n4-- != 0) {
            while (Double.doubleToLongBits(dArray[--n3]) == 0L) {
            }
            int n5 = (int)ca.a(Double.doubleToRawLongBits(dArray[n3])) & n2;
            if (Double.doubleToLongBits(dArray2[n5]) != 0L) {
                while (Double.doubleToLongBits(dArray2[n5 = n5 + 1 & n2]) != 0L) {
                }
            }
            dArray2[n5] = dArray[n3];
        }
        this.b = n;
        this.a = n2;
        this.d = ca.a(this.b, this.a);
        this.a = dArray2;
    }

    private cs a() {
        cs cs2;
        try {
            cs2 = (cs)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        cs2.a = (double[])this.a.clone();
        cs2.a = this.a;
        return cs2;
    }

    @Override
    public final int hashCode() {
        int n = 0;
        int n2 = this.a();
        int n3 = 0;
        while (n2-- != 0) {
            while (Double.doubleToLongBits(this.a[n3]) == 0L) {
                ++n3;
            }
            n += ca.a(this.a[n3]);
            ++n3;
        }
        return n;
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        return this.a();
    }

    public final /* synthetic */ Object clone() {
        return this.a();
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    final class a
    extends cd {
        private int a;
        private int b = -1;
        private int c;
        private boolean a;
        private cj a;
        private /* synthetic */ cs a;

        private a(cs cs2) {
            this.a = cs2;
            this.a = this.a.b;
            this.c = this.a.c;
            this.a = this.a.a;
        }

        @Override
        public final boolean hasNext() {
            return this.c != 0;
        }

        @Override
        public final double b() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            if (this.a) {
                this.a = false;
                this.b = this.a.b;
                return this.a.a[this.a.b];
            }
            double[] dArray = this.a.a;
            do {
                if (--this.a >= 0) continue;
                this.b = Integer.MIN_VALUE;
                return this.a.b(-this.a - 1);
            } while (Double.doubleToLongBits(dArray[this.a]) == 0L);
            this.b = this.a;
            return dArray[this.b];
        }

        private final void a(int n) {
            double[] dArray = this.a.a;
            while (true) {
                double d;
                int n2 = n;
                n = n2 + 1 & this.a.a;
                while (true) {
                    if (Double.doubleToLongBits(d = dArray[n]) == 0L) {
                        dArray[n2] = 0.0;
                        return;
                    }
                    int n3 = (int)ca.a(Double.doubleToRawLongBits(d)) & this.a.a;
                    if (n2 > n ? n2 >= n3 && n3 > n : n2 >= n3 || n3 > n) break;
                    n = n + 1 & this.a.a;
                }
                if (n < n2) {
                    if (this.a == null) {
                        this.a = new cj(2);
                    }
                    this.a.a(dArray[n]);
                }
                dArray[n2] = d;
            }
        }

        @Override
        public final void remove() {
            if (this.b == -1) {
                throw new IllegalStateException();
            }
            if (this.b == this.a.b) {
                this.a.a = false;
                this.a.a[this.a.b] = 0.0;
            } else if (this.a >= 0) {
                a a2 = this;
                a2.a(a2.b);
            } else {
                this.a.c(this.a.b(-this.a - 1));
                this.b = -1;
                return;
            }
            --this.a.c;
            this.b = -1;
        }

        /* synthetic */ a(cs cs2, byte by) {
            this(cs2);
        }
    }
}
