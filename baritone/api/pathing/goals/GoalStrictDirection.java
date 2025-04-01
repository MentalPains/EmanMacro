/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 *  cq
 */
package baritone.api.pathing.goals;

import baritone.api.pathing.goals.Goal;
import baritone.api.utils.SettingsUtil;

public class GoalStrictDirection
implements Goal {
    public final int x;
    public final int y;
    public final int z;
    public final int dx;
    public final int dz;

    public GoalStrictDirection(cj cj2, cq cq2) {
        this.x = cj2.n();
        this.y = cj2.o();
        this.z = cj2.p();
        this.dx = cq2.g();
        this.dz = cq2.i();
        if (this.dx == 0 && this.dz == 0) {
            throw new IllegalArgumentException(String.valueOf(cq2));
        }
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        return false;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        int n4 = (n - this.x) * this.dx + (n3 - this.z) * this.dz;
        n = Math.abs((n - this.x) * this.dz) + Math.abs((n3 - this.z) * this.dx);
        n2 = Math.abs(n2 - this.y);
        return (double)(-n4 * 100) + (double)(n * 1000) + (double)(n2 * 1000);
    }

    @Override
    public double heuristic() {
        return Double.NEGATIVE_INFINITY;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalStrictDirection)object;
        return this.x == ((GoalStrictDirection)object).x && this.y == ((GoalStrictDirection)object).y && this.z == ((GoalStrictDirection)object).z && this.dx == ((GoalStrictDirection)object).dx && this.dz == ((GoalStrictDirection)object).dz;
    }

    public String toString() {
        return String.format("GoalStrictDirection{x=%s, y=%s, z=%s, dx=%s, dz=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z), SettingsUtil.maybeCensor(this.dx), SettingsUtil.maybeCensor(this.dz));
    }
}
