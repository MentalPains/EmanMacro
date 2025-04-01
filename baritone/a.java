/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ave
 */
package baritone;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import baritone.api.Settings;
import baritone.api.behavior.IBehavior;
import baritone.api.event.listener.IEventBus;
import baritone.api.utils.IPlayerContext;
import baritone.bj;
import baritone.bn;
import baritone.bx;
import baritone.d;
import baritone.g;
import baritone.i;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class a
implements IBaritone {
    private static final ThreadPoolExecutor a = new ThreadPoolExecutor(4, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    private final ave a;
    private final Path a;
    private final i a;
    public final g a;
    public final d a;
    public final bn a;
    private final IPlayerContext a;
    public bj a;

    a(ave ave2) {
        this.a = ave2;
        this.a = new i(this);
        this.a = ave2.v.toPath().resolve("baritone");
        if (!Files.exists(this.a, new LinkOption[0])) {
            try {
                Files.createDirectories(this.a, new FileAttribute[0]);
            }
            catch (IOException iOException) {}
        }
        this.a = new bx(this, ave2);
        this.a = this.a(g::new);
        this.a = this.a(d::new);
        this.a = this.a(bn::new);
    }

    private void a(IBehavior iBehavior) {
        this.a.registerEventListener(iBehavior);
    }

    private <T extends IBehavior> T a(Function<a, T> object) {
        object = (IBehavior)object.apply((a)this);
        this.a((IBehavior)object);
        return (T)object;
    }

    @Override
    public final IPlayerContext getPlayerContext() {
        return this.a;
    }

    @Override
    public final IEventBus getGameEventHandler() {
        return this.a;
    }

    public static Settings a() {
        return BaritoneAPI.getSettings();
    }

    public static Executor a() {
        return a;
    }
}
