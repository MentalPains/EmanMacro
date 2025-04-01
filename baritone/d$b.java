/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.utils.IPlayerContext;
import baritone.api.utils.Rotation;
import baritone.d;

static final class d.b
extends d.a {
    public d.b(IPlayerContext iPlayerContext) {
        super(iPlayerContext);
    }

    @Override
    protected final Rotation a() {
        return this.a.playerRotations();
    }
}
