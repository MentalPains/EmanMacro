/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adm
 *  adp$a
 *  aui
 *  bew
 *  cj
 *  cq
 *  wn
 *  zx
 */
package baritone.api.utils;

import baritone.api.BaritoneAPI;
import baritone.api.utils.input.ClickType;

public interface IPlayerController {
    public void syncHeldItem();

    public boolean hasBrokenBlock();

    public boolean onPlayerDamageBlock(cj var1, cq var2);

    public void resetBlockRemoving();

    public zx windowClick(int var1, int var2, int var3, ClickType var4, wn var5);

    public adp.a getGameType();

    public boolean processRightClickBlock(bew var1, adm var2, cj var3, cq var4, aui var5);

    public boolean processRightClick(bew var1, adm var2);

    public boolean clickBlock(cj var1, cq var2);

    public void setHittingBlock(boolean var1);

    default public double getBlockReachDistance() {
        if (this.getGameType().d()) {
            return 5.0;
        }
        return ((Float)BaritoneAPI.getSettings().blockReachDistance.value).floatValue();
    }
}
