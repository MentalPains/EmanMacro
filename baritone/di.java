/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.bz;
import baritone.dp;
import baritone.ec;
import java.util.Map;

public interface di<V>
extends bz<V>,
Map<Long, V> {
    public ec<a<V>> a();

    public static interface a<V>
    extends Map.Entry<Long, V> {
        public long a();
    }

    public static interface b
    extends dp {
    }
}
