/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.eq;
import baritone.er;
import java.util.Locale;

public class eh
extends IllegalArgumentException {
    private final eq a = new eq(this);

    public eh(er er2, Object ... objectArray) {
        this.a.a(er2, objectArray);
    }

    public String getMessage() {
        return this.a.a(Locale.US, ": ");
    }

    public String getLocalizedMessage() {
        return this.a.a(Locale.getDefault(), ": ");
    }
}
