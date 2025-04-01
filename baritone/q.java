/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.pathing.movement.MovementStatus;
import baritone.api.utils.Rotation;
import baritone.api.utils.input.Input;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class q {
    public MovementStatus a;
    public a a;
    public final Map<Input, Boolean> a = new HashMap();

    public final q a(Input input, boolean bl) {
        this.a.put(input, bl);
        return this;
    }

    /*
     * Duplicate member names - consider using --renamedupmembers true
     */
    public static final class a {
        public Rotation a;
        boolean a;

        public a() {
            this(null, false);
        }

        public a(Rotation rotation, boolean bl) {
            this.a = rotation;
            this.a = bl;
        }
    }
}
