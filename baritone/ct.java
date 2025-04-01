/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.BigArrays
 */
package baritone;

import it.unimi.dsi.fastutil.BigArrays;
import java.io.Serializable;

public final class ct {
    private static int[][] a = new int[0][];

    public static int a(int[][] nArray, long l) {
        return nArray[BigArrays.a((long)l)][BigArrays.b((long)l)];
    }

    public static long a(int[][] nArray) {
        int n = nArray.length;
        if (n == 0) {
            return 0L;
        }
        return BigArrays.a((int)(n - 1)) + (long)nArray[n - 1].length;
    }

    public static int[][] a(long l) {
        if (l == 0L) {
            return a;
        }
        BigArrays.a((long)l);
        int n = (int)(l + 0x7FFFFFFL >>> 27);
        int[][] nArrayArray = new int[n][];
        int n2 = (int)(l & 0x7FFFFFFL);
        if (n2 != 0) {
            for (int i = 0; i < n - 1; ++i) {
                nArrayArray[i] = new int[0x8000000];
            }
            nArrayArray[n - 1] = new int[n2];
        } else {
            for (int i = 0; i < n; ++i) {
                nArrayArray[i] = new int[0x8000000];
            }
        }
        return nArrayArray;
    }

    static {
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
}
