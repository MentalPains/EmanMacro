/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.event.events;

public static enum ChunkEvent.Type {
    LOAD,
    UNLOAD,
    POPULATE_FULL,
    POPULATE_PARTIAL;


    public final boolean isPopulate() {
        return this == POPULATE_FULL || this == POPULATE_PARTIAL;
    }
}
