/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aui
 *  ns
 */
package baritone.api.pathing.goals;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.Goal;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.SettingsUtil;

public class GoalXZ
implements Goal {
    private static final double SQRT_2 = Math.sqrt(2.0);
    private final int x;
    private final int z;

    public GoalXZ(int n, int n2) {
        this.x = n;
        this.z = n2;
    }

    public GoalXZ(BetterBlockPos betterBlockPos) {
        this.x = betterBlockPos.a;
        this.z = betterBlockPos.d;
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        return n == this.x && n3 == this.z;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        n2 = n3 - this.z;
        return GoalXZ.calculate(n -= this.x, n2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalXZ)object;
        return this.x == ((GoalXZ)object).x && this.z == ((GoalXZ)object).z;
    }

    public String toString() {
        return String.format("GoalXZ{x=%s,z=%s}", SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.z));
    }

    public static double calculate(double d, double d2) {
        double d3;
        double d4;
        double d5;
        double d6 = Math.abs(d);
        if (d6 < (d5 = Math.abs(d2))) {
            d4 = d5 - d6;
            d3 = d6;
        } else {
            d4 = d6 - d5;
            d3 = d5;
        }
        return (d3 * SQRT_2 + d4) * (Double)BaritoneAPI.getSettings().costHeuristic.value;
    }

    public static GoalXZ fromDirection(aui aui2, float f, double d) {
        f = (float)Math.toRadians(f);
        double d2 = aui2.a - (double)ns.a((float)f) * d;
        double d3 = aui2.c + (double)ns.b((float)f) * d;
        return new GoalXZ(ns.c((double)d2), ns.c((double)d3));
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }
}
