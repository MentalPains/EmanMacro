/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bdb
 */
package baritone.api.event.events;

import baritone.api.event.events.type.EventState;

public final class WorldEvent {
    private final bdb world;
    private final EventState state;

    public WorldEvent(bdb bdb2, EventState eventState) {
        this.world = bdb2;
        this.state = eventState;
    }

    public final bdb getWorld() {
        return this.world;
    }

    public final EventState getState() {
        return this.state;
    }
}
