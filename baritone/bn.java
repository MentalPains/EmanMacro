/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  auh$a
 *  bev
 *  ux
 */
package baritone;

import baritone.a;
import baritone.api.BaritoneAPI;
import baritone.api.event.events.TickEvent;
import baritone.api.utils.IInputOverrideHandler;
import baritone.api.utils.input.Input;
import baritone.bh;
import baritone.bi;
import baritone.bq;
import baritone.c;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bn
extends c
implements IInputOverrideHandler {
    private final Map<Input, Boolean> a;
    public final bh a;
    private final bi a = new HashMap<Input, Boolean>();

    public bn(a a2) {
        super(a2);
        this.a = new bh(a2.getPlayerContext());
        this.a = new bi(a2.getPlayerContext());
    }

    @Override
    public final boolean isInputForcedDown(Input input) {
        if (input == null) {
            return false;
        }
        return this.a.getOrDefault((Object)input, Boolean.FALSE);
    }

    @Override
    public final void setInputForceState(Input input, boolean bl) {
        this.a.put(input, bl);
    }

    @Override
    public final void clearAllKeys() {
        this.a.clear();
    }

    @Override
    public final void onTick(TickEvent object) {
        boolean bl;
        block18: {
            int n;
            if (((TickEvent)object).getType() == TickEvent.Type.OUT) {
                return;
            }
            if (this.isInputForcedDown(Input.CLICK_LEFT)) {
                this.setInputForceState(Input.CLICK_RIGHT, false);
            }
            boolean bl2 = this.isInputForcedDown(Input.CLICK_LEFT);
            object = this.a;
            Object object2 = ((bh)object).a.objectMouseOver();
            int n2 = n = object2 != null && object2.a == auh.a.b ? 1 : 0;
            if (bl2 && n != 0) {
                if (!((bh)object).a) {
                    ((bh)object).a.playerController().syncHeldItem();
                    ((bh)object).a.playerController().clickBlock(object2.a(), object2.b);
                    ((bh)object).a.player().bw();
                }
                if (((bh)object).a.playerController().onPlayerDamageBlock(object2.a(), object2.b)) {
                    ((bh)object).a.player().bw();
                }
                ((bh)object).a.playerController().setHittingBlock(false);
                ((bh)object).a = true;
            } else if (((bh)object).a) {
                ((bh)object).a();
                ((bh)object).a = false;
            }
            bl2 = this.isInputForcedDown(Input.CLICK_RIGHT);
            object = this.a;
            if (((bi)object).a > 0) {
                --((bi)object).a;
            } else {
                object2 = ((bi)object).a.objectMouseOver();
                if (bl2 && (((bi)object).a.player().m == null || !(((bi)object).a.player().m instanceof ux)) && object2 != null && object2.a() != null && object2.a == auh.a.b) {
                    ((bi)object).a = (Integer)baritone.a.a().rightClickSpeed.value;
                    if (((bi)object).a.playerController().processRightClickBlock(((bi)object).a.player(), ((bi)object).a.world(), object2.a(), object2.b, object2.c)) {
                        ((bi)object).a.player().bw();
                    } else if (((bi)object).a.player().bA() != null) {
                        ((bi)object).a.playerController().processRightClick(((bi)object).a.player(), ((bi)object).a.world());
                    }
                }
            }
            object = this;
            Input[] inputArray = new Input[]{Input.MOVE_FORWARD, Input.MOVE_BACK, Input.MOVE_LEFT, Input.MOVE_RIGHT, Input.SNEAK, Input.JUMP};
            for (n = 0; n < 6; ++n) {
                object2 = inputArray[n];
                if (!((bn)object).isInputForcedDown((Input)((Object)object2))) continue;
                bl = true;
                break block18;
            }
            bl = ((a)((Object)((bn)object).a)).a.isPathing() || ((bn)object).a != BaritoneAPI.getProvider().getPrimaryBaritone();
        }
        if (bl) {
            if (this.a.player().b.getClass() != bq.class) {
                this.a.player().b = new bq(this);
                return;
            }
        } else if (this.a.player().b.getClass() == bq.class) {
            this.a.player().b = new bev(this.a.minecraft().t);
        }
    }
}
