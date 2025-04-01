/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 */
package baritone.api.pathing.goals;

public interface Goal {
    public boolean isInGoal(int var1, int var2, int var3);

    public double heuristic(int var1, int var2, int var3);

    default public boolean isInGoal(cj cj2) {
        return this.isInGoal(cj2.n(), cj2.o(), cj2.p());
    }

    default public double heuristic(cj cj2) {
        return this.heuristic(cj2.n(), cj2.o(), cj2.p());
    }

    default public double heuristic() {
        return 0.0;
    }
}
