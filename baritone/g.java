/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 */
package baritone;

import baritone.a;
import baritone.api.IBaritone;
import baritone.api.behavior.IPathingBehavior;
import baritone.api.event.events.PathEvent;
import baritone.api.event.events.PlayerUpdateEvent;
import baritone.api.event.events.RenderEvent;
import baritone.api.event.events.SprintStateEvent;
import baritone.api.event.events.TickEvent;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.goals.Goal;
import baritone.api.pathing.goals.GoalXZ;
import baritone.api.process.PathingCommand;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.PathCalculationResult;
import baritone.api.utils.interfaces.IGoalRenderPos;
import baritone.bd;
import baritone.bo;
import baritone.bp;
import baritone.c;
import baritone.j;
import baritone.k;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import java.lang.invoke.LambdaMetafactory;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.ToDoubleFunction;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class g
extends c
implements IPathingBehavior,
Helper {
    public bd a;
    private bd b;
    private Goal a;
    public CalculationContext a;
    private int a;
    private BetterBlockPos a;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private volatile k a;
    private final Object a;
    private final Object b;
    private BetterBlockPos b;
    private final LinkedBlockingQueue<PathEvent> a = new Object();

    public g(a a2) {
        super(a2);
        this.b = new Object();
        this.a = new LinkedBlockingQueue();
    }

    private void a(PathEvent pathEvent) {
        ((AbstractQueue)((Object)this.a)).add(pathEvent);
    }

    private void a() {
        Object object = new ArrayList();
        ((LinkedBlockingQueue)((Object)this.a)).drainTo(object);
        this.d = ((ArrayList)object).contains((Object)PathEvent.CALC_FAILED);
        object = ((ArrayList)object).iterator();
        while (object.hasNext()) {
            PathEvent pathEvent = (PathEvent)((Object)object.next());
            ((a)((Object)this.a)).getGameEventHandler().onPathEvent(pathEvent);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final void onTick(TickEvent var1_1) {
        block43: {
            block45: {
                block42: {
                    block44: {
                        this.a();
                        if (var1_1.getType() == TickEvent.Type.OUT) {
                            this.b();
                            return;
                        }
                        var1_1 = this;
                        var2_2 /* !! */  = var1_1.a.playerFeet();
                        if (p.b((IPlayerContext)var1_1.a, var2_2 /* !! */ .down())) ** GOTO lbl-1000
                        if (!var1_1.a.player().C) break block44;
                        var4_3 = var1_1.a.player().s;
                        var6_5 = var1_1.a.player().u;
                        var3_7 = new ArrayList<BetterBlockPos>();
                        for (var8_9 = -1; var8_9 <= 1; ++var8_9) {
                            for (var9_11 = -1; var9_11 <= 1; ++var9_11) {
                                var3_7.add(new BetterBlockPos(var2_2 /* !! */ .a + var8_9, var2_2 /* !! */ .c, var2_2 /* !! */ .d + var9_11));
                            }
                        }
                        var3_7.sort(Comparator.comparingDouble((ToDoubleFunction<BetterBlockPos>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)D, a(double double baritone.api.utils.BetterBlockPos ), (Lbaritone/api/utils/BetterBlockPos;)D)((double)var4_3, (double)var6_5)));
                        for (var8_9 = 0; var8_9 < 4; ++var8_9) {
                            var9_13 = (BetterBlockPos)var3_7.get(var8_9);
                            var10_15 = Math.abs((double)var9_13.a + 0.5 - var4_3);
                            var12_17 = Math.abs((double)var9_13.d + 0.5 - var6_5);
                            if (var10_15 > 0.8 && var12_17 > 0.8 || !p.b((IPlayerContext)var1_1.a, var9_13.down()) || !p.a((IPlayerContext)var1_1.a, var9_13) || !p.a((IPlayerContext)var1_1.a, var9_13.up())) continue;
                            v0 = var9_13;
                            break block42;
                        }
                        ** GOTO lbl-1000
                    }
                    if (p.b((IPlayerContext)var1_1.a, var2_2 /* !! */ .down().down())) {
                        v0 = var2_2 /* !! */ .down();
                    } else lbl-1000:
                    // 3 sources

                    {
                        v0 = var2_2 /* !! */ ;
                    }
                }
                var1_1.b = v0;
                var1_1 = this;
                if (var1_1.a.player().bk == var1_1.a.player().bj) break block45;
                var1_1.a.a.clearAllKeys();
                var1_1.a.a.a.a();
                break block43;
            }
            var1_1.c = false;
            var1_1.b = true;
            var2_2 /* !! */  = var1_1.b;
            synchronized (var2_2 /* !! */ ) {
                block47: {
                    block46: {
                        var4_4 = var1_1.a;
                        synchronized (var4_4) {
                            if (var1_1.a != null) {
                                var5_18 = var1_1.a.a();
                                var6_6 = var1_1.a.bestPathSoFar();
                                if (!(var1_1.a != null && var1_1.a.getPath().getDest().equals((Object)var5_18) || var5_18.equals((Object)var1_1.a.playerFeet()) || var5_18.equals((Object)var1_1.b) || var6_6.isPresent() && (var6_6.get().positions().contains((Object)var1_1.a.playerFeet()) || var6_6.get().positions().contains((Object)var1_1.b)))) {
                                    var1_1.a.a();
                                }
                            }
                        }
                        if (var1_1.a == null) {
                            break block43;
                        }
                        var1_1.a = var1_1.a.a();
                        if (var1_1.a.a) break block46;
                        var10_16 = var1_1.a;
                        if (!(var10_16.a >= var10_16.a.length())) break block47;
                    }
                    var1_1.a = null;
                    if (var1_1.a == null || var1_1.a.isInGoal(var1_1.a.playerFeet())) {
                        var1_1.logDebug("All done. At " + var1_1.a);
                        super.a(PathEvent.AT_GOAL);
                        var1_1.b = null;
                        if (((Boolean)baritone.a.a().disconnectOnArrival.value).booleanValue()) {
                            var1_1.a.world().H();
                        }
                        break block43;
                    }
                    if (var1_1.b != null && !var1_1.b.getPath().positions().contains((Object)var1_1.a.playerFeet()) && !var1_1.b.getPath().positions().contains((Object)var1_1.b)) {
                        var1_1.logDebug("Discarding next path as it does not contain current position");
                        super.a(PathEvent.DISCARD_NEXT);
                        var1_1.b = null;
                    }
                    if (var1_1.b != null) {
                        var1_1.logDebug("Continuing on to planned next path");
                        super.a(PathEvent.CONTINUING_ONTO_PLANNED_NEXT);
                        var1_1.a = var1_1.b;
                        var1_1.b = null;
                        var1_1.a.a();
                        break block43;
                    }
                    var4_4 = var1_1.a;
                    synchronized (var4_4) {
                        if (var1_1.a != null) {
                            super.a(PathEvent.PATH_FINISHED_NEXT_STILL_CALCULATING);
                            break block43;
                        }
                        super.a(PathEvent.CALC_STARTED);
                        v1 = var1_1;
                        super.a(v1.b, true, var1_1.a);
                    }
                }
                if (var1_1.a && var1_1.b != null) {
                    var10_16 = var1_1.b;
                    if (!var10_16.a.player().C && !p.b(var10_16.a.world().p((cj)var10_16.a.playerFeet()).c())) {
                        v2 = false;
                    } else if (var10_16.a.playerMotion().b < -0.1) {
                        v2 = false;
                    } else {
                        var11_20 = var10_16.a.positions().indexOf((Object)var10_16.a.playerFeet());
                        if (var11_20 == -1) {
                            v2 = false;
                        } else {
                            var10_16.a = var11_20;
                            var10_16.a();
                            v2 = true;
                        }
                    }
                    if (v2) {
                        var1_1.logDebug("Splicing into planned next path early...");
                        super.a(PathEvent.SPLICING_ONTO_NEXT_EARLY);
                        var1_1.a = var1_1.b;
                        var1_1.b = null;
                        var1_1.a.a();
                        break block43;
                    }
                }
                if (((Boolean)baritone.a.a().splicePath.value).booleanValue()) {
                    var1_1.a = var1_1.a.a(var1_1.b);
                }
                if (var1_1.b != null && var1_1.a.getPath().getDest().equals((Object)var1_1.b.getPath().getDest())) {
                    var1_1.b = null;
                }
                var4_4 = var1_1.a;
                synchronized (var4_4) {
                    if (var1_1.a != null) {
                        break block43;
                    }
                    if (var1_1.b != null) {
                        break block43;
                    }
                    if (var1_1.a == null || var1_1.a.isInGoal(var1_1.a.getPath().getDest())) {
                        break block43;
                    }
                    if (var1_1.ticksRemainingInSegment(false).get() < (double)((Integer)baritone.a.a().planningTickLookahead.value).intValue()) {
                        var1_1.logDebug("Path almost over. Planning ahead...");
                        super.a(PathEvent.NEXT_SEGMENT_CALC_STARTED);
                        v3 = var1_1;
                        super.a(v3.a.getPath().getDest(), false, var1_1.a);
                    }
                }
            }
        }
        ++this.a;
        this.a();
    }

    @Override
    public final void onPlayerSprintState(SprintStateEvent sprintStateEvent) {
        if (this.isPathing()) {
            sprintStateEvent.setState(this.a.b);
        }
    }

    @Override
    public final void onPlayerUpdate(PlayerUpdateEvent playerUpdateEvent) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final boolean secretInternalSetGoalAndPath(PathingCommand object) {
        this.a = ((PathingCommand)object).goal;
        this.a = object instanceof bp ? ((bp)object).a : new CalculationContext((IBaritone)((Object)this.a), true);
        if (this.a == null) {
            return false;
        }
        if (this.a.isInGoal(this.a.playerFeet()) || this.a.isInGoal(this.b)) {
            return false;
        }
        object = this.b;
        synchronized (object) {
            if (this.a != null) {
                return false;
            }
            Object object2 = this.a;
            synchronized (object2) {
                if (this.a != null) {
                    return false;
                }
                this.a(PathEvent.CALC_STARTED);
                g g2 = this;
                g2.a(g2.b, true, this.a);
                return true;
            }
        }
    }

    @Override
    public final Goal getGoal() {
        return this.a;
    }

    @Override
    public final boolean isPathing() {
        return this.hasPath();
    }

    public final Optional<k> getInProgress() {
        return Optional.ofNullable(this.a);
    }

    @Override
    public final boolean cancelEverything() {
        boolean bl = this.a;
        if (bl) {
            this.b();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void b() {
        this.a(PathEvent.CANCELED);
        Object object = this.b;
        synchronized (object) {
            this.getInProgress().ifPresent(k::a);
            if (this.a != null) {
                this.a = null;
                this.b = null;
                ((a)((Object)this.a)).a.clearAllKeys();
                ((a)((Object)this.a)).a.a.a();
            }
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void forceCancel() {
        this.cancelEverything();
        this.b();
        Object object = this.a;
        synchronized (object) {
            this.a = null;
            return;
        }
    }

    @Override
    public final Optional<Double> estimatedTicksToGoal() {
        double d2;
        BetterBlockPos betterBlockPos = this.a.playerFeet();
        if (this.a == null || betterBlockPos == null || this.a == null) {
            return Optional.empty();
        }
        if (this.a.isInGoal(this.a.playerFeet())) {
            g g2 = this;
            g2.a(g2.b);
            return Optional.of(0.0);
        }
        if (this.a == 0) {
            return Optional.empty();
        }
        double d3 = this.a.heuristic(betterBlockPos.a, betterBlockPos.c, betterBlockPos.d);
        if (d3 == (d2 = this.a.heuristic(this.a.a, this.a.c, this.a.d))) {
            return Optional.empty();
        }
        return Optional.of(Math.abs(d3 - this.a.heuristic()) * (double)this.a / Math.abs(d2 - d3));
    }

    private void a(BetterBlockPos betterBlockPos) {
        this.a = 0;
        this.a = betterBlockPos;
    }

    private void a(cj cj2, boolean bl, CalculationContext object) {
        long l;
        long l2;
        if (!Thread.holdsLock(this.a)) {
            throw new IllegalStateException("Must be called with synchronization on pathCalcLock");
        }
        if (this.a != null) {
            throw new IllegalStateException("Already doing it");
        }
        if (!((CalculationContext)object).a) {
            throw new IllegalStateException("Improper context thread safety level");
        }
        Goal goal = this.a;
        if (goal == null) {
            this.logDebug("no goal");
            return;
        }
        if (this.a == null) {
            l2 = (Long)baritone.a.a().primaryTimeoutMS.value;
            l = (Long)baritone.a.a().failureTimeoutMS.value;
        } else {
            l2 = (Long)baritone.a.a().planAheadPrimaryTimeoutMS.value;
            l = (Long)baritone.a.a().planAheadFailureTimeoutMS.value;
        }
        if (this.a != null) {
            this.a.getPath();
        }
        if (!Objects.equals(((k)(object = g.a(cj2, goal, (CalculationContext)object))).getGoal(), goal)) {
            this.logDebug("Simplifying " + goal.getClass() + " to GoalXZ due to distance");
        }
        this.a = object;
        baritone.a.a().execute(() -> this.a(bl, cj2, goal, (k)object, l2, l));
    }

    private static k a(cj cj2, Goal goal, CalculationContext calculationContext) {
        Goal goal2 = goal;
        if (((Boolean)baritone.a.a().simplifyUnloadedYCoord.value).booleanValue() && goal instanceof IGoalRenderPos && !calculationContext.a.a((goal = ((IGoalRenderPos)((Object)goal)).getGoalPos()).n(), goal.p())) {
            goal2 = new GoalXZ(goal.n(), goal.p());
        }
        return new j(cj2.n(), cj2.o(), cj2.p(), goal2, calculationContext);
    }

    @Override
    public final void onRenderPass(RenderEvent renderEvent) {
        bo.a(renderEvent, this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void a(boolean bl, cj cj2, Goal goal, k object, long l, long l2) {
        if (bl) {
            this.logDebug("Starting to search for path from " + cj2 + " to " + goal);
        }
        object = ((k)object).calculate(l, l2);
        Object object2 = this.b;
        synchronized (object2) {
            cj cj3 = ((PathCalculationResult)object).getPath().map(iPath -> new bd(this, (IPath)iPath));
            if (this.a == null) {
                if (cj3.isPresent()) {
                    if (cj3.get().getPath().positions().contains((Object)this.b)) {
                        this.a(PathEvent.CALC_FINISHED_NOW_EXECUTING);
                        this.a = cj3.get();
                        cj3 = cj2;
                        this.a(new BetterBlockPos(cj3));
                    } else {
                        this.logDebug("Warning: discarding orphan path segment with incorrect start");
                    }
                } else if (((PathCalculationResult)object).getType() != PathCalculationResult.Type.CANCELLATION && ((PathCalculationResult)object).getType() != PathCalculationResult.Type.EXCEPTION) {
                    this.a(PathEvent.CALC_FAILED);
                }
            } else if (this.b == null) {
                if (cj3.isPresent()) {
                    if (cj3.get().getPath().getSrc().equals((Object)this.a.getPath().getDest())) {
                        this.a(PathEvent.NEXT_SEGMENT_CALC_FINISHED);
                        this.b = (bd)cj3.get();
                    } else {
                        this.logDebug("Warning: discarding orphan next segment with incorrect start");
                    }
                } else {
                    this.a(PathEvent.NEXT_CALC_FAILED);
                }
            } else {
                this.logDirect("Warning: PathingBehaivor illegal state! Discarding invalid path!");
            }
            if (bl && this.a != null && this.a.getPath() != null) {
                if (goal.isInGoal(this.a.getPath().getDest())) {
                    this.logDebug("Finished finding a path from " + cj2 + " to " + goal + ". " + this.a.getPath().getNumNodesConsidered() + " nodes considered");
                } else {
                    this.logDebug("Found path segment from " + cj2 + " towards " + goal + ". " + this.a.getPath().getNumNodesConsidered() + " nodes considered");
                }
            }
            Object object3 = this.a;
            synchronized (object3) {
                this.a = null;
            }
            return;
        }
    }

    private static /* synthetic */ double a(double d, double d2, BetterBlockPos betterBlockPos) {
        return ((double)betterBlockPos.a + 0.5 - d) * ((double)betterBlockPos.a + 0.5 - d) + ((double)betterBlockPos.d + 0.5 - d2) * ((double)betterBlockPos.d + 0.5 - d2);
    }
}
