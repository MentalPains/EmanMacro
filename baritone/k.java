/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.a;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.calc.IPathFinder;
import baritone.api.pathing.goals.Goal;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.PathCalculationResult;
import baritone.dj;
import baritone.l;
import baritone.m;
import baritone.pathing.movement.CalculationContext;
import java.util.Optional;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class k
implements IPathFinder,
Helper {
    protected final int a;
    protected final int b;
    protected final int c;
    protected final Goal a;
    private final CalculationContext a;
    protected final dj<m> a;
    protected m a;
    protected m b;
    protected final m[] a;
    private volatile boolean b;
    protected boolean a = new m[7];
    protected static final double[] a = new double[]{1.5, 2.0, 2.5, 3.0, 4.0, 5.0, 10.0};

    public k(int n, int n2, int n3, Goal goal, CalculationContext calculationContext) {
        this.a = n;
        this.b = n2;
        this.c = n3;
        this.a = goal;
        this.a = calculationContext;
        this.a = (int)new dj((Integer)baritone.a.a().pathingMapDefaultSize.value, ((Float)baritone.a.a().pathingMapLoadFactor.value).floatValue());
    }

    public void a() {
        this.a = true;
    }

    @Override
    public synchronized PathCalculationResult calculate(long l2, long l3) {
        if (this.b) {
            throw new IllegalStateException("Path finder cannot be reused!");
        }
        this.a = false;
        try {
            Object object = this.a(l2, l3).map(IPath::postProcess).orElse(null);
            if (this.a) {
                PathCalculationResult pathCalculationResult = new PathCalculationResult(PathCalculationResult.Type.CANCELLATION);
                return pathCalculationResult;
            }
            if (object == null) {
                PathCalculationResult pathCalculationResult = new PathCalculationResult(PathCalculationResult.Type.FAILURE);
                return pathCalculationResult;
            }
            int n = object.length();
            if ((object = object.cutoffAtLoadedChunks(this.a.a)).length() < n) {
                Helper.HELPER.logDebug("Cutting off path at edge of loaded chunks");
                Helper.HELPER.logDebug("Length decreased by " + (n - object.length()));
            } else {
                Helper.HELPER.logDebug("Path ends within loaded chunks");
            }
            n = object.length();
            object = object.staticCutoff(this.a);
            if (object.length() < n) {
                Helper.HELPER.logDebug("Static cutoff " + n + " to " + object.length());
            }
            if (this.a.isInGoal(object.getDest())) {
                object = new PathCalculationResult(PathCalculationResult.Type.SUCCESS_TO_GOAL, (IPath)object);
                return object;
            }
            object = new PathCalculationResult(PathCalculationResult.Type.SUCCESS_SEGMENT, (IPath)object);
            return object;
        }
        catch (Exception exception) {
            Helper.HELPER.logDirect("Pathing exception: ".concat(String.valueOf(exception)));
            exception.printStackTrace();
            PathCalculationResult pathCalculationResult = new PathCalculationResult(PathCalculationResult.Type.EXCEPTION);
            return pathCalculationResult;
        }
        finally {
            this.b = true;
        }
    }

    protected abstract Optional<IPath> a(long var1, long var3);

    protected final double a(m m2) {
        int n = m2.a - this.a;
        int n2 = m2.b - this.b;
        int n3 = m2.c - this.c;
        int n4 = n;
        int n5 = n2;
        int n6 = n3;
        return n4 * n4 + n5 * n5 + n6 * n6;
    }

    protected final m a(int n, int n2, int n3, long l2) {
        m m2 = (m)this.a.a(l2);
        if (m2 == null) {
            m2 = new m(n, n2, n3, this.a);
            this.a.a(l2, m2);
        }
        return m2;
    }

    @Override
    public Optional<IPath> pathToMostRecentNodeConsidered() {
        return Optional.ofNullable(this.b).map(m2 -> new l(this.a, (m)m2, 0, this.a, this.a));
    }

    @Override
    public Optional<IPath> bestPathSoFar() {
        return this.a(false, 0);
    }

    protected final Optional<IPath> a(boolean bl, int n) {
        if (this.a == null) {
            return Optional.empty();
        }
        double d2 = 0.0;
        for (int i = 0; i < 7; ++i) {
            double d3;
            if (this.a[i] == null) continue;
            k k2 = this;
            double d4 = k2.a(k2.a[i]);
            if (d3 > d2) {
                d2 = d4;
            }
            if (!(d4 > 25.0)) continue;
            if (bl) {
                if (a[i] >= 3.0) {
                    System.out.println("Warning: cost coefficient is greater than three! Probably means that");
                    System.out.println("the path I found is pretty terrible (like sneak-bridging for dozens of blocks)");
                    System.out.println("But I'm going to do it anyway, because yolo");
                }
                System.out.println("Path goes for " + Math.sqrt(d4) + " blocks");
                this.logDebug("A* cost coefficient " + a[i]);
            }
            return Optional.of(new l(this.a, this.a[i], n, this.a, this.a));
        }
        if (bl) {
            this.logDebug("Even with a cost coefficient of " + a[6] + ", I couldn't get more than " + Math.sqrt(d2) + " blocks");
            this.logDebug("No path found =(");
            this.logNotification("No path found =(", true);
        }
        return Optional.empty();
    }

    @Override
    public final boolean isFinished() {
        return this.b;
    }

    @Override
    public final Goal getGoal() {
        return this.a;
    }

    public final BetterBlockPos a() {
        return new BetterBlockPos(this.a, this.b, this.c);
    }
}
