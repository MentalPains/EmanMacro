/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 */
package baritone;

import baritone.a;
import baritone.api.BaritoneAPI;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.bc;
import baritone.bj;

public abstract class bw
implements IPath {
    @Override
    public /* synthetic */ IPath staticCutoff(Goal object) {
        Goal goal = object;
        object = this;
        int n = (Integer)BaritoneAPI.getSettings().pathCutoffMinimumLength.value;
        if (object.length() < n) {
            return object;
        }
        if (goal == null || goal.isInGoal(object.getDest())) {
            return object;
        }
        double d = (Double)BaritoneAPI.getSettings().pathCutoffFactor.value;
        int n2 = (int)((double)(object.length() - n) * d) + n - 1;
        return new bc((IPath)object, n2);
    }

    @Override
    public /* synthetic */ IPath cutoffAtLoadedChunks(Object object) {
        Object object2 = object;
        object = this;
        if (((Boolean)a.a().cutoffAtLoadBoundary.value).booleanValue()) {
            object2 = (bj)object2;
            for (int i = 0; i < object.positions().size(); ++i) {
                cj cj2 = object.positions().get(i);
                if (((bj)object2).a(cj2.n(), cj2.p())) continue;
                return new bc((IPath)object, i);
            }
        }
        return object;
    }
}
