/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bfl
 *  bms
 *  org.lwjgl.opengl.GL11
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.event.events.RenderEvent;
import baritone.api.utils.BetterBlockPos;
import baritone.bd;
import baritone.bm;
import baritone.g;
import java.awt.Color;
import org.lwjgl.opengl.GL11;

public final class bo
implements bm {
    public static void a(RenderEvent renderEvent, g g2) {
        bd bd2 = g2.a;
        if (bd2.world() == null) {
            return;
        }
        renderEvent.getPartialTicks();
        g2.getGoal();
        int n = bd2.world().t.q();
        int n2 = BaritoneAPI.getProvider().getPrimaryBaritone().getPlayerContext().world().t.q();
        if (n != n2) {
            return;
        }
        if (!((Boolean)bo.a.renderPath.value).booleanValue()) {
            return;
        }
        Object object = g2.a;
        if (object != null) {
            int n3 = Math.max(((bd)object).getPosition() - 3, 0);
            boolean bl = (Boolean)bo.a.fadePath.value;
            Color color = (Color)bo.a.colorCurrentPath.value;
            object = ((bd)object).getPath();
            boolean bl2 = (Boolean)bo.a.renderPathIgnoreDepth.value;
            float f = ((Float)bo.a.pathRenderLineWidthPixels.value).floatValue();
            Color color2 = color;
            bfl.l();
            bfl.a((int)770, (int)771, (int)1, (int)0);
            bm.a(color2, 0.4f);
            GL11.glLineWidth((float)f);
            bfl.x();
            bfl.a((boolean)false);
            if (bl2) {
                bfl.i();
            }
            bm.a.a(1, bms.f);
            int n4 = n3 + 20;
            int n5 = n3 + 30;
            object = object.positions();
            while (n3 < object.size() - 1) {
                BetterBlockPos betterBlockPos = object.get(n3);
                int n6 = n3 + 1;
                BetterBlockPos betterBlockPos2 = object.get(n6);
                int n7 = betterBlockPos2.a - betterBlockPos.a;
                int n8 = betterBlockPos2.c - betterBlockPos.c;
                int n9 = betterBlockPos2.d - betterBlockPos.d;
                while (!(n6 + 1 >= object.size() || bl && n6 + 1 >= n4 || n7 != object.get((int)(n6 + 1)).a - betterBlockPos2.a || n8 != object.get((int)(n6 + 1)).c - betterBlockPos2.c || n9 != object.get((int)(n6 + 1)).d - betterBlockPos2.d)) {
                    betterBlockPos2 = object.get(++n6);
                }
                if (bl) {
                    float f2;
                    if (n3 <= n4) {
                        f2 = 0.4f;
                    } else {
                        if (n3 > n5) break;
                        f2 = 0.4f * (1.0f - (float)(n3 - n4) / (float)(n5 - n4));
                    }
                    bm.a(color, f2);
                }
                double d = (double)betterBlockPos2.d + 0.5;
                double d2 = (double)betterBlockPos2.c + 0.1;
                double d3 = (double)betterBlockPos2.a + 0.5;
                double d4 = (double)betterBlockPos.d + 0.5;
                double d5 = (double)betterBlockPos.c + 0.1;
                double d6 = (double)betterBlockPos.a + 0.5;
                double d7 = bm.a.h;
                double d8 = bm.a.i;
                double d9 = bm.a.j;
                bm.a.b(d6 - d7, d5 - d8, d4 - d9).a(bm.a[0], bm.a[1], bm.a[2], bm.a[3]).d();
                bm.a.b(d3 - d7, d2 - d8, d - d9).a(bm.a[0], bm.a[1], bm.a[2], bm.a[3]).d();
                n3 = n6;
            }
            boolean bl3 = (Boolean)bo.a.renderPathIgnoreDepth.value;
            bm.a.b();
            if (bl3) {
                bfl.j();
            }
            bfl.a((boolean)true);
            bfl.w();
            bfl.k();
        }
    }
}
