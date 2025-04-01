/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.cv;
import baritone.dh;
import baritone.di;
import baritone.dk;
import baritone.dl;
import baritone.dr;
import baritone.dx;
import baritone.dy;
import baritone.ea;
import baritone.ec;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class dj<V>
extends cv<V>
implements Serializable,
Cloneable {
    protected transient long[] a;
    protected transient V[] a;
    protected transient int a;
    protected transient boolean a;
    protected transient int b;
    private transient int d;
    protected int c;
    private float a;
    private transient di.b<V> a;
    private transient di.b b;
    private transient dy<V> a;

    public dj(int n, float f2) {
        if (f2 <= 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (n < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.a = f2;
        this.b = ca.b(n, f2);
        this.a = this.b - 1;
        this.d = ca.a(this.b, f2);
        this.a = new long[this.b + 1];
        this.a = (long[])new Object[this.b + 1];
    }

    public dj() {
        this(16, 0.75f);
    }

    private dj(di<V> di2) {
        this(di2.size(), 0.75f);
        this.putAll(di2);
    }

    public dj(di<V> di2, byte by) {
        this(di2);
    }

    private int a() {
        if (this.a) {
            return this.c - 1;
        }
        return this.c;
    }

    private V a(int n) {
        long l = this.a[n];
        this.a[n] = (long)null;
        --this.c;
        int n2 = n;
        dj dj2 = this;
        long[] lArray = dj2.a;
        block0: while (true) {
            long l2;
            int n3 = n2;
            n2 = n3 + 1 & dj2.a;
            while (true) {
                if ((l2 = lArray[n2]) == 0L) break block0;
                int n4 = (int)ca.a(l2) & dj2.a;
                if (n3 > n2 ? n3 >= n4 && n4 > n2 : n3 >= n4 || n4 > n2) break;
                n2 = n2 + 1 & dj2.a;
            }
            lArray[n3] = l2;
            dj2.a[n3] = dj2.a[n2];
        }
        lArray[n3] = 0L;
        dj2.a[n3] = (long)null;
        if (this.c < this.d / 4 && this.b > 16) {
            dj dj3 = this;
            dj3.a(dj3.b / 2);
        }
        return l;
    }

    private V a() {
        this.a = false;
        long l = this.a[this.b];
        this.a[this.b] = (long)null;
        --this.c;
        if (this.c < this.d / 4 && this.b > 16) {
            dj dj2 = this;
            dj2.a(dj2.b / 2);
        }
        return l;
    }

    @Override
    public final void putAll(Map<? extends Long, ? extends V> map) {
        if ((double)this.a <= 0.5) {
            int n = map.size();
            dj dj2 = this;
            int n2 = ca.b(n, dj2.a);
            if (n2 > dj2.b) {
                dj2.a(n2);
            }
        } else {
            dj dj3 = this;
            long l = dj3.size() + map.size();
            dj dj4 = dj3;
            int n = (int)Math.min(0x40000000L, Math.max(2L, ca.b((long)Math.ceil((float)l / dj4.a))));
            if (n > dj4.b) {
                dj4.a(n);
            }
        }
        super.putAll(map);
    }

    @Override
    private int a(long l, V v) {
        int n;
        if (l == 0L) {
            if (this.a) {
                return this.b;
            }
            this.a = true;
            n = this.b;
        } else {
            long[] lArray = this.a;
            n = (int)ca.a(l) & this.a;
            long l2 = this.a[n];
            if (l2 != 0L) {
                if (l2 == l) {
                    return n;
                }
                while ((l2 = lArray[n = n + 1 & this.a]) != 0L) {
                    if (l2 != l) continue;
                    return n;
                }
            }
        }
        this.a[n] = l;
        this.a[n] = (long)v;
        if (this.c++ >= this.d) {
            dj dj2 = this;
            dj2.a(ca.b(dj2.c + 1, this.a));
        }
        return -1;
    }

    @Override
    public final V a(long l, V v) {
        V v2 = this.a(l, v);
        if (v2 < 0) {
            return null;
        }
        long l2 = this.a[v2];
        this.a[v2] = (long)v;
        return l2;
    }

    @Override
    @Deprecated
    public final V a(Long l, V v) {
        V v2 = this.a((long)l, v);
        if (v2 < 0) {
            return null;
        }
        long l2 = this.a[v2];
        this.a[v2] = (long)v;
        return l2;
    }

    @Override
    public final V b(long l) {
        if (l == 0L) {
            if (this.a) {
                return this.a();
            }
            return null;
        }
        long[] lArray = this.a;
        int n = (int)ca.a(l) & this.a;
        long l2 = this.a[n];
        if (l2 == 0L) {
            return null;
        }
        if (l == l2) {
            return this.a(n);
        }
        do {
            if ((l2 = lArray[n = n + 1 & this.a]) != 0L) continue;
            return null;
        } while (l != l2);
        return this.a(n);
    }

    @Override
    @Deprecated
    public final V remove(Object object) {
        long l = (Long)object;
        if (l == 0L) {
            if (this.a) {
                return this.a();
            }
            return null;
        }
        object = this.a;
        int n = (int)ca.a(l) & this.a;
        long l2 = this.a[n];
        if (l2 == 0L) {
            return null;
        }
        if (l2 == l) {
            return this.a(n);
        }
        do {
            n = n + 1 & this.a;
            Object object2 = object[n];
            l2 = (long)object2;
            if (object2 != 0L) continue;
            return null;
        } while (l2 != l);
        return this.a(n);
    }

    @Override
    public final V a(long l) {
        if (l == 0L) {
            if (this.a) {
                return this.a[this.b];
            }
            return null;
        }
        long[] lArray = this.a;
        int n = (int)ca.a(l) & this.a;
        long l2 = this.a[n];
        if (l2 == 0L) {
            return null;
        }
        if (l == l2) {
            return this.a[n];
        }
        do {
            if ((l2 = lArray[n = n + 1 & this.a]) != 0L) continue;
            return null;
        } while (l != l2);
        return this.a[n];
    }

    @Override
    public final boolean a(long l) {
        if (l == 0L) {
            return this.a;
        }
        long[] lArray = this.a;
        int n = (int)ca.a(l) & this.a;
        long l2 = this.a[n];
        if (l2 == 0L) {
            return false;
        }
        if (l == l2) {
            return true;
        }
        do {
            if ((l2 = lArray[n = n + 1 & this.a]) != 0L) continue;
            return false;
        } while (l != l2);
        return true;
    }

    @Override
    public final boolean containsValue(Object object) {
        long[] lArray = this.a;
        long[] lArray2 = this.a;
        if (this.a && (lArray[this.b] == null ? object == null : lArray[this.b].equals(object))) {
            return true;
        }
        int n = this.b;
        while (n-- != 0) {
            if (lArray2[n] == 0L || !(lArray[n] == null ? object == null : lArray[n].equals(object))) continue;
            return true;
        }
        return false;
    }

    @Override
    public final void clear() {
        if (this.c == 0) {
            return;
        }
        this.c = 0;
        this.a = false;
        Arrays.fill(this.a, 0L);
        Arrays.fill((Object[])this.a, null);
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
    public final di.b a() {
        if (this.b == null) {
            this.b = new c(this, 0);
        }
        return this.b;
    }

    @Override
    public final dy<V> a() {
        if (this.a == null) {
            this.a = (long[])new dk(this);
        }
        return this.a;
    }

    private void a(int n) {
        long[] lArray = this.a;
        long[] lArray2 = this.a;
        int n2 = n - 1;
        long[] lArray3 = new long[n + 1];
        Object[] objectArray = new Object[n + 1];
        int n3 = this.b;
        int n4 = this.a();
        while (n4-- != 0) {
            while (lArray[--n3] == 0L) {
            }
            int n5 = (int)ca.a(lArray[n3]) & n2;
            if (lArray3[n5] != 0L) {
                while (lArray3[n5 = n5 + 1 & n2] != 0L) {
                }
            }
            lArray3[n5] = lArray[n3];
            objectArray[n5] = lArray2[n3];
        }
        objectArray[n] = lArray2[this.b];
        this.b = n;
        this.a = n2;
        this.d = ca.a(this.b, this.a);
        this.a = lArray3;
        this.a = (long[])objectArray;
    }

    @Override
    private dj<V> a() {
        dj dj2;
        try {
            dj2 = (dj)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new InternalError();
        }
        dj2.b = null;
        dj2.a = null;
        dj2.a = null;
        dj2.a = this.a;
        dj2.a = (long[])this.a.clone();
        dj2.a = (long[])((Object[])this.a.clone());
        return dj2;
    }

    @Override
    public final int hashCode() {
        int n = 0;
        int n2 = this.a();
        int n3 = 0;
        while (n2-- != 0) {
            while (this.a[n3] == 0L) {
                ++n3;
            }
            int n4 = ca.a(this.a[n3]);
            dj dj2 = this;
            if (dj2 != dj2.a[n3]) {
                n4 ^= this.a[n3] == null ? 0 : this.a[n3].hashCode();
            }
            n += n4;
            ++n3;
        }
        if (this.a) {
            n += this.a[this.b] == null ? 0 : this.a[this.b].hashCode();
        }
        return n;
    }

    @Override
    public final /* synthetic */ ec a() {
        dj dj2 = this;
        if (dj2.a == null) {
            dj2.a = (long[])new e(dj2, 0);
        }
        return dj2.a;
    }

    @Override
    @Deprecated
    public final /* synthetic */ Object put(Object object, Object object2) {
        return this.a((Long)object, (V)object2);
    }

    @Override
    public final /* synthetic */ Collection values() {
        return this.a();
    }

    @Override
    public final /* synthetic */ Set keySet() {
        return this.a();
    }

    public final /* synthetic */ Object clone() {
        return this.a();
    }

    final class g
    extends f
    implements ea<V> {
        private /* synthetic */ dj a;

        public g(dj dj2) {
            this.a = dj2;
            super(dj2, (byte)0);
        }

        @Override
        public final V next() {
            return this.a.a[this.a()];
        }
    }

    final class c
    extends dh {
        private /* synthetic */ dj a;

        private c(dj dj2) {
            this.a = dj2;
        }

        @Override
        public final dr a() {
            return new b(this.a);
        }

        @Override
        public final int size() {
            return this.a.c;
        }

        @Override
        public final boolean a(long l) {
            return this.a.a(l);
        }

        @Override
        public final boolean c(long l) {
            int n = this.a.c;
            this.a.b(l);
            return this.a.c != n;
        }

        @Override
        public final void clear() {
            this.a.clear();
        }

        @Override
        public final /* synthetic */ Iterator iterator() {
            return this.a();
        }

        /* synthetic */ c(dj dj2, byte by) {
            this(dj2);
        }
    }

    final class b
    extends f
    implements dr {
        private /* synthetic */ dj a;

        public b(dj dj2) {
            this.a = dj2;
            super(dj2, (byte)0);
        }

        @Override
        public final long a() {
            return this.a.a[this.a()];
        }

        @Override
        public final /* synthetic */ Object next() {
            b b2 = this;
            return b2.a.a[b2.a()];
        }
    }

    final class e
    extends dx<di.a<V>>
    implements di.b<V> {
        private /* synthetic */ dj a;

        private e(dj dj2) {
            this.a = dj2;
        }

        @Override
        public final ea<di.a<V>> a() {
            return new a(this.a, 0);
        }

        @Override
        public final boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            if ((object = (Map.Entry)object).getKey() == null || !(object.getKey() instanceof Long)) {
                return false;
            }
            long l = (Long)object.getKey();
            object = object.getValue();
            if (l == 0L) {
                return this.a.a && (this.a.a[this.a.b] == null ? object == null : this.a.a[this.a.b].equals(object));
            }
            long[] lArray = this.a.a;
            int n = (int)ca.a(l) & this.a.a;
            long l2 = this.a.a[n];
            if (l2 == 0L) {
                return false;
            }
            if (l == l2) {
                if (this.a.a[n] == null) {
                    return object == null;
                }
                return this.a.a[n].equals(object);
            }
            do {
                if ((l2 = lArray[n = n + 1 & this.a.a]) != 0L) continue;
                return false;
            } while (l != l2);
            if (this.a.a[n] == null) {
                return object == null;
            }
            return this.a.a[n].equals(object);
        }

        @Override
        public final boolean a(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            if ((object = (Map.Entry)object).getKey() == null || !(object.getKey() instanceof Long)) {
                return false;
            }
            long l = (Long)object.getKey();
            object = object.getValue();
            if (l == 0L) {
                if (this.a.a && (this.a.a[this.a.b] == null ? object == null : this.a.a[this.a.b].equals(object))) {
                    this.a.a();
                    return true;
                }
                return false;
            }
            long[] lArray = this.a.a;
            int n = (int)ca.a(l) & this.a.a;
            long l2 = this.a.a[n];
            if (l2 == 0L) {
                return false;
            }
            if (l2 == l) {
                if (this.a.a[n] == null ? object == null : this.a.a[n].equals(object)) {
                    this.a.a(n);
                    return true;
                }
                return false;
            }
            do {
                if ((l2 = lArray[n = n + 1 & this.a.a]) != 0L) continue;
                return false;
            } while (l2 != l || !(this.a.a[n] == null ? object == null : this.a.a[n].equals(object)));
            this.a.a(n);
            return true;
        }

        @Override
        public final int size() {
            return this.a.c;
        }

        @Override
        public final void clear() {
            this.a.clear();
        }

        @Override
        public final /* synthetic */ Iterator iterator() {
            return this.a();
        }

        /* synthetic */ e(dj dj2, byte by) {
            this(dj2);
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    final class a
    extends f
    implements ea<di.a<V>> {
        private d a;
        private /* synthetic */ dj a;

        private a(dj dj2) {
            this.a = dj2;
            super(dj2, (byte)0);
        }

        @Override
        public final void remove() {
            super.remove();
            this.a.a = -1;
        }

        @Override
        public final /* synthetic */ Object next() {
            a a2 = this;
            this.a = new d(a2.a, a2.a());
            return this.a;
        }

        /* synthetic */ a(dj dj2, byte by) {
            this(dj2);
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    class f {
        private int a;
        private int b = -1;
        private int c;
        private boolean a;
        private dl a;
        private /* synthetic */ dj a;

        private f(dj dj2) {
            this.a = dj2;
            this.a = this.a.b;
            this.c = this.a.c;
            this.a = this.a.a;
        }

        public boolean hasNext() {
            return this.c != 0;
        }

        public final int a() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            if (this.a) {
                this.a = false;
                this.b = this.a.b;
                return this.b;
            }
            long[] lArray = this.a.a;
            do {
                if (--this.a >= 0) continue;
                this.b = Integer.MIN_VALUE;
                long l = this.a.b(-this.a - 1);
                int n = (int)ca.a(l) & this.a.a;
                while (l != lArray[n]) {
                    n = n + 1 & this.a.a;
                }
                return n;
            } while (lArray[this.a] == 0L);
            this.b = this.a;
            return this.b;
        }

        private final void a(int n) {
            long[] lArray = this.a.a;
            while (true) {
                long l;
                int n2 = n;
                n = n2 + 1 & this.a.a;
                while (true) {
                    if ((l = lArray[n]) == 0L) {
                        lArray[n2] = 0L;
                        this.a.a[n2] = (long)null;
                        return;
                    }
                    int n3 = (int)ca.a(l) & this.a.a;
                    if (n2 > n ? n2 >= n3 && n3 > n : n2 >= n3 || n3 > n) break;
                    n = n + 1 & this.a.a;
                }
                if (n < n2) {
                    if (this.a == null) {
                        this.a = new dl(2);
                    }
                    this.a.b(lArray[n]);
                }
                lArray[n2] = l;
                this.a.a[n2] = this.a.a[n];
            }
        }

        public void remove() {
            if (this.b == -1) {
                throw new IllegalStateException();
            }
            if (this.b == this.a.b) {
                this.a.a = false;
                this.a.a[this.a.b] = (long)null;
            } else if (this.a >= 0) {
                f f2 = this;
                f2.a(f2.b);
            } else {
                this.a.b(this.a.b(-this.a - 1));
                this.b = -1;
                return;
            }
            --this.a.c;
            this.b = -1;
        }

        /* synthetic */ f(dj dj2, byte by) {
            this(dj2);
        }
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    final class d
    implements di.a<V>,
    Map.Entry<Long, V> {
        int a;
        private /* synthetic */ dj a;

        d(dj dj2, int n) {
            this.a = dj2;
            this.a = n;
        }

        @Override
        public final long a() {
            return this.a.a[this.a];
        }

        @Override
        public final V getValue() {
            return this.a.a[this.a];
        }

        @Override
        public final V setValue(V v) {
            long l = this.a.a[this.a];
            this.a.a[this.a] = (long)v;
            return l;
        }

        @Override
        public final boolean equals(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            return this.a.a[this.a] == (Long)(object = (Map.Entry)object).getKey() && (this.a.a[this.a] == null ? object.getValue() == null : this.a.a[this.a].equals(object.getValue()));
        }

        @Override
        public final int hashCode() {
            return ca.a(this.a.a[this.a]) ^ (this.a.a[this.a] == null ? 0 : this.a.a[this.a].hashCode());
        }

        public final String toString() {
            return this.a.a[this.a] + "=>" + this.a.a[this.a];
        }

        @Override
        @Deprecated
        public final /* synthetic */ Object getKey() {
            d d2 = this;
            return d2.a.a[d2.a];
        }
    }
}
