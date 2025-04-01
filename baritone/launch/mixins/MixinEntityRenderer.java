/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bfk
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package baritone.launch.mixins;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.event.events.RenderEvent;
import java.util.Iterator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={bfk.class})
public class MixinEntityRenderer {
    @Inject(method={"renderWorldPass"}, at={@At(value="INVOKE_STRING", target="Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V", args={"ldc=hand"})})
    private void renderWorldPass(int n, float f, long l, CallbackInfo callbackInfo) {
        Iterator<IBaritone> iterator = BaritoneAPI.getProvider().getAllBaritones().iterator();
        while (iterator.hasNext()) {
            iterator.next().getGameEventHandler().onRenderPass(new RenderEvent(f));
        }
    }
}
