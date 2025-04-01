/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  a
 *  ave
 *  eu
 *  fa
 */
package baritone.api.utils;

import baritone.api.BaritoneAPI;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface Helper {
    public static final Helper HELPER = new Helper(){};

    public static eu getPrefix() {
        fa fa2 = new fa((Boolean)BaritoneAPI.getSettings().shortBaritonePrefix.value != false ? "B" : "Baritone");
        fa2.b().a(a.n);
        fa fa3 = new fa("");
        fa3.b().a(a.f);
        fa3.a("[");
        fa3.a((eu)fa2);
        fa3.a("]");
        return fa3;
    }

    default public void logNotification(String string) {
        this.logNotification(string, false);
    }

    default public void logNotification(String string, boolean bl) {
        if (((Boolean)BaritoneAPI.getSettings().desktopNotifications.value).booleanValue()) {
            this.logNotificationDirect(string, bl);
        }
    }

    default public void logNotificationDirect(String string) {
        this.logNotificationDirect(string, false);
    }

    default public void logNotificationDirect(String string, boolean bl) {
        ave.A().a(() -> ((BiConsumer)BaritoneAPI.getSettings().notifier.value).accept(string, bl));
    }

    default public void logDebug(String string) {
        if (!((Boolean)BaritoneAPI.getSettings().chatDebug.value).booleanValue()) {
            return;
        }
        this.logDirect(string);
    }

    default public void logDirect(eu ... euArray) {
        fa fa2 = new fa("");
        fa2.a(Helper.getPrefix());
        fa2.a((eu)new fa(" "));
        Arrays.asList(euArray).forEach(arg_0 -> ((eu)fa2).a(arg_0));
        ave.A().a(() -> Helper.lambda$logDirect$1((eu)fa2));
    }

    default public void logDirect(String string2, a a2) {
        Stream.of(string2.split("\n")).forEach(string -> {
            string = new fa(string.replace("\t", "    "));
            string.b().a(a2);
            this.logDirect(new eu[]{string});
        });
    }

    default public void logDirect(String string) {
    }

    private static /* synthetic */ void lambda$logDirect$1(eu eu2) {
        ((Consumer)BaritoneAPI.getSettings().logger.value).accept(eu2);
    }
}
