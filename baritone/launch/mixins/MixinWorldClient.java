/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bdb
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.ChunkEvent;
import baritone.api.event.events.type.EventState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={bdb.class})
public class MixinWorldClient {
    @Inject(method={"doPreChunk"}, at={@At(value="HEAD")})
    private void preDoPreChunk(int n, int n2, boolean bl, CallbackInfo object) {
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().world() != (bdb)this) continue;
            iBaritone.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.PRE, bl ? ChunkEvent.Type.LOAD : ChunkEvent.Type.UNLOAD, n, n2));
        }
    }

    @Inject(method={"doPreChunk"}, at={@At(value="RETURN")})
    private void postDoPreChunk(int n, int n2, boolean bl, CallbackInfo object) {
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().world() != (bdb)this) continue;
            iBaritone.getGameEventHandler().onChunkEvent(new ChunkEvent(EventState.POST, bl ? ChunkEvent.Type.LOAD : ChunkEvent.Type.UNLOAD, n, n2));
        }
    }
}
