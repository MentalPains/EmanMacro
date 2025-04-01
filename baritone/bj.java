/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  adm
 *  adq
 *  afh
 *  afi
 *  alz
 *  amy
 *  cj
 *  cj$a
 */
package baritone;

import baritone.a;
import baritone.api.utils.ChunkPos;
import baritone.api.utils.IPlayerContext;
import baritone.bk;
import baritone.bs;
import baritone.bu;
import baritone.di;
import baritone.dj;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class bj {
    private final di<amy> a;
    public final cj.a a;
    public final adq a;
    private bu a;
    private amy a;
    private final boolean a;
    private static final alz a = afi.a.Q();

    public bj(IPlayerContext iPlayerContext) {
        this(iPlayerContext, false);
    }

    public bj(IPlayerContext iPlayerContext, boolean bl) {
        this.a = null;
        adm adm2 = iPlayerContext.world();
        this.a = new bu(adm2.af());
        di<amy> di2 = ((bs)adm2.N()).loadedChunks();
        this.a = bl ? new dj<amy>(di2, 0) : di2;
        boolean bl2 = this.a = (Boolean)baritone.a.a().pathThroughCachedOnly.value == false;
        if (!iPlayerContext.minecraft().aJ()) {
            throw new IllegalStateException();
        }
        this.a = new cj.a();
        this.a = new bk(this, (adq)adm2);
    }

    public final boolean a(int n, int n2) {
        return this.a.a(ChunkPos.asLong(n >> 4, n2 >> 4));
    }

    public static afh a(IPlayerContext iPlayerContext, cj cj2) {
        return bj.a(iPlayerContext, cj2).c();
    }

    public static alz a(IPlayerContext iPlayerContext, cj cj2) {
        return new bj(iPlayerContext).a(cj2.n(), cj2.o(), cj2.p());
    }

    public final alz a(int n, int n2, int n3) {
        if (n2 < 0 || n2 >= 256) {
            return a;
        }
        if (this.a) {
            amy amy2 = this.a;
            if (amy2 != null && amy2.a == n >> 4 && amy2.b == n3 >> 4) {
                return amy2.g(new cj(n, n2, n3));
            }
            amy2 = (amy)this.a.a(ChunkPos.asLong(n >> 4, n3 >> 4));
            if (amy2 != null && amy2.o()) {
                this.a = amy2;
                return amy2.g(new cj(n, n2, n3));
            }
        }
        return a;
    }

    public final boolean b(int n, int n2) {
        amy amy2 = this.a;
        if (amy2 != null && amy2.a == n >> 4 && amy2.b == n2 >> 4) {
            return true;
        }
        amy2 = (amy)this.a.a(ChunkPos.asLong(n >> 4, n2 >> 4));
        if (amy2 != null && amy2.o()) {
            this.a = amy2;
            return true;
        }
        return false;
    }
}
