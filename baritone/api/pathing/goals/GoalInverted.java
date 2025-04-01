/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.pathing.goals;

import baritone.api.pathing.goals.Goal;
import java.util.Objects;

public class GoalInverted
implements Goal {
    public final Goal origin;

    public GoalInverted(Goal goal) {
        this.origin = goal;
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        return false;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        return -this.origin.heuristic(n, n2, n3);
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
        object = (GoalInverted)object;
        return Objects.equals(this.origin, ((GoalInverted)object).origin);
    }

    public String toString() {
        return String.format("GoalInverted{%s}", this.origin.toString());
    }
}
