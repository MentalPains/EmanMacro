/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 *  df
 */
package baritone;

import baritone.api.IBaritone;
import baritone.api.pathing.movement.IMovement;
import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.api.utils.input.Input;
import baritone.p;
import baritone.pathing.movement.CalculationContext;
import baritone.q;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class o
implements IMovement,
p {
    protected final IBaritone a;
    protected final IPlayerContext a;
    private q a;
    protected final BetterBlockPos a;
    protected final BetterBlockPos b;
    public Double a;
    private Set<BetterBlockPos> a;
    private Boolean a;

    protected o(IBaritone iBaritone, BetterBlockPos betterBlockPos, BetterBlockPos betterBlockPos2) {
        MovementStatus movementStatus = MovementStatus.PREPPING;
        q q2 = new q();
        new q().a = movementStatus;
        this.a = q2;
        this.a = null;
        this.a = iBaritone;
        this.a = iBaritone.getPlayerContext();
        this.a = betterBlockPos;
        this.b = betterBlockPos2;
    }

    @Override
    public double getCost() {
        return this.a;
    }

    public abstract double a(CalculationContext var1);

    public final void a(double d) {
        this.a = d;
    }

    protected abstract Set<BetterBlockPos> a();

    public final Set<BetterBlockPos> b() {
        if (this.a == null) {
            this.a = this.a();
            Objects.requireNonNull(this.a);
        }
        return this.a;
    }

    protected final boolean a() {
        return this.b().contains((Object)this.a.playerFeet());
    }

    @Override
    public MovementStatus update() {
        if (this.a.player() == null) {
            return this.a.a;
        }
        this.a.player().bA.b = false;
        this.a = this.a(this.a);
        if (p.c(this.a, this.a.playerFeet())) {
            this.a.a(Input.JUMP, true);
        }
        Optional.ofNullable(this.a.a.a).ifPresent(rotation -> this.a.getLookBehavior().updateTarget((Rotation)rotation, this.a.a.a));
        this.a.getInputOverrideHandler().clearAllKeys();
        this.a.a.forEach((input, bl) -> this.a.getInputOverrideHandler().setInputForceState((Input)((Object)input), (boolean)bl));
        this.a.a.clear();
        if (this.a.a.isComplete()) {
            this.a.getInputOverrideHandler().clearAllKeys();
        }
        return this.a.a;
    }

    protected boolean a(q q2) {
        if (q2.a == MovementStatus.WAITING) {
            return true;
        }
        return true;
    }

    @Override
    public boolean safeToCancel() {
        o o2 = this;
        return o2.b(o2.a);
    }

    protected boolean b(q q2) {
        return true;
    }

    @Override
    public BetterBlockPos getSrc() {
        return this.a;
    }

    @Override
    public BetterBlockPos getDest() {
        return this.b;
    }

    @Override
    public void reset() {
        MovementStatus movementStatus = MovementStatus.PREPPING;
        q q2 = new q();
        new q().a = movementStatus;
        this.a = q2;
    }

    public q a(q q2) {
        this.a(q2);
        if (q2.a == MovementStatus.PREPPING) {
            q2.a = MovementStatus.WAITING;
        }
        if (q2.a == MovementStatus.WAITING) {
            q2.a = MovementStatus.RUNNING;
        }
        return q2;
    }

    @Override
    public cj getDirection() {
        return this.getDest().b((df)this.getSrc());
    }

    public final void a(CalculationContext calculationContext) {
        this.a = calculationContext.a.a(this.b.a, this.b.d);
    }

    @Override
    public boolean calculatedWhileLoaded() {
        return this.a;
    }
}
