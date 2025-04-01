/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cj
 */
package baritone.api.event.events;

public final class BlockInteractEvent {
    private final cj pos;
    private final Type type;

    public BlockInteractEvent(cj cj2, Type type) {
        this.pos = cj2;
        this.type = type;
    }

    public final cj getPos() {
        return this.pos;
    }

    public final Type getType() {
        return this.type;
    }

    public static enum Type {
        START_BREAK,
        USE;

    }
}
