/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  alz
 *  cj
 */
package baritone.api.event.events;

import baritone.api.utils.ChunkPos;
import baritone.api.utils.Pair;
import java.util.List;

public final class BlockChangeEvent {
    private final ChunkPos chunk;
    private final List<Pair<cj, alz>> blocks;

    public BlockChangeEvent(ChunkPos chunkPos, List<Pair<cj, alz>> list) {
        this.chunk = chunkPos;
        this.blocks = list;
    }

    public final ChunkPos getChunkPos() {
        return this.chunk;
    }

    public final List<Pair<cj, alz>> getBlocks() {
        return this.blocks;
    }
}
