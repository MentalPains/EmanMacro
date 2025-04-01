/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ave
 *  bcy
 *  bew
 */
package baritone.api;

import baritone.api.IBaritone;
import java.util.List;
import java.util.Objects;

public interface IBaritoneProvider {
    public IBaritone getPrimaryBaritone();

    public List<IBaritone> getAllBaritones();

    default public IBaritone getBaritoneForPlayer(bew bew2) {
        for (IBaritone iBaritone : this.getAllBaritones()) {
            if (!Objects.equals(bew2, iBaritone.getPlayerContext().player())) continue;
            return iBaritone;
        }
        return null;
    }

    default public IBaritone getBaritoneForMinecraft(ave ave2) {
        for (IBaritone iBaritone : this.getAllBaritones()) {
            if (!Objects.equals(ave2, iBaritone.getPlayerContext().minecraft())) continue;
            return iBaritone;
        }
        return null;
    }

    default public IBaritone getBaritoneForConnection(bcy bcy2) {
        for (IBaritone iBaritone : this.getAllBaritones()) {
            bew bew2 = iBaritone.getPlayerContext().player();
            if (bew2 == null || bew2.a != bcy2) continue;
            return iBaritone;
        }
        return null;
    }

    public IBaritone createBaritone(ave var1);

    public boolean destroyBaritone(IBaritone var1);
}
