/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ek
 *  ff
 */
package baritone.api.event.events;

import baritone.api.event.events.type.EventState;

public final class PacketEvent {
    private final ek networkManager;
    private final EventState state;
    private final ff<?> packet;

    public PacketEvent(ek ek2, EventState eventState, ff<?> ff2) {
        this.networkManager = ek2;
        this.state = eventState;
        this.packet = ff2;
    }

    public final ek getNetworkManager() {
        return this.networkManager;
    }

    public final EventState getState() {
        return this.state;
    }

    public final ff<?> getPacket() {
        return this.packet;
    }

    public final <T extends ff<?>> T cast() {
        return (T)this.packet;
    }
}
