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

public class GoalGetToBlock
implements Goal,
IGoalRenderPos {
    public final int x;
    public final int y;
    public final int z;

    public GoalGetToBlock(cj cj2) {
        this.x = cj2.n();
        this.y = cj2.o();
        this.z = cj2.p();
    }

    @Override
    public cj getGoalPos() {
        return new cj(this.x, this.y, this.z);
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        return Math.abs(n -= this.x) + Math.abs((n2 -= this.y) < 0 ? n2 + 1 : n2) + Math.abs(n3 -= this.z) <= 1;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        return GoalBlock.calculate(n -= this.x, (n2 -= this.y) < 0 ? n2 + 1 : n2, n3 -= this.z);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalGetToBlock)object;
        return this.x == ((GoalGetToBlock)object).x && this.y == ((GoalGetToBlock)object).y && this.z == ((GoalGetToBlock)object).z;
    }

    public String toString() {
        return String.format("GoalGetToBlock{x=%s,y=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
    }
}
