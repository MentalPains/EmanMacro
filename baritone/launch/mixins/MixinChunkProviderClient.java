/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adm
 *  amy
 *  bcz
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package baritone.launch.mixins;

import baritone.api.utils.ChunkPos;
import baritone.bs;
import baritone.di;
import baritone.dj;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={bcz.class})
public class MixinChunkProviderClient
implements bs {
    @Unique
    private di<amy> map;

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void onInit(adm adm2, CallbackInfo callbackInfo) {
        this.map = new dj<amy>();
    }

    @Inject(method={"loadChunk"}, at={@At(value="INVOKE", target="Lnet/minecraft/util/LongHashMap;add(JLjava/lang/Object;)V")}, locals=LocalCapture.CAPTURE_FAILHARD)
    private void loadChunk(int n, int n2, CallbackInfoReturnable<amy> callbackInfoReturnable, amy amy2) {
        this.map.a(ChunkPos.asLong(n, n2), amy2);
    }

    @Inject(method={"unloadChunk"}, at={@At(value="INVOKE", target="Lnet/minecraft/util/LongHashMap;remove(J)Ljava/lang/Object;")}, locals=LocalCapture.CAPTURE_FAILHARD)
    private void remove(int n, int n2, CallbackInfo callbackInfo, amy amy2) {
        this.map.b(ChunkPos.asLong(n, n2));
    }

    @Override
    public di<amy> loadedChunks() {
        return this.map;
    }
}
