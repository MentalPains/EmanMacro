/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.behavior.look;

import baritone.api.behavior.look.ITickableAimProcessor;
import baritone.api.utils.Rotation;

public interface IAimProcessor {
    public Rotation peekRotation(Rotation var1);

    public Rotation interpolate(Rotation var1, Rotation var2);

    public ITickableAimProcessor fork();
}
