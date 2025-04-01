/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ave
 */
package baritone;

import baritone.a;
import baritone.api.IBaritone;
import baritone.api.IBaritoneProvider;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BaritoneProvider
implements IBaritoneProvider {
    private final List<IBaritone> a = new CopyOnWriteArrayList<IBaritone>();
    private final List<IBaritone> b = Collections.unmodifiableList(this.a);

    public BaritoneProvider() {
        this.createBaritone(ave.A());
    }

    @Override
    public IBaritone getPrimaryBaritone() {
        return this.a.get(0);
    }

    @Override
    public List<IBaritone> getAllBaritones() {
        return this.b;
    }

    @Override
    public synchronized IBaritone createBaritone(ave ave2) {
        IBaritone iBaritone = this.getBaritoneForMinecraft(ave2);
        if (iBaritone == null) {
            iBaritone = new a(ave2);
            this.a.add(iBaritone);
        }
        return iBaritone;
    }

    @Override
    public synchronized boolean destroyBaritone(IBaritone iBaritone) {
        return iBaritone != this.getPrimaryBaritone() && this.a.remove(iBaritone);
    }
}
