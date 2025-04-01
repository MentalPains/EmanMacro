/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.api.event.events.type.EventState;

/*
 * Exception performing whole class analysis ignored.
 */
static final class e {
    static final /* synthetic */ int[] a;

    static {
        a = new int[EventState.values().length];
        try {
            e.a[EventState.PRE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            e.a[EventState.POST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
    }
}
