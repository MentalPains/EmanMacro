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

public class GoalTwoBlocks
implements Goal,
IGoalRenderPos {
    protected final int x;
    protected final int y;
    protected final int z;

    public GoalTwoBlocks(cj cj2) {
        this(cj2.n(), cj2.o(), cj2.p());
    }

    public GoalTwoBlocks(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        return n == this.x && (n2 == this.y || n2 == this.y - 1) && n3 == this.z;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        return GoalBlock.calculate(n -= this.x, (n2 -= this.y) < 0 ? n2 + 1 : n2, n3 -= this.z);
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
        object = (GoalTwoBlocks)object;
        return this.x == ((GoalTwoBlocks)object).x && this.y == ((GoalTwoBlocks)object).y && this.z == ((GoalTwoBlocks)object).z;
    }

    public String toString() {
        return String.format("GoalTwoBlocks{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
    }
}
