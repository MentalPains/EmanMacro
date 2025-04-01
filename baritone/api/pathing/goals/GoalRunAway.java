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
import baritone.cp;
import baritone.cs;
import java.util.Arrays;
import java.util.Objects;

public class GoalRunAway
implements Goal {
    private final cj[] from;
    private final int distanceSq;
    private final Integer maintainY;

    public GoalRunAway(double d, cj ... cjArray) {
        this(d, (Integer)null, cjArray);
    }

    public GoalRunAway(double d, Integer n, cj ... cjArray) {
        if (cjArray.length == 0) {
            throw new IllegalArgumentException();
        }
        this.from = cjArray;
        double d2 = d;
        this.distanceSq = (int)(d2 * d2);
        this.maintainY = n;
    }

    @Override
    public boolean isInGoal(int n, int n2, int n3) {
        if (this.maintainY != null && this.maintainY != n2) {
            return false;
        }
        cj[] cjArray = this.from;
        int n4 = this.from.length;
        for (int i = 0; i < n4; ++i) {
            cj cj2 = cjArray[i];
            int n5 = n - cj2.n();
            int n6 = n3 - cj2.p();
            int n7 = n5;
            int n8 = n6;
            if (n7 * n7 + n8 * n8 >= this.distanceSq) continue;
            return false;
        }
        return true;
    }

    @Override
    public double heuristic(int n, int n2, int n3) {
        double d = Double.MAX_VALUE;
        cj[] cjArray = this.from;
        int n4 = this.from.length;
        for (int i = 0; i < n4; ++i) {
            double d2;
            cj cj2 = cjArray[i];
            double d3 = GoalXZ.calculate(cj2.n() - n, cj2.p() - n3);
            if (!(d2 < d)) continue;
            d = d3;
        }
        d = -d;
        if (this.maintainY != null) {
            d = d * 0.6 + GoalYLevel.calculate(this.maintainY, n2) * 1.5;
        }
        return d;
    }

    @Override
    public double heuristic() {
        double d;
        int n = (int)Math.ceil(Math.sqrt(this.distanceSq));
        int n2 = Integer.MAX_VALUE;
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MIN_VALUE;
        int n6 = Integer.MIN_VALUE;
        int n7 = Integer.MIN_VALUE;
        Object object = this.from;
        int n8 = this.from.length;
        for (int i = 0; i < n8; ++i) {
            cj cj2 = object[i];
            n2 = Math.min(n2, cj2.n() - n);
            n3 = Math.min(n3, cj2.o() - n);
            n4 = Math.min(n4, cj2.p() - n);
            n5 = Math.max(n2, cj2.n() + n);
            n6 = Math.max(n3, cj2.o() + n);
            n7 = Math.max(n4, cj2.p() + n);
        }
        object = new cs(0);
        double d2 = Double.POSITIVE_INFINITY;
        for (int i = n2; i <= n5; ++i) {
            for (int j = n3; j <= n6; ++j) {
                for (n = n4; n <= n7; ++n) {
                    double d3;
                    d = this.heuristic(i, j, n);
                    if (d3 < d2 && this.isInGoal(i, j, n)) {
                        ((cs)object).a(d);
                        continue;
                    }
                    d2 = Math.min(d2, d);
                }
            }
        }
        double d4 = Double.NEGATIVE_INFINITY;
        cp cp2 = ((cs)object).a();
        while (cp2.hasNext()) {
            double d5;
            d = cp2.b();
            if (!(d5 < d2)) continue;
            d4 = Math.max(d4, d);
        }
        return d4;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        object = (GoalRunAway)object;
        return this.distanceSq == ((GoalRunAway)object).distanceSq && Arrays.equals(this.from, ((GoalRunAway)object).from) && Objects.equals(this.maintainY, ((GoalRunAway)object).maintainY);
    }

    public String toString() {
        if (this.maintainY != null) {
            return String.format("GoalRunAwayFromMaintainY y=%s, %s", SettingsUtil.maybeCensor(this.maintainY), Arrays.asList(this.from));
        }
        return "GoalRunAwayFrom" + Arrays.asList(this.from);
    }
}
