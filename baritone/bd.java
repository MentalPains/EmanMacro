/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  aui
 *  cj
 *  df
 *  nz
 *  pk
 */
package baritone;

import baritone.a;
import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.pathing.calc.IPath;
import baritone.api.pathing.movement.IMovement;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.pathing.path.IPathExecutor;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.Helper;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.RotationUtils;
import baritone.api.utils.VecUtils;
import baritone.api.utils.input.Input;
import baritone.aw;
import baritone.ax;
import baritone.ay;
import baritone.az;
import baritone.ba;
import baritone.bb;
import baritone.bc;
import baritone.be;
import baritone.g;
import baritone.k;
import baritone.o;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import baritone.q;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bd
implements IPathExecutor,
Helper {
    public final IPath a;
    public int a;
    private int b;
    private int c;
    private Double a;
    private Integer a;
    public boolean a;
    private final g a;
    public final IPlayerContext a;
    public boolean b;

    public bd(g g2, IPath iPath) {
        this.a = g2;
        this.a = g2.a;
        this.a = iPath;
        this.a = 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    public final boolean a() {
        block30: {
            block32: {
                block39: {
                    block38: {
                        block37: {
                            block36: {
                                block35: {
                                    block34: {
                                        block33: {
                                            block31: {
                                                if (this.a == this.a.length() - 1) {
                                                    ++this.a;
                                                }
                                                if (this.a >= this.a.length()) {
                                                    return true;
                                                }
                                                var1_1 = (o)this.a.movements().get(this.a);
                                                var2_2 = this.a.playerFeet();
                                                if (!var1_1.b().contains(var2_2)) {
                                                    for (var3_5 = 0; var3_5 < this.a && var3_5 < this.a.length(); ++var3_5) {
                                                        if (!((o)this.a.movements().get(var3_5)).b().contains(var2_2)) continue;
                                                        var2_3 = this.a;
                                                        var5_9 = this.a = var3_5;
                                                        while (true) {
                                                            if (var5_9 > var2_3) {
                                                                this.b();
                                                                this.a();
                                                                return false;
                                                            }
                                                            this.a.movements().get(var5_9).reset();
                                                            ++var5_9;
                                                        }
                                                    }
                                                    for (var3_5 = this.a + 3; var3_5 < this.a.length() - 1; ++var3_5) {
                                                        if (!((o)this.a.movements().get(var3_5)).b().contains(var2_2)) continue;
                                                        if (var3_5 - this.a > 2) {
                                                            this.logDebug("Skipping forward " + (var3_5 - this.a) + " steps, to " + var3_5);
                                                        }
                                                        this.a = var3_5 - 1;
                                                        this.b();
                                                        this.a();
                                                        return false;
                                                    }
                                                }
                                                v0 = this;
                                                var3_6 /* !! */  = v0.a(v0.a);
                                                if (this.a(var3_6 /* !! */ , 2.0)) {
                                                    ++this.b;
                                                    System.out.println("FAR AWAY FROM PATH FOR " + this.b + " TICKS. Current distance: " + var3_6 /* !! */ .a() + ". Threshold: 2.0");
                                                    if ((double)this.b > 200.0) {
                                                        this.logDebug("Too far away from path for too long, cancelling path");
                                                        this.c();
                                                        return false;
                                                    }
                                                } else {
                                                    this.b = 0;
                                                }
                                                if (this.a(var3_6 /* !! */ , 3.0)) {
                                                    this.logDebug("too far from path");
                                                    this.c();
                                                    return false;
                                                }
                                                if (this.a < this.a.movements().size() - 1) {
                                                    var2_2 = this.a.movements().get(this.a + 1);
                                                    if (!this.a.a.a.a(var2_2.getDest().a, var2_2.getDest().d)) {
                                                        this.logDebug("Pausing since destination is at edge of loaded chunks");
                                                        this.a();
                                                        return true;
                                                    }
                                                }
                                                var2_4 = var1_1.safeToCancel();
                                                if (this.a == null || this.a != this.a) {
                                                    this.a = this.a;
                                                    this.a = var1_1.getCost();
                                                    for (var5_10 = 1; var5_10 < (Integer)baritone.a.a().costVerificationLookahead.value && this.a + var5_10 < this.a.length() - 1; ++var5_10) {
                                                        if (!(((o)this.a.movements().get(this.a + var5_10)).a(this.a.a) >= 1000000.0) || !var2_4) continue;
                                                        this.logDebug("Something has changed in the world and a future movement has become impossible. Cancelling.");
                                                        this.c();
                                                        return true;
                                                    }
                                                }
                                                var4_15 = this.a.a;
                                                var3_6 /* !! */  = var1_1;
                                                var1_1.a = null;
                                                var5_11 = var4_15;
                                                var4_15 = var3_6 /* !! */ ;
                                                if (var4_15.a == null) {
                                                    var4_15.a = var4_15.a((CalculationContext)var5_11);
                                                }
                                                var5_12 = var4_15.a;
                                                if (v1 >= 1000000.0 && var2_4) {
                                                    this.logDebug("Something has changed in the world and this movement has become impossible. Cancelling.");
                                                    this.c();
                                                    return true;
                                                }
                                                if (!var1_1.calculatedWhileLoaded() && var5_12 - this.a > (Double)baritone.a.a().maxCostIncrease.value && var2_4) {
                                                    this.logDebug("Original cost " + this.a + " current cost " + var5_12 + ". Cancelling.");
                                                    this.c();
                                                    return true;
                                                }
                                                var3_6 /* !! */  = this;
                                                var4_15 = var3_6 /* !! */ .a.getInProgress();
                                                if (var4_15.isPresent() == false ? false : (var3_6 /* !! */ .a.player().C == false ? false : (p.b(var3_6 /* !! */ .a, var3_6 /* !! */ .a.playerFeet().down()) == false ? false : (p.a(var3_6 /* !! */ .a, var3_6 /* !! */ .a.playerFeet()) == false || p.a(var3_6 /* !! */ .a, var3_6 /* !! */ .a.playerFeet().up()) == false ? false : (var3_6 /* !! */ .a.movements().get(var3_6 /* !! */ .a).safeToCancel() == false ? false : ((var4_15 = ((k)var4_15.get()).bestPathSoFar()).isPresent() == false ? false : ((var4_15 = ((IPath)var4_15.get()).positions()).size() < 3 ? false : var4_15.subList(1, var4_15.size()).contains((Object)var3_6 /* !! */ .a.playerFeet())))))))) {
                                                    this.logDebug("Pausing since current best path is a backtrack");
                                                    this.a();
                                                    return true;
                                                }
                                                var3_6 /* !! */  = var1_1.update();
                                                if (var3_6 /* !! */  == MovementStatus.UNREACHABLE || var3_6 /* !! */  == MovementStatus.FAILED) {
                                                    this.logDebug("Movement returns status ".concat(String.valueOf(var3_6 /* !! */ )));
                                                    this.c();
                                                    return true;
                                                }
                                                if (var3_6 /* !! */  == MovementStatus.SUCCESS) {
                                                    ++this.a;
                                                    this.b();
                                                    this.a();
                                                    return true;
                                                }
                                                if (((Boolean)BaritoneAPI.getSettings().safeMode.value).booleanValue() && var1_1 instanceof ax && (var3_7 = p.a(this.a.world().p((cj)var1_1.getSrc().down()))) == (var4_16 = p.a(this.a.world().p((cj)var1_1.getDest().down())))) {
                                                    ((ax)var1_1).a = true;
                                                }
                                                var3_8 = this;
                                                var4_17 = var3_8.a.movements().get(var3_8.a);
                                                if (var4_17 instanceof ba || var4_17 instanceof ay && var4_17.getDest().c != var4_17.getSrc().c) ** GOTO lbl-1000
                                                var5_13 = var3_8.a.a;
                                                if (!(var4_17 instanceof aw) && !(var4_17 instanceof ax)) break block31;
                                                v2 = false;
                                                break block30;
                                            }
                                            if (var3_8.a >= var3_8.a.length() - 3) break block32;
                                            if (var5_13.playerMotion().b() < 0.15) ** GOTO lbl-1000
                                            var1_1 = var3_8.a.movements().get(var3_8.a + 1);
                                            if (!(var1_1 instanceof ba)) break block33;
                                            v2 = true;
                                            break block30;
                                        }
                                        if (var4_17.getDirection().equals((Object)var1_1.getDirection())) ** GOTO lbl-1000
                                        if (!((var4_17 = new aui((df)var4_17.getDirection())).b(var6_20 = new aui((df)var1_1.getDirection())) <= 0.0)) break block34;
                                        v2 = true;
                                        break block30;
                                    }
                                    if (!(var1_1 instanceof az)) break block35;
                                    v2 = true;
                                    break block30;
                                }
                                if (!(var1_1 instanceof aw) && !(var1_1 instanceof ax) || !((var4_18 = p.a(var5_13.world().p((cj)var1_1.getSrc().down()))) ^ (var6_21 = p.a(var5_13.world().p((cj)var1_1.getDest().down()))))) break block36;
                                v2 = true;
                                break block30;
                            }
                            if (!(var1_1 instanceof ay) || var1_1.getDest().c == var1_1.getSrc().c) break block37;
                            v2 = true;
                            break block30;
                        }
                        if (!((Boolean)BaritoneAPI.getSettings().safeMode.value).booleanValue()) ** GOTO lbl-1000
                        var4_19 = var3_8.a.movements().get(var3_8.a + 2);
                        if (!(var4_19 instanceof ba)) break block38;
                        v2 = true;
                        break block30;
                    }
                    if (var1_1.getDirection().equals((Object)var4_19.getDirection())) ** GOTO lbl-1000
                    if (!(var4_19 instanceof az)) break block39;
                    v2 = true;
                    break block30;
                }
                if ((var4_19 instanceof aw || var4_19 instanceof ax) && (var6_22 = p.a(var5_13.world().p((cj)var1_1.getSrc().down()))) ^ (var5_14 = p.a(var5_13.world().p((cj)var1_1.getDest().down())))) {
                    v2 = true;
                    break block30;
                } else if (var4_19 instanceof ay) {
                    v2 = var4_19.getDest().c != var4_19.getSrc().c;
                    break block30;
                } else lbl-1000:
                // 2 sources

                {
                    v2 = false;
                }
                break block30;
            }
            if (var5_13.playerMotion().b() > 0.2) {
                v2 = true;
            } else lbl-1000:
            // 5 sources

            {
                v2 = false;
            }
        }
        if (v2) {
            p.a(this.a.a.a, this.a);
            return var2_4;
        }
        this.b = this.b();
        this.a.player().d(this.b);
        ++this.c;
        if (!((double)this.c > this.a + (double)((Integer)baritone.a.a().movementTimeoutTicks.value).intValue())) return var2_4;
        this.logDebug("This movement has taken too long (" + this.c + " ticks, expected " + this.a + "). Cancelling.");
        this.c();
        return true;
    }

    private nz<Double, cj> a(IPath object) {
        double d2 = -1.0;
        cj cj2 = null;
        object = object.movements().iterator();
        while (object.hasNext()) {
            for (cj cj3 : ((o)object.next()).b()) {
                double d3 = VecUtils.entityDistanceToCenter((pk)this.a.player(), cj3);
                if (!(d3 < d2) && d2 != -1.0) continue;
                d2 = d3;
                cj2 = cj3;
            }
        }
        return new nz((Object)d2, cj2);
    }

    private boolean a(nz<Double, cj> cj2, double d2) {
        if ((Double)cj2.a() > d2) {
            if (this.a.movements().get(this.a) instanceof az) {
                cj2 = this.a.positions().get(this.a + 1);
                return VecUtils.entityFlatDistanceToCenter((pk)this.a.player(), cj2) >= d2;
            }
            return true;
        }
        return false;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    private boolean b() {
        block28: {
            var1_1 = this.a.a.a.isInputForcedDown(Input.SPRINT);
            this.a.a.a.setInputForceState(Input.SPRINT, false);
            if (!new CalculationContext((IBaritone)this.a.a, (boolean)false).b) {
                return false;
            }
            var2_5 = this.a.movements().get(this.a);
            if (!(var2_5 instanceof bb) || this.a >= this.a.length() - 3 || !((var3_6 = this.a.movements().get(this.a + 1)) instanceof aw) || !bd.a(this.a, (bb)var2_5, (aw)var3_6, this.a.movements().get(this.a + 2))) break block28;
            var4_7 = var2_5;
            var3_6 = this.a;
            if (Math.abs((double)var4_7.getDirection().n() * ((double)var4_7.getSrc().d + 0.5 - var3_6.playerFeetAsVec().c)) + Math.abs((double)var4_7.getDirection().p() * ((double)var4_7.getSrc().a + 0.5 - var3_6.playerFeetAsVec().a)) > 0.1) ** GOTO lbl-1000
            var5_8 = var4_7.getSrc().b((df)var4_7.getDirection()).b(2);
            if (p.a((IPlayerContext)var3_6, var5_8)) {
                v0 = true;
            } else if (Math.abs((double)var4_7.getDirection().n() * ((double)var5_8.n() + 0.5 - var3_6.playerFeetAsVec().a)) + Math.abs((double)var4_7.getDirection().p() * ((double)var5_8.p() + 0.5 - var3_6.playerFeetAsVec().c)) > 0.8) {
                v0 = true;
            } else lbl-1000:
            // 2 sources

            {
                v0 = false;
            }
            if (v0) {
                this.logDebug("Skipping traverse to straight ascend");
                ++this.a;
                this.b();
                this.a();
                this.a.a.a.setInputForceState(Input.JUMP, true);
                return true;
            }
            this.logDebug("Too far to the side to safely sprint ascend");
        }
        if (var1_1) {
            return true;
        }
        if (var2_5 instanceof ax) {
            if (((ax)var2_5).b() && !((ax)var2_5).c()) {
                this.logDebug("Sprinting would be unsafe");
                return false;
            }
            if (this.a < this.a.length() - 2) {
                var3_6 = this.a.movements().get(this.a + 1);
                if (var3_6 instanceof aw && var2_5.getDirection().a().equals((Object)var3_6.getDirection().b())) {
                    ++this.a;
                    this.b();
                    this.a();
                    this.logDebug("Skipping descend to straight ascend");
                    return true;
                }
                if (bd.a(this.a, (IMovement)var2_5, (IMovement)var3_6)) {
                    if (var3_6 instanceof ax && this.a < this.a.length() - 3 && (var1_2 = this.a.movements().get(this.a + 2)) instanceof ax && !bd.a(this.a, (IMovement)var3_6, var1_2)) {
                        return false;
                    }
                    if (this.a.playerFeet().equals((Object)var2_5.getDest())) {
                        ++this.a;
                        this.b();
                        this.a();
                    }
                    return true;
                }
            }
        }
        if (var2_5 instanceof aw && this.a != 0) {
            var3_6 = this.a.movements().get(this.a - 1);
            if (var3_6 instanceof ax && var3_6.getDirection().a().equals((Object)var2_5.getDirection().b()) && this.a.playerFeetAsVec().b >= (double)(var1_3 = var2_5.getSrc().up()).o() - 0.07) {
                this.a.a.a.setInputForceState(Input.JUMP, false);
                return true;
            }
            if (this.a < this.a.length() - 2 && var3_6 instanceof bb && bd.a(this.a, (bb)var3_6, (aw)var2_5, this.a.movements().get(this.a + 1))) {
                return true;
            }
        }
        if (var2_5 instanceof az) {
            var4_7 = (az)var2_5;
            var3_6 = this;
            var1_4 = var4_7.getDirection();
            if (var1_4.o() < -3) {
                v1 /* !! */  = null;
            } else {
                var2_5 = new df(var1_4.n(), 0, var1_4.p());
                block0: for (var5_9 = var3_6.a + 1; var5_9 < var3_6.a.length() - 1 && var5_9 < var3_6.a + 3 && (var6_10 = var3_6.a.movements().get(var5_9)) instanceof bb && var2_5.equals((Object)var6_10.getDirection()); ++var5_9) {
                    for (var7_12 = var6_10.getDest().c; var7_12 <= var4_7.getSrc().c + 1; ++var7_12) {
                        var1_4 = new cj(var6_10.getDest().a, var7_12, var6_10.getDest().d);
                        if (!p.a(var3_6.a, (cj)var1_4)) break block0;
                    }
                    if (!p.b(var3_6.a, var6_10.getDest().down())) break;
                }
                if (--var5_9 == var3_6.a) {
                    v1 /* !! */  = null;
                } else {
                    var6_11 = (double)(var5_9 - var3_6.a) - 0.4;
                    v1 /* !! */  = var3_6 = new nz((Object)new aui((double)var2_5.n() * var6_11 + (double)var4_7.getDest().a + 0.5, (double)var4_7.getDest().c, (double)var2_5.p() * var6_11 + (double)var4_7.getDest().d + 0.5), (Object)var4_7.getDest().a(var2_5.n() * (var5_9 - var3_6.a), 0, var2_5.p() * (var5_9 - var3_6.a)));
                }
            }
            if (v1 /* !! */  != null) {
                var1_4 = new BetterBlockPos((cj)var3_6.b());
                if (!this.a.positions().contains(var1_4)) {
                    throw new IllegalStateException();
                }
                if (this.a.playerFeet().equals(var1_4)) {
                    this.a = this.a.positions().indexOf(var1_4);
                    this.b();
                    this.a();
                    return true;
                }
                this.a();
                this.a.a.a.updateTarget(RotationUtils.calcRotationFromVec3d(this.a.playerHead(), (aui)var3_6.a(), this.a.playerRotations()).withPitch(this.a.playerRotations().getPitch()), false);
                var1_4 = new q();
                p.c(this.a, (q)var1_4, (aui)var3_6.a());
                for (Object var2_5 : var1_4.a.entrySet()) {
                    this.a.a.a.setInputForceState((Input)var2_5.getKey(), (Boolean)var2_5.getValue());
                }
                return true;
            }
        }
        return false;
    }

    private static boolean a(IPlayerContext iPlayerContext, bb bb2, aw aw2, IMovement iMovement) {
        if (!((Boolean)baritone.a.a().sprintAscends.value).booleanValue()) {
            return false;
        }
        if (!bb2.getDirection().equals((Object)aw2.getDirection().b())) {
            return false;
        }
        if (iMovement.getDirection().n() != aw2.getDirection().n() || iMovement.getDirection().p() != aw2.getDirection().p()) {
            return false;
        }
        if (!p.b(iPlayerContext, bb2.getDest().down())) {
            return false;
        }
        if (!p.b(iPlayerContext, aw2.getDest().down())) {
            return false;
        }
        for (int j = 0; j < 2; ++j) {
            for (int i2 = 0; i2 < 3; ++i2) {
                BetterBlockPos betterBlockPos = bb2.getSrc().up(i2);
                if (j == 1) {
                    betterBlockPos = betterBlockPos.a((df)bb2.getDirection());
                }
                if (p.a(iPlayerContext, (cj)betterBlockPos)) continue;
                return false;
            }
        }
        if (p.a(iPlayerContext.world().p((cj)bb2.getSrc().up(3)).c())) {
            return false;
        }
        return !p.a(iPlayerContext.world().p((cj)aw2.getDest().up(2)).c());
    }

    private static boolean a(IPlayerContext iPlayerContext, IMovement iMovement, IMovement iMovement2) {
        if (iMovement2 instanceof ax && iMovement2.getDirection().equals((Object)iMovement.getDirection())) {
            return true;
        }
        if (!p.b(iPlayerContext, iMovement.getDest().a((df)iMovement.getDirection()))) {
            return false;
        }
        if (iMovement2 instanceof bb && iMovement2.getDirection().equals((Object)iMovement.getDirection())) {
            return true;
        }
        return iMovement2 instanceof ay && (Boolean)baritone.a.a().allowOvershootDiagonalDescend.value != false;
    }

    private void b() {
        this.a();
        this.c = 0;
    }

    public final void a() {
        ((a)((Object)this.a.a)).a.clearAllKeys();
    }

    private void c() {
        this.a();
        ((a)((Object)this.a.a)).a.a.a();
        this.a = this.a.length() + 3;
        this.a = true;
    }

    @Override
    public final int getPosition() {
        return this.a;
    }

    public final bd a(bd bd2) {
        if (bd2 == null) {
            return this.a();
        }
        return be.a(this.a, bd2.a).map(be2 -> {
            if (!be2.getDest().equals((Object)bd2.getPath().getDest())) {
                throw new IllegalStateException();
            }
            bd2 = new bd(this.a, (IPath)be2);
            new bd(this.a, (IPath)be2).a = this.a;
            bd2.a = this.a;
            bd2.a = this.a;
            bd2.c = this.c;
            return bd2;
        }).orElseGet(this::a);
    }

    private bd a() {
        if (this.a > (Integer)baritone.a.a().maxPathHistoryLength.value) {
            int n = (Integer)baritone.a.a().pathHistoryCutoffAmount.value;
            IPath iPath = this.a;
            Object object = new bc(iPath, n, iPath.length() - 1);
            if (!object.getDest().equals((Object)this.a.getDest())) {
                throw new IllegalStateException();
            }
            this.logDebug("Discarding earliest segment movements, length cut from " + this.a.length() + " to " + object.length());
            object = new bd(this.a, (IPath)object);
            v1.a = this.a - n;
            ((bd)object).a = this.a;
            if (this.a != null) {
                ((bd)object).a = this.a - n;
            }
            ((bd)object).c = this.c;
            return object;
        }
        return this;
    }

    @Override
    public final IPath getPath() {
        return this.a;
    }
}
