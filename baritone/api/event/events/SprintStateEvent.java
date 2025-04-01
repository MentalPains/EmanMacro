/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.event.events;

public final class SprintStateEvent {
    private Boolean state;

    public final void setState(boolean bl) {
        this.state = bl;
    }

    public final Boolean getState() {
        return this.state;
    }
}
