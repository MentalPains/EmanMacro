/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alz
 */
package baritone;

import baritone.bg;
import baritone.bj;
import baritone.p;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bf {
    public final int[] a;
    public final List<alz> a = new int[this.a.size()];

    public final int a(int n, alz alz2) {
        int n2;
        int n3 = 0;
        int n4 = p.c(alz2);
        if (n4 == bg.a) {
            n3 = 2;
        }
        if (n4 == bg.b) {
            n3 |= 4;
        }
        if ((n4 = p.a(alz2)) == bg.a) {
            n3 |= 8;
        }
        if (n4 == bg.b) {
            n3 |= 0x10;
        }
        if ((n2 = p.b(alz2)) == bg.a) {
            n3 |= 0x20;
        }
        if (n2 == bg.b) {
            n3 |= 0x40;
        }
        this.a[n] = n3 |= 1;
        return n3;
    }

    public final boolean a(bj bj2, int n, int n2, int n3, alz alz2) {
        int n4 = this.a.indexOf(alz2);
        int n5 = this.a[n4];
        if ((n5 & 1) == 0) {
            n5 = this.a(n4, alz2);
        }
        if ((n5 & 0x10) != 0) {
            return p.a(bj2, n, n2, n3, alz2);
        }
        return (n5 & 8) != 0;
    }

    public final boolean b(bj bj2, int n, int n2, int n3, alz alz2) {
        int n4 = this.a.indexOf(alz2);
        int n5 = this.a[n4];
        if ((n5 & 1) == 0) {
            n5 = this.a(n4, alz2);
        }
        if ((n5 & 0x40) != 0) {
            return p.b(bj2, n, n2, n3, alz2);
        }
        return (n5 & 0x20) != 0;
    }
}
