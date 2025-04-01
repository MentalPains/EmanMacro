/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.math3.util.FastMath
 */
package baritone;

import baritone.ed;
import baritone.el;
import baritone.es;
import baritone.ev;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.util.FastMath;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ee
implements ed,
Serializable {
    private final double[] a;

    public ee(double[] dArray) {
        int n;
        ev.a((Object)dArray);
        if (n == 0) {
            throw new el(es.b);
        }
        for (n = dArray.length; n > 1 && dArray[n - 1] == 0.0; --n) {
        }
        this.a = new double[n];
        System.arraycopy(dArray, 0, this.a, 0, n);
    }

    public final double a(double d) {
        double d2 = d;
        double[] dArray = this.a;
        ev.a((Object)this.a);
        int n = dArray.length;
        if (n == 0) {
            throw new el(es.b);
        }
        double d3 = dArray[n - 1];
        n -= 2;
        while (n >= 0) {
            d3 = d2 * d3 + dArray[n];
            --n;
        }
        return d3;
    }

    private static double[] a(double[] dArray) {
        ev.a((Object)dArray);
        int n = dArray.length;
        if (n == 0) {
            throw new el(es.b);
        }
        if (n == 1) {
            return new double[]{0.0};
        }
        double[] dArray2 = new double[n - 1];
        --n;
        while (n > 0) {
            dArray2[n - 1] = (double)n * dArray[n];
            --n;
        }
        return dArray2;
    }

    public final ee a() {
        return new ee(ee.a(this.a));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a[0] == 0.0) {
            if (this.a.length == 1) {
                return "0";
            }
        } else {
            stringBuilder.append(ee.a(this.a[0]));
        }
        for (int i = 1; i < this.a.length; ++i) {
            if (this.a[i] == 0.0) continue;
            if (stringBuilder.length() > 0) {
                if (this.a[i] < 0.0) {
                    stringBuilder.append(" - ");
                } else {
                    stringBuilder.append(" + ");
                }
            } else if (this.a[i] < 0.0) {
                stringBuilder.append("-");
            }
            double d = FastMath.a((double)this.a[i]);
            if (d - 1.0 != 0.0) {
                stringBuilder.append(ee.a(d));
                stringBuilder.append(' ');
            }
            stringBuilder.append("x");
            if (i <= 1) continue;
            stringBuilder.append('^');
            stringBuilder.append(Integer.toString(i));
        }
        return stringBuilder.toString();
    }

    private static String a(double d) {
        String string = Double.toString(d);
        if (string.endsWith(".0")) {
            return string.substring(0, string.length() - 2);
        }
        return string;
    }

    public final int hashCode() {
        return 31 + Arrays.hashCode(this.a);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ee)) {
            return false;
        }
        object = (ee)object;
        return Arrays.equals(this.a, ((ee)object).a);
    }
}
