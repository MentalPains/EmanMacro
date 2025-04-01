/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.cb;
import baritone.cr;

public abstract class ch
extends cb
implements cr {
    protected ch() {
    }

    public void b(double d) {
        throw new UnsupportedOperationException();
    }

    public void a(double d) {
        throw new UnsupportedOperationException();
    }

    @Override
    public /* synthetic */ void add(Object object) {
        this.a((Double)object);
    }

    @Override
    public /* synthetic */ void set(Object object) {
        this.b((Double)object);
    }
}
