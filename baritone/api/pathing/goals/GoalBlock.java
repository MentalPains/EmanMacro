/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 */
package baritone.api.pathing.goals;

import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.pathing.goals.GoalYLevel;
import baritone.api.utils.SettingsUtil;
import baritone.api.utils.interfaces.IGoalRenderPos;

public class GoalBlock
implements Goal,
IGoalRenderPos {
    public final int x;
    public final int y;
    public final int z;

    public GoalBlock(cj cj2) {
        this(cj2.n(), cj2.o(), cj2.p());
    }

    public GoalBlock(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        return n == this.x && n2 == this.y && n3 == this.z;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        return GoalBlock.calculate(n -= this.x, n2 -= this.y, n3 -= this.z);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalBlock)object;
        return this.x == ((GoalBlock)object).x && this.y == ((GoalBlock)object).y && this.z == ((GoalBlock)object).z;
    }

    public String toString() {
        return String.format("GoalBlock{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
    }

    @Override
    public cj getGoalPos() {
        return new cj(this.x, this.y, this.z);
    }

    public static double calculate(double d, int n, double d2) {
        return 0.0 + GoalYLevel.calculate(0, n) + GoalXZ.calculate(d, d2);
    }
}
