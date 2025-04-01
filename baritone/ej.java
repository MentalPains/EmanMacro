/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.eq;
import baritone.er;
import baritone.es;
import java.util.Locale;

public class ej
extends IllegalStateException {
    final eq a = new eq(this);

    private ej(er er2, Object ... objectArray) {
        this.a.a(er2, objectArray);
    }

    public ej() {
        this(es.j, new Object[0]);
    }

    public String getMessage() {
        return this.a.a(Locale.US, ": ");
    }

    public String getLocalizedMessage() {
        return this.a.a(Locale.getDefault(), ": ");
    }
}
