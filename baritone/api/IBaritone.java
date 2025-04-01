/*
 * Decompiled with CFR 0.152.
 */
package baritone.api;

import baritone.api.behavior.ILookBehavior;
import baritone.api.behavior.IPathingBehavior;
import baritone.api.event.listener.IEventBus;
import baritone.api.utils.IInputOverrideHandler;
import baritone.api.utils.IPlayerContext;

public interface IBaritone {
    public IEventBus getGameEventHandler();

    public IInputOverrideHandler getInputOverrideHandler();

    public IPlayerContext getPlayerContext();

    public IPathingBehavior getPathingBehavior();

    public ILookBehavior getLookBehavior();
}
