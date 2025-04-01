/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ek
 *  ff
 *  fg
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.util.concurrent.Future
 *  io.netty.util.concurrent.GenericFutureListener
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.PacketEvent;
import baritone.api.event.events.type.EventState;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ek.class})
public class MixinNetworkManager {
    @Shadow
    @Final
    private fg h;
    @Shadow
    private Channel k;

    @Inject(method={"dispatchPacket"}, at={@At(value="HEAD")})
    private void preDispatchPacket(ff<?> ff2, GenericFutureListener<? extends Future<? super Void>>[] object, CallbackInfo object22) {
        if (this.h != fg.b) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().player() == null || iBaritone.getPlayerContext().player().a.a() != (ek)this) continue;
            iBaritone.getGameEventHandler().onSendPacket(new PacketEvent((ek)this, EventState.PRE, ff2));
        }
    }

    @Inject(method={"dispatchPacket"}, at={@At(value="RETURN")})
    private void postDispatchPacket(ff<?> ff2, GenericFutureListener<? extends Future<? super Void>>[] object, CallbackInfo object22) {
        if (this.h != fg.b) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().player() == null || iBaritone.getPlayerContext().player().a.a() != (ek)this) continue;
            iBaritone.getGameEventHandler().onSendPacket(new PacketEvent((ek)this, EventState.POST, ff2));
        }
    }

    @Inject(method={"channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V"}, at={@At(value="INVOKE", target="net/minecraft/network/Packet.processPacket(Lnet/minecraft/network/INetHandler;)V")})
    private void preProcessPacket(ChannelHandlerContext object, ff<?> ff2, CallbackInfo object22) {
        if (this.h != fg.b) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().player() == null || iBaritone.getPlayerContext().player().a.a() != (ek)this) continue;
            iBaritone.getGameEventHandler().onReceivePacket(new PacketEvent((ek)this, EventState.PRE, ff2));
        }
    }

    @Inject(method={"channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V"}, at={@At(value="RETURN")})
    private void postProcessPacket(ChannelHandlerContext object, ff<?> ff2, CallbackInfo object22) {
        if (!this.k.isOpen() || this.h != fg.b) {
            return;
        }
        for (IBaritone iBaritone : BaritoneAPI.getProvider().getAllBaritones()) {
            if (iBaritone.getPlayerContext().player() == null || iBaritone.getPlayerContext().player().a.a() != (ek)this) continue;
            iBaritone.getGameEventHandler().onReceivePacket(new PacketEvent((ek)this, EventState.POST, ff2));
        }
    }
}
