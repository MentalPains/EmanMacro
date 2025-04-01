/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.cr;
import baritone.db;
import baritone.de;
import baritone.df;
import baritone.ds;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class dd
extends db
implements ds {
    protected dd() {
    }

    protected final void a(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is negative");
        }
        if (n > this.size()) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than list size (" + this.size() + ")");
        }
    }

    protected final void b(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is negative");
        }
        if (n >= this.size()) {
            throw new IndexOutOfBoundsException("Index (" + n + ") is greater than or equal to list size (" + this.size() + ")");
        }
    }

    @Override
    public void a(int n, long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean b(long l) {
        dd dd2 = this;
        dd2.a(dd2.size(), l);
        return true;
    }

    @Override
    public long a(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long a(int n, long l) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int n, Collection<? extends Long> object) {
        this.a(n);
        int n2 = object.size();
        if (n2 == 0) {
            return false;
        }
        object = object.iterator();
        while (n2-- != 0) {
            this.a(n++, (Long)object.next());
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Long> collection) {
        dd dd2 = this;
        return dd2.addAll(dd2.size(), collection);
    }

    @Override
    public final cr a() {
        return this.a(0);
    }

    public cr a(int n) {
        this.a(n);
        return new de(this, n);
    }

    @Override
    public final boolean a(long l) {
        return this.a(l) >= 0;
    }

    public int a(long l) {
        cr cr2 = this.a(0);
        while (cr2.hasNext()) {
            long l2 = cr2.a();
            if (l != l2) continue;
            return cr2.previousIndex();
        }
        return -1;
    }

    public int b(long l) {
        dd dd2 = this;
        cr cr2 = dd2.a(dd2.size());
        while (cr2.hasPrevious()) {
            long l2 = cr2.b();
            if (l != l2) continue;
            return cr2.nextIndex();
        }
        return -1;
    }

    public ds a(int n, int n2) {
        this.a(n);
        this.a(n2);
        if (n > n2) {
            throw new IndexOutOfBoundsException("Start index (" + n + ") is greater than end index (" + n2 + ")");
        }
        return new a(this, n, n2);
    }

    @Override
    public void a(int n, int n2) {
        this.a(n2);
        cr cr2 = this.a(n);
        int n3 = n2 - n;
        if (n3 < 0) {
            throw new IllegalArgumentException("Start index (" + n + ") is greater than end index (" + n2 + ")");
        }
        while (n3-- != 0) {
            cr2.a();
            cr2.remove();
        }
    }

    @Override
    public boolean equals(Object cr2) {
        if (cr2 == this) {
            return true;
        }
        if (!(cr2 instanceof List)) {
            return false;
        }
        cr2 = (List)((Object)cr2);
        int n = this.size();
        if (n != cr2.size()) {
            return false;
        }
        if (cr2 instanceof ds) {
            cr cr3 = this.a(0);
            cr2 = ((ds)((Object)cr2)).a();
            while (n-- != 0) {
                if (cr3.a() == cr2.a()) continue;
                return false;
            }
            return true;
        }
        cr cr4 = this.a(0);
        cr2 = cr2.listIterator();
        while (n-- != 0) {
            Object e = cr2.next();
            Object e2 = cr4.next();
            if (e2 == null ? e == null : e2.equals(e)) continue;
            return false;
        }
        return true;
    }

    public final int a(List<? extends Long> object) {
        if (object == this) {
            return 0;
        }
        if (object instanceof ds) {
            cr cr2 = this.a(0);
            object = ((ds)object).a();
            while (cr2.hasNext() && object.hasNext()) {
                long l;
                long l2 = cr2.a();
                int n = Long.compare(l2, l = object.a());
                if (n == 0) continue;
                return n;
            }
            if (object.hasNext()) {
                return -1;
            }
            if (cr2.hasNext()) {
                return 1;
            }
            return 0;
        }
        cr cr3 = this.a(0);
        object = object.listIterator();
        while (cr3.hasNext() && object.hasNext()) {
            int n = ((Comparable)cr3.next()).compareTo(object.next());
            if (n == 0) continue;
            return n;
        }
        if (object.hasNext()) {
            return -1;
        }
        if (cr3.hasNext()) {
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        cr cr2 = this.a(0);
        int n = 1;
        int n2 = this.size();
        while (n2-- != 0) {
            long l = cr2.a();
            n = n * 31 + ca.a(l);
        }
        return n;
    }

    @Override
    public boolean c(long l) {
        int n = this.a(l);
        if (n == -1) {
            return false;
        }
        this.a(n);
        return true;
    }

    @Override
    public boolean remove(Object object) {
        return this.c((Long)object);
    }

    public final void a(int n, Long l) {
        this.a(n, (long)l);
    }

    @Deprecated
    public final Long a(int n, Long l) {
        return this.a(n, (long)l);
    }

    @Deprecated
    public final Long a(int n) {
        return this.b(n);
    }

    @Override
    public int indexOf(Object object) {
        return this.a((Long)object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.b((Long)object);
    }

    @Deprecated
    public final Long b(int n) {
        return this.a(n);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        cr cr2 = this.a(0);
        int n = this.size();
        boolean bl = true;
        stringBuilder.append("[");
        while (n-- != 0) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            long l = cr2.a();
            stringBuilder.append(String.valueOf(l));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.a(0);
    }

    @Override
    public /* synthetic */ List subList(int n, int n2) {
        return this.a(n, n2);
    }

    @Override
    public /* synthetic */ ListIterator listIterator(int n) {
        return this.a(n);
    }

    @Override
    public /* synthetic */ ListIterator listIterator() {
        return this.a(0);
    }

    @Override
    @Deprecated
    public /* synthetic */ Object remove(int n) {
        return this.b(n);
    }

    @Override
    public /* synthetic */ void add(int n, Object object) {
        this.a(n, (Long)object);
    }

    @Override
    @Deprecated
    public /* synthetic */ Object set(int n, Object object) {
        return this.a(n, (Long)object);
    }

    @Override
    @Deprecated
    public /* synthetic */ Object get(int n) {
        return this.a(n);
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((List)object);
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class a
    extends dd
    implements Serializable {
        protected final ds a;
        protected final int a;
        private int b;

        public a(ds ds2, int n, int n2) {
            this.a = ds2;
            this.a = n;
            this.b = n2;
        }

        @Override
        public final boolean b(long l) {
            this.a.a(this.b, l);
            ++this.b;
            return true;
        }

        @Override
        public final void a(int n, long l) {
            this.a(n);
            this.a.a(this.a + n, l);
            ++this.b;
        }

        @Override
        public final boolean addAll(int n, Collection<? extends Long> collection) {
            this.a(n);
            this.b += collection.size();
            return this.a.addAll(this.a + n, collection);
        }

        @Override
        public final long b(int n) {
            this.b(n);
            return this.a.b(this.a + n);
        }

        @Override
        public final long a(int n) {
            this.b(n);
            --this.b;
            return this.a.a(this.a + n);
        }

        @Override
        public final long a(int n, long l) {
            this.b(n);
            return this.a.a(this.a + n, l);
        }

        @Override
        public final void clear() {
            this.a(0, this.size());
        }

        @Override
        public final int size() {
            return this.b - this.a;
        }

        @Override
        public final void a(int n, int n2) {
            this.a(n);
            this.a(n2);
            this.a.a(this.a + n, this.a + n2);
            this.b -= n2 - n;
        }

        @Override
        public final cr a(int n) {
            this.a(n);
            return new df(this, n);
        }

        @Override
        public final ds a(int n, int n2) {
            this.a(n);
            this.a(n2);
            if (n > n2) {
                throw new IllegalArgumentException("Start index (" + n + ") is greater than end index (" + n2 + ")");
            }
            return new a(this, n, n2);
        }

        @Override
        public final boolean c(long l) {
            int n = this.a(l);
            if (n == -1) {
                return false;
            }
            --this.b;
            this.a.a(this.a + n);
            return true;
        }

        @Override
        public final boolean remove(Object object) {
            return this.c((Long)object);
        }

        @Override
        public final /* synthetic */ List subList(int n, int n2) {
            return this.a(n, n2);
        }

        @Override
        public final /* synthetic */ ListIterator listIterator(int n) {
            return this.a(n);
        }

        @Override
        public final /* synthetic */ ListIterator listIterator() {
            return ((dd)this).a(0);
        }

        @Override
        @Deprecated
        public final /* synthetic */ Object remove(int n) {
            return super.b(n);
        }

        @Override
        public final /* synthetic */ void add(int n, Object object) {
            super.a(n, (Long)object);
        }

        @Override
        @Deprecated
        public final /* synthetic */ Object set(int n, Object object) {
            return super.a(n, (Long)object);
        }

        @Override
        @Deprecated
        public final /* synthetic */ Object get(int n) {
            return super.a(n);
        }

        @Override
        public final /* synthetic */ Iterator iterator() {
            return ((dd)this).a(0);
        }

        @Override
        public final /* synthetic */ int compareTo(Object object) {
            return super.a((List)object);
        }
    }
}
