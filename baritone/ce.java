/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.ca;
import baritone.cc;
import baritone.cf;
import baritone.cg;
import baritone.cq;
import baritone.cr;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class ce
extends cc
implements cq {
    protected ce() {
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
    public void a(int n, double d) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean a(double d) {
        ce ce2 = this;
        ce2.a(ce2.size(), d);
        return true;
    }

    @Override
    public double a(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double a(int n, double d) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int n, Collection<? extends Double> object) {
        this.a(n);
        int n2 = object.size();
        if (n2 == 0) {
            return false;
        }
        object = object.iterator();
        while (n2-- != 0) {
            this.a(n++, (Double)object.next());
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Double> collection) {
        ce ce2 = this;
        return ce2.addAll(ce2.size(), collection);
    }

    @Override
    public final cr a() {
        return this.a(0);
    }

    public cr a(int n) {
        this.a(n);
        return new cf(this, n);
    }

    @Override
    public final boolean b(double d) {
        return this.a(d) >= 0;
    }

    public int a(double d) {
        cr cr2 = this.a(0);
        while (cr2.hasNext()) {
            double d2 = cr2.b();
            if (Double.doubleToLongBits(d) != Double.doubleToLongBits(d2)) continue;
            return cr2.previousIndex();
        }
        return -1;
    }

    public int b(double d) {
        ce ce2 = this;
        cr cr2 = ce2.a(ce2.size());
        while (cr2.hasPrevious()) {
            double d2 = cr2.a();
            if (Double.doubleToLongBits(d) != Double.doubleToLongBits(d2)) continue;
            return cr2.nextIndex();
        }
        return -1;
    }

    public cq a(int n, int n2) {
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
            cr2.b();
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
        if (cr2 instanceof cq) {
            cr cr3 = this.a(0);
            cr2 = ((cq)((Object)cr2)).a();
            while (n-- != 0) {
                if (cr3.b() == cr2.b()) continue;
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

    public final int a(List<? extends Double> object) {
        if (object == this) {
            return 0;
        }
        if (object instanceof cq) {
            cr cr2 = this.a(0);
            object = ((cq)object).a();
            while (cr2.hasNext() && object.hasNext()) {
                double d;
                double d2 = cr2.b();
                int n = Double.compare(d2, d = object.b());
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
            double d = cr2.b();
            n = n * 31 + ca.a(d);
        }
        return n;
    }

    @Override
    public boolean c(double d) {
        int n = this.a(d);
        if (n == -1) {
            return false;
        }
        this.a(n);
        return true;
    }

    @Override
    public boolean remove(Object object) {
        return this.c((Double)object);
    }

    public final void a(int n, Double d) {
        this.a(n, (double)d);
    }

    @Deprecated
    public final Double a(int n, Double d) {
        return this.a(n, (double)d);
    }

    @Deprecated
    public final Double a(int n) {
        return this.b(n);
    }

    @Override
    public int indexOf(Object object) {
        return this.a((Double)object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.b((Double)object);
    }

    @Deprecated
    public final Double b(int n) {
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
            double d = cr2.b();
            stringBuilder.append(String.valueOf(d));
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
        this.a(n, (Double)object);
    }

    @Override
    @Deprecated
    public /* synthetic */ Object set(int n, Object object) {
        return this.a(n, (Double)object);
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
    extends ce
    implements Serializable {
        protected final cq a;
        protected final int a;
        private int b;

        public a(cq cq2, int n, int n2) {
            this.a = cq2;
            this.a = n;
            this.b = n2;
        }

        @Override
        public final boolean a(double d) {
            this.a.a(this.b, d);
            ++this.b;
            return true;
        }

        @Override
        public final void a(int n, double d) {
            this.a(n);
            this.a.a(this.a + n, d);
            ++this.b;
        }

        @Override
        public final boolean addAll(int n, Collection<? extends Double> collection) {
            this.a(n);
            this.b += collection.size();
            return this.a.addAll(this.a + n, collection);
        }

        @Override
        public final double b(int n) {
            this.b(n);
            return this.a.b(this.a + n);
        }

        @Override
        public final double a(int n) {
            this.b(n);
            --this.b;
            return this.a.a(this.a + n);
        }

        @Override
        public final double a(int n, double d) {
            this.b(n);
            return this.a.a(this.a + n, d);
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
            return new cg(this, n);
        }

        @Override
        public final cq a(int n, int n2) {
            this.a(n);
            this.a(n2);
            if (n > n2) {
                throw new IllegalArgumentException("Start index (" + n + ") is greater than end index (" + n2 + ")");
            }
            return new a(this, n, n2);
        }

        @Override
        public final boolean c(double d) {
            int n = this.a(d);
            if (n == -1) {
                return false;
            }
            --this.b;
            this.a.a(this.a + n);
            return true;
        }

        @Override
        public final boolean remove(Object object) {
            return this.c((Double)object);
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
            return ((ce)this).a(0);
        }

        @Override
        @Deprecated
        public final /* synthetic */ Object remove(int n) {
            return super.b(n);
        }

        @Override
        public final /* synthetic */ void add(int n, Object object) {
            super.a(n, (Double)object);
        }

        @Override
        @Deprecated
        public final /* synthetic */ Object set(int n, Object object) {
            return super.a(n, (Double)object);
        }

        @Override
        @Deprecated
        public final /* synthetic */ Object get(int n) {
            return super.a(n);
        }

        @Override
        public final /* synthetic */ Iterator iterator() {
            return ((ce)this).a(0);
        }

        @Override
        public final /* synthetic */ int compareTo(Object object) {
            return super.a((List)object);
        }
    }
}
