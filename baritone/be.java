/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.movement.IMovement;
import baritone.api.utils.BetterBlockPos;
import baritone.bw;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class be
extends bw {
    private final List<BetterBlockPos> a;
    private final List<IMovement> b;
    private final int a;
    private final Goal a;

    private be(List<BetterBlockPos> list, List<IMovement> list2, int n, Goal goal) {
        this.a = list;
        this.b = list2;
        this.a = n;
        this.a = goal;
        this.sanityCheck();
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

    @Override
    public final int length() {
        return this.a.size();
    }

    public static Optional<be> a(IPath iPath, IPath iPath2) {
        int n;
        if (iPath2 == null || iPath == null) {
            return Optional.empty();
        }
        if (!iPath.getDest().equals((Object)iPath2.getSrc())) {
            return Optional.empty();
        }
        AbstractCollection abstractCollection = new HashSet<BetterBlockPos>(iPath2.positions());
        int n2 = -1;
        for (n = 0; n < iPath.length() - 1; ++n) {
            if (!((HashSet)abstractCollection).contains((Object)iPath.positions().get(n))) continue;
            n2 = n;
            break;
        }
        if (n2 != -1) {
            return Optional.empty();
        }
        n2 = iPath.length() - 1;
        n = iPath2.positions().indexOf((Object)iPath.positions().get(n2));
        if (n != 0) {
            throw new IllegalStateException();
        }
        abstractCollection = new ArrayList();
        ArrayList<IMovement> arrayList = new ArrayList<IMovement>();
        abstractCollection.addAll(iPath.positions().subList(0, n2 + 1));
        arrayList.addAll(iPath.movements().subList(0, n2));
        abstractCollection.addAll(iPath2.positions().subList(n + 1, iPath2.length()));
        arrayList.addAll(iPath2.movements().subList(n, iPath2.length() - 1));
        return Optional.of(new be((List<BetterBlockPos>)((Object)abstractCollection), arrayList, iPath.getNumNodesConsidered() + iPath2.getNumNodesConsidered(), iPath.getGoal()));
    }
}
