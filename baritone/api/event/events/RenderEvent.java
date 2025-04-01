/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.event.events;

public final class RenderEvent {
    private final float partialTicks;

    public RenderEvent(float f) {
        this.partialTicks = f;
    }

    public final float getPartialTicks() {
        return this.partialTicks;
    }
}
