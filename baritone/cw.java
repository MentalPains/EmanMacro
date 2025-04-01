/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cv;
import baritone.cx;
import baritone.dh;
import baritone.dr;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
static final class cw
extends dh {
    final /* synthetic */ cv a;

    cw(cv cv2) {
        this.a = cv2;
    }

    @Override
    public final boolean a(long l) {
        return this.a.a(l);
    }

    @Override
    public final int size() {
        return this.a.size();
    }

    @Override
    public final void clear() {
        this.a.clear();
    }

    @Override
    public final dr a() {
        return new cx(this);
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
