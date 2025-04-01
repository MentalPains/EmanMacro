/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 */
package baritone.api.pathing.goals;

import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalBlock;
import baritone.api.utils.SettingsUtil;
import baritone.api.utils.interfaces.IGoalRenderPos;
import baritone.cp;
import baritone.cs;

public class GoalNear
implements Goal,
IGoalRenderPos {
    private final int x;
    private final int y;
    private final int z;
    private final int rangeSq;

    public GoalNear(cj cj2, int n) {
        this.x = cj2.n();
        this.y = cj2.o();
        this.z = cj2.p();
        int n2 = n;
        this.rangeSq = n2 * n2;
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        int n4 = n -= this.x;
        int n5 = n2 -= this.y;
        int n6 = n3 -= this.z;
        return n4 * n4 + n5 * n5 + n6 * n6 <= this.rangeSq;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        return GoalBlock.calculate(n -= this.x, n2 -= this.y, n3 -= this.z);
    }

    @Override
    public double heuristic() {
        double d;
        int n = (int)Math.ceil(Math.sqrt(this.rangeSq));
        cs cs2 = new cs(0);
        double d2 = Double.POSITIVE_INFINITY;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    double d3;
                    GoalNear goalNear = this;
                    d = goalNear.heuristic(goalNear.x + i, this.y + j, this.z + k);
                    if (d3 < d2) {
                        GoalNear goalNear2 = this;
                        if (goalNear2.isInGoal(goalNear2.x + i, this.y + j, this.z + k)) {
                            cs2.a(d);
                            continue;
                        }
                    }
                    d2 = Math.min(d2, d);
                }
            }
        }
        double d4 = Double.NEGATIVE_INFINITY;
        cp cp2 = cs2.a();
        while (cp2.hasNext()) {
            double d5;
            d = cp2.b();
            if (!(d5 < d2)) continue;
            d4 = Math.max(d4, d);
        }
        return d4;
    }

    @Override
    public cj getGoalPos() {
        return new cj(this.x, this.y, this.z);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalNear)object;
        return this.x == ((GoalNear)object).x && this.y == ((GoalNear)object).y && this.z == ((GoalNear)object).z && this.rangeSq == ((GoalNear)object).rangeSq;
    }

    public String toString() {
        return String.format("GoalNear{x=%s, y=%s, z=%s, rangeSq=%d}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z), this.rangeSq);
    }
}
