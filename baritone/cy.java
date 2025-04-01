/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cv;
import baritone.cz;
import baritone.du;
import baritone.ea;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
static final class cy
extends du<V> {
    final /* synthetic */ cv a;

    cy(cv cv2) {
        this.a = cv2;
    }

    @Override
    public final boolean contains(Object object) {
        return this.a.containsValue(object);
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
    public final ea<V> a() {
        return new cz(this);
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        return this.a();
    }
}
