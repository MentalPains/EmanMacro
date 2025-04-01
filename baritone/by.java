/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adm
 *  adp$a
 *  aui
 *  ave
 *  bdb
 *  bew
 *  cj
 *  cq
 *  wn
 *  zx
 */
package baritone;

import baritone.api.utils.IPlayerController;
import baritone.api.utils.input.ClickType;
import baritone.bt;

public final class by
implements IPlayerController {
    private final ave a;

    public by(ave ave2) {
        this.a = ave2;
    }

    @Override
    public final void syncHeldItem() {
        ((bt)this.a.c).callSyncCurrentPlayItem();
    }

    @Override
    public final boolean hasBrokenBlock() {
        return ((bt)this.a.c).getCurrentBlock().o() == -1;
    }

    @Override
    public final boolean onPlayerDamageBlock(cj cj2, cq cq2) {
        return this.a.c.c(cj2, cq2);
    }

    @Override
    public final void resetBlockRemoving() {
        this.a.c.c();
    }

    @Override
    public final zx windowClick(int n, int n2, int n3, ClickType clickType, wn wn2) {
        return this.a.c.a(n, n2, n3, clickType.ordinal(), wn2);
    }

    @Override
    public final adp.a getGameType() {
        return this.a.c.l();
    }

    @Override
    public final boolean processRightClickBlock(bew bew2, adm adm2, cj cj2, cq cq2, aui aui2) {
        return this.a.c.a(bew2, (bdb)adm2, bew2.bA(), cj2, cq2, aui2);
    }

    @Override
    public final boolean processRightClick(bew bew2, adm adm2) {
        return this.a.c.a((wn)bew2, adm2, bew2.bA());
    }

    @Override
    public final boolean clickBlock(cj cj2, cq cq2) {
        return this.a.c.b(cj2, cq2);
    }

    @Override
    public final void setHittingBlock(boolean bl) {
        ((bt)this.a.c).setIsHittingBlock(bl);
    }
}
