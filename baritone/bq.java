/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  beu
 */
package baritone;

import baritone.api.utils.input.Input;
import baritone.bn;

public class bq
extends beu {
    private final bn a;

    bq(bn bn2) {
        this.a = bn2;
    }

    public void a() {
        this.a = (bn)0.0f;
        this.b = 0.0f;
        this.c = this.a.isInputForcedDown(Input.JUMP);
        if (this.a.isInputForcedDown(Input.MOVE_FORWARD)) {
            this.b += 1.0f;
        }
        if (this.a.isInputForcedDown(Input.MOVE_BACK)) {
            this.b -= 1.0f;
        }
        if (this.a.isInputForcedDown(Input.MOVE_LEFT)) {
            this.a += 1.0f;
        }
        if (this.a.isInputForcedDown(Input.MOVE_RIGHT)) {
            this.a -= 1.0f;
        }
        if (this.d = this.a.isInputForcedDown(Input.SNEAK)) {
            this.a = (bn)((float)((double)this.a * 0.3));
            this.b = (float)((double)this.b * 0.3);
        }
    }
}
