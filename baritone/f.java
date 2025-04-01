/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.utils.Rotation;
import baritone.d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Exception performing whole class analysis ignored.
 */
final class f
extends d.a {
    private Rotation a;
    private /* synthetic */ d.a a;

    f(d.a a2, d.a a3) {
        this.a = a2;
        super(a3, (byte)0);
        this.a = this.a.a();
    }

    @Override
    public final Rotation nextRotation(Rotation rotation, Rotation rotation2) {
        this.a = super.nextRotation(rotation, rotation2);
        return this.a;
    }

    @Override
    protected final Rotation a() {
        return this.a;
    }
}
