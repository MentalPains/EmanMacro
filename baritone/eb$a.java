/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.dw;
import java.io.Serializable;
import java.util.NoSuchElementException;

public static final class eb.a<K>
extends dw<K>
implements Serializable,
Cloneable {
    protected eb.a() {
    }

    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final boolean hasPrevious() {
        return false;
    }

    @Override
    public final K next() {
        throw new NoSuchElementException();
    }

    @Override
    public final K previous() {
        throw new NoSuchElementException();
    }

    @Override
    public final int nextIndex() {
        return 0;
    }

    @Override
    public final int previousIndex() {
        return -1;
    }

    public final Object clone() {
        return a;
    }
}
