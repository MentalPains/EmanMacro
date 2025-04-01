/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.movement.IMovement;
import baritone.api.utils.BetterBlockPos;
import baritone.bw;
import java.util.Collections;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bc
extends bw {
    private final List<BetterBlockPos> a;
    private final List<IMovement> b;
    private final int a;
    private final Goal a;

    public bc(IPath iPath, int n, int n2) {
        this.a = iPath.positions().subList(n, n2 + 1);
        this.b = iPath.movements().subList(n, n2);
        this.a = iPath.getNumNodesConsidered();
        this.a = iPath.getGoal();
        this.sanityCheck();
    }

    public bc(IPath iPath, int n) {
        this(iPath, 0, n);
    }

    @Override
    public final Goal getGoal() {
        return this.a;
    }

    @Override
    public final List<IMovement> movements() {
        return Collections.unmodifiableList(this.b);
    }

    @Override
    public final List<BetterBlockPos> positions() {
        return Collections.unmodifiableList(this.a);
    }

    @Override
    public final int getNumNodesConsidered() {
        return this.a;
    }
}
