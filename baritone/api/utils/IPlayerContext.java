/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adm
 *  ahh
 *  auh
 *  auh$a
 *  aui
 *  ave
 *  bew
 *  cj
 *  pk
 */
package baritone.api.utils;

import baritone.api.utils.BetterBlockPos;
import baritone.api.utils.IPlayerController;
import baritone.api.utils.Rotation;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface IPlayerContext {
    public ave minecraft();

    public bew player();

    public IPlayerController playerController();

    public adm world();

    default public Iterable<pk> entities() {
        return this.world().E();
    }

    default public Stream<pk> entitiesStream() {
        return StreamSupport.stream(this.entities().spliterator(), false);
    }

    public auh objectMouseOver();

    default public BetterBlockPos playerFeet() {
        BetterBlockPos betterBlockPos = new BetterBlockPos(this.player().s, this.player().t + 0.1251, this.player().u);
        try {
            if (this.world().p((cj)betterBlockPos).c() instanceof ahh) {
                return betterBlockPos.up();
            }
        }
        catch (NullPointerException nullPointerException) {}
        return betterBlockPos;
    }

    default public aui playerFeetAsVec() {
        return new aui(this.player().s, this.player().t, this.player().u);
    }

    default public aui playerHead() {
        return new aui(this.player().s, this.player().t + (double)this.player().aS(), this.player().u);
    }

    default public aui playerMotion() {
        return new aui(this.player().v, this.player().w, this.player().x);
    }

    public BetterBlockPos viewerPos();

    default public Rotation playerRotations() {
        return new Rotation(this.player().y, this.player().z);
    }

    public static double eyeHeight(boolean bl) {
        if (bl) {
            return 1.54;
        }
        return 1.62;
    }

    default public Optional<cj> getSelectedBlock() {
        auh auh2 = this.objectMouseOver();
        if (auh2 != null && auh2.a == auh.a.b) {
            return Optional.of(auh2.a());
        }
        return Optional.empty();
    }

    default public boolean isLookingAt(cj cj2) {
        return this.getSelectedBlock().equals(Optional.of(cj2));
    }
}
