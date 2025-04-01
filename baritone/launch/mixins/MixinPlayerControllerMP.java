/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bda
 *  cj
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package baritone.launch.mixins;

import baritone.bt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={bda.class})
public abstract class MixinPlayerControllerMP
implements bt {
    @Override
    @Accessor
    public abstract void setIsHittingBlock(boolean var1);

    @Override
    @Accessor
    public abstract cj getCurrentBlock();

    @Override
    @Invoker
    public abstract void callSyncCurrentPlayItem();
}
