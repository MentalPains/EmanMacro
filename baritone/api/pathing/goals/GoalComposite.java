/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.pathing.goals;

import baritone.api.pathing.goals.Goal;
import java.util.Arrays;

public class GoalComposite
implements Goal {
    private final Goal[] goals;

    public GoalComposite(Goal ... goalArray) {
        this.goals = goalArray;
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        Goal[] goalArray = this.goals;
        int n4 = this.goals.length;
        for (int i = 0; i < n4; ++i) {
            if (!goalArray[i].isInGoal(n, n2, n3)) continue;
            return true;
        }
        return false;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        double d = Double.MAX_VALUE;
        Goal[] goalArray = this.goals;
        int n4 = this.goals.length;
        for (int i = 0; i < n4; ++i) {
            Goal goal = goalArray[i];
            d = Math.min(d, goal.heuristic(n, n2, n3));
        }
        return d;
    }

    @Override
    public double heuristic() {
        double d = Double.MAX_VALUE;
        Goal[] goalArray = this.goals;
        int n = this.goals.length;
        for (int i = 0; i < n; ++i) {
            Goal goal = goalArray[i];
            d = Math.min(d, goal.heuristic());
        }
        return d;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalComposite)object;
        return Arrays.equals(this.goals, ((GoalComposite)object).goals);
    }

    public String toString() {
        return "GoalComposite" + Arrays.toString(this.goals);
    }

    public Goal[] goals() {
        return this.goals;
    }
}
