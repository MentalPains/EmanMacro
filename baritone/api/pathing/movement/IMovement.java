/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 */
package baritone.api.pathing.movement;

import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.BetterBlockPos;

public interface IMovement {
    public double getCost();

    public MovementStatus update();

    public void reset();

    public boolean safeToCancel();

    public boolean calculatedWhileLoaded();

    public BetterBlockPos getSrc();

    public BetterBlockPos getDest();

    public cj getDirection();
}
