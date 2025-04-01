/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.pathing.goals;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalYLevel;

public class GoalAxis
implements Goal {
    private static final double SQRT_2_OVER_2 = Math.sqrt(2.0) / 2.0;

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        return n2 == (Integer)BaritoneAPI.getSettings().axisHeight.value && (n == 0 || n3 == 0 || Math.abs(n) == Math.abs(n3));
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        n = Math.abs(n);
        n3 = Math.abs(n3);
        int n4 = Math.min(n, n3);
        n4 = Math.max(n, n3) - n4;
        return Math.min((double)n, Math.min((double)n3, (double)n4 * SQRT_2_OVER_2)) * (Double)BaritoneAPI.getSettings().costHeuristic.value + GoalYLevel.calculate((Integer)BaritoneAPI.getSettings().axisHeight.value, n2);
    }

    public boolean equals(Object object) {
        return object.getClass() == GoalAxis.class;
    }

    public String toString() {
        return "GoalAxis";
    }
}
