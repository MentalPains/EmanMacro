/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.a;
import baritone.api.event.events.BlockChangeEvent;
import baritone.api.event.events.BlockInteractEvent;
import baritone.api.event.events.ChatEvent;
import baritone.api.event.events.ChunkEvent;
import baritone.api.event.events.PacketEvent;
import baritone.api.event.events.PathEvent;
import baritone.api.event.events.PlayerUpdateEvent;
import baritone.api.event.events.RenderEvent;
import baritone.api.event.events.RotationMoveEvent;
import baritone.api.event.events.SprintStateEvent;
import baritone.api.event.events.TickEvent;
import baritone.api.event.events.WorldEvent;
import baritone.api.event.listener.IEventBus;
import baritone.api.event.listener.IGameEventListener;
import baritone.bj;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class i
implements IEventBus {
    private final a a;
    private final List<IGameEventListener> a = new CopyOnWriteArrayList();

    public i(a a2) {
        this.a = a2;
    }

    @Override
    public final void onTick(TickEvent tickEvent) {
        if (tickEvent.getType() == TickEvent.Type.IN) {
            try {
                this.a.a = new bj(this.a.getPlayerContext(), true);
            }
            catch (Exception exception) {}
        }
        this.a.a = null;
        this.a.forEach(iGameEventListener -> iGameEventListener.onTick(tickEvent));
    }

    @Override
    public final void onPlayerUpdate(PlayerUpdateEvent playerUpdateEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onPlayerUpdate(playerUpdateEvent));
    }

    @Override
    public final void onSendChatMessage(ChatEvent chatEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onSendChatMessage(chatEvent));
    }

    @Override
    public final void onChunkEvent(ChunkEvent chunkEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onChunkEvent(chunkEvent));
    }

    @Override
    public final void onBlockChange(BlockChangeEvent blockChangeEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onBlockChange(blockChangeEvent));
    }

    @Override
    public final void onRenderPass(RenderEvent renderEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onRenderPass(renderEvent));
    }

    @Override
    public final void onWorldEvent(WorldEvent worldEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onWorldEvent(worldEvent));
    }

    @Override
    public final void onSendPacket(PacketEvent packetEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onSendPacket(packetEvent));
    }

    @Override
    public final void onReceivePacket(PacketEvent packetEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onReceivePacket(packetEvent));
    }

    @Override
    public final void onPlayerRotationMove(RotationMoveEvent rotationMoveEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onPlayerRotationMove(rotationMoveEvent));
    }

    @Override
    public final void onPlayerSprintState(SprintStateEvent sprintStateEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onPlayerSprintState(sprintStateEvent));
    }

    @Override
    public final void onBlockInteract(BlockInteractEvent blockInteractEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onBlockInteract(blockInteractEvent));
    }

    @Override
    public final void onPathEvent(PathEvent pathEvent) {
        this.a.forEach(iGameEventListener -> iGameEventListener.onPathEvent(pathEvent));
    }

    @Override
    public final void registerEventListener(IGameEventListener iGameEventListener) {
        this.a.add(iGameEventListener);
    }
}
