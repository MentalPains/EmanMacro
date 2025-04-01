/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 *  pk
 */
package baritone.api.utils;

public class ChunkPos {
    public final int x;
    public final int z;
    private int cachedHashCode = 0;

    public ChunkPos(int n, int n2) {
        this.x = n;
        this.z = n2;
    }

    public ChunkPos(cj cj2) {
        this.x = cj2.n() >> 4;
        this.z = cj2.p() >> 4;
    }

    public static long asLong(int n, int n2) {
        return (long)n & 0xFFFFFFFFL | ((long)n2 & 0xFFFFFFFFL) << 32;
    }

    public int hashCode() {
        if (this.cachedHashCode == 0) {
            int n = 1664525 * this.x + 1013904223;
            int n2 = 1664525 * (this.z ^ 0xDEADBEEF) + 1013904223;
            this.cachedHashCode = n ^ n2;
        }
        return this.cachedHashCode;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChunkPos)) {
            return false;
        }
        object = (ChunkPos)object;
        return this.x == ((ChunkPos)object).x && this.z == ((ChunkPos)object).z;
    }

    public double getDistanceSq(pk pk2) {
        double d = (this.x << 4) + 8;
        double d2 = (this.z << 4) + 8;
        double d3 = d - pk2.s;
        double d4 = d2 - pk2.u;
        double d5 = d3;
        double d6 = d4;
        return d5 * d5 + d6 * d6;
    }

    public int getXStart() {
        return this.x << 4;
    }

    public int getZStart() {
        return this.z << 4;
    }

    public int getXEnd() {
        return (this.x << 4) + 15;
    }

    public int getZEnd() {
        return (this.z << 4) + 15;
    }

    public cj getBlock(int n, int n2, int n3) {
        return new cj((this.x << 4) + n, n2, (this.z << 4) + n3);
    }

    public String toString() {
        return "[" + this.x + ", " + this.z + "]";
    }
}
