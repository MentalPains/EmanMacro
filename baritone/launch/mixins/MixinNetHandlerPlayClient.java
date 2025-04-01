/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alz
 *  amy
 *  ano
 *  ave
 *  bcy
 *  bdb
 *  cj
 *  ep
 *  ff
 *  fh
 *  fv
 *  fz
 *  fz$a
 *  go
 *  gp
 *  od
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.BlockChangeEvent;
import baritone.api.event.events.ChunkEvent;
import baritone.api.event.events.type.EventState;
import baritone.api.utils.ChunkPos;
import baritone.api.utils.Pair;
import java.util.ArrayList;
import java.util.Collections;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={bcy.class})
public class MixinNetHandlerPlayClient {
    @Shadow
    private ave f;
    @Shadow
    private bdb g;

    @Inject(method={"handleChunkData"}, at={@At(value="INVOKE", target="net/minecraft/world/chunk/Chunk.fillChunk([BIZ)V")})
    private void preRead(go go2, CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForConnection((bcy)this);
        if (object == null) {
            return;
        }
        object.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.PRE, go2.e() ? ChunkEvent.Type.POPULATE_FULL : ChunkEvent.Type.POPULATE_PARTIAL, go2.b(), go2.c()));
    }

    @Inject(method={"handleChunkData"}, at={@At(value="TAIL")})
    private void postHandleChunkData(go go2, CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForConnection((bcy)this);
        if (object == null) {
            return;
        }
        object.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.POST, go2.e() ? ChunkEvent.Type.POPULATE_FULL : ChunkEvent.Type.POPULATE_PARTIAL, go2.b(), go2.c()));
    }

    @Inject(method={"handleMapChunkBulk"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleMapChunkBulk(gp gp2, CallbackInfo callbackInfo) {
        bcy bcy2 = (bcy)this;
        IBaritone iBaritone = BaritoneAPI.getProvider().getBaritoneForConnection(bcy2);
        if (iBaritone == null) {
            return;
        }
        fh.a((ff)gp2, (ep)bcy2, (od)this.f);
        for (int i = 0; i < gp2.a(); ++i) {
            int n = gp2.a(i);
            int n2 = gp2.b(i);
            this.g.b(n, n2, true);
            this.g.a(n << 4, 0, n2 << 4, (n << 4) + 15, 256, (n2 << 4) + 15);
            amy amy2 = this.g.a(n, n2);
            iBaritone.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.PRE, ChunkEvent.Type.POPULATE_FULL, n, n2));
            amy2.a(gp2.c(i), gp2.d(i), true);
            this.g.b(n << 4, 0, n2 << 4, (n << 4) + 15, 256, (n2 << 4) + 15);
            if (!(this.g.t instanceof ano)) {
                amy2.l();
            }
            iBaritone.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.POST, ChunkEvent.Type.POPULATE_FULL, n, n2));
        }
        callbackInfo.cancel();
    }

    @Inject(method={"handleBlockChange"}, at={@At(value="RETURN")})
    private void postHandleBlockChange(fv object, CallbackInfo object2) {
        object2 = BaritoneAPI.getProvider().getBaritoneForConnection((bcy)this);
        if (object2 == null) {
            return;
        }
        ChunkPos chunkPos = new ChunkPos(object.b().n() >> 4, object.b().p() >> 4);
        object = new Pair<cj, alz>(object.b(), object.a());
        object2.getGameEventHandler().onBlockChange(new BlockChangeEvent(chunkPos, Collections.singletonList(object)));
    }

    @Inject(method={"handleMultiBlockChange"}, at={@At(value="RETURN")})
    private void postHandleMultiBlockChange(fz aArray, CallbackInfo object) {
        object = BaritoneAPI.getProvider().getBaritoneForConnection((bcy)this);
        if (object == null) {
            return;
        }
        ChunkPos chunkPos = new ChunkPos(aArray.a()[0].a());
        ArrayList<Pair<cj, alz>> arrayList = new ArrayList<Pair<cj, alz>>();
        for (fz.a a2 : aArray.a()) {
            arrayList.add(new Pair<cj, alz>(a2.a(), a2.c()));
        }
        object.getGameEventHandler().onBlockChange(new BlockChangeEvent(chunkPos, arrayList));
    }
}
