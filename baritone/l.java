/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  df
 */
package baritone;

import baritone.am;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.movement.IMovement;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.bc;
import baritone.bw;
import baritone.m;
import baritone.o;
import baritone.pathing.movement.CalculationContext;
import baritone.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class l
extends bw {
    private final BetterBlockPos a;
    private final BetterBlockPos b;
    private final List<BetterBlockPos> a;
    private final List<o> b;
    private final List<m> c;
    private final Goal a;
    private final int a;
    private final CalculationContext a;
    private volatile boolean a;

    public l(m m2, m object, int n, Goal goal, CalculationContext calculationContext) {
        this.a = new BetterBlockPos(m2.a, m2.b, m2.c);
        this.b = new BetterBlockPos(((m)object).a, ((m)object).b, ((m)object).c);
        this.a = n;
        this.b = new ArrayList();
        this.a = goal;
        this.a = calculationContext;
        m2 = object;
        object = new LinkedList();
        LinkedList<m> linkedList = new LinkedList<m>();
        while (m2 != null) {
            linkedList.addFirst(m2);
            ((LinkedList)object).addFirst(new BetterBlockPos(m2.a, m2.b, m2.c));
            m2 = m2.a;
        }
        this.a = new ArrayList(object);
        this.c = new ArrayList<m>(linkedList);
    }

    @Override
    public final Goal getGoal() {
        return this.a;
    }

    private boolean a() {
        if (this.a.isEmpty() || !this.b.isEmpty()) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < this.a.size() - 1; ++i) {
            double d = this.c.get((int)(i + 1)).b - this.c.get((int)i).b;
            l l2 = this;
            o o2 = l2.a((BetterBlockPos)((Object)l2.a.get(i)), (BetterBlockPos)((Object)this.a.get(i + 1)), d);
            if (o2 == null) {
                return true;
            }
            this.b.add(o2);
        }
        return false;
    }

    private o a(BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2, double d) {
        o o2;
        int n;
        Enum[] enumArray = r.values();
        int n2 = enumArray.length;
        for (n = 0; n < n2; ++n) {
            o2 = enumArray[n].a(this.a, betterBlockPos);
            if (!o2.getDest().equals((Object)betterBlockPos2)) continue;
            o o3 = o2;
            o3.a(Math.min(o3.a(this.a), d));
            return o2;
        }
        enumArray = am.values();
        n2 = enumArray.length;
        for (n = 0; n < n2; ++n) {
            o2 = ((am)enumArray[n]).a(this.a, betterBlockPos);
            if (!o2.getDest().equals((Object)betterBlockPos2)) continue;
            o o4 = o2;
            o4.a(Math.min(o4.a(this.a), d));
            return o2;
        }
        Helper.HELPER.logDebug("Movement became impossible during calculation " + (Object)((Object)betterBlockPos) + " " + (Object)((Object)betterBlockPos2) + " " + betterBlockPos2.b((df)betterBlockPos));
        return null;
    }

    @Override
    public final IPath postProcess() {
        if (this.a) {
            throw new IllegalStateException();
        }
        this.a = true;
        boolean bl = this.a();
        this.b.forEach(o2 -> o2.a(this.a));
        if (bl) {
            l l2 = this;
            bc bc2 = new bc(l2, l2.movements().size());
            if (bc2.movements().size() != this.b.size()) {
                throw new IllegalStateException();
            }
            return bc2;
        }
        this.sanityCheck();
        return this;
    }

    @Override
    public final List<IMovement> movements() {
        if (!this.a) {
            throw new IllegalStateException();
        }
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
    public final BetterBlockPos getSrc() {
        return this.a;
    }

    @Override
    public final BetterBlockPos getDest() {
        return this.b;
    }
}
