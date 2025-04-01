/*
 * Decompiled with CFR 0.152.
 */
package baritone;

import baritone.er;
import baritone.ev;
import java.io.Serializable;
import java.text.Format;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class eq
implements Serializable {
    private Throwable a;
    private List<er> a;
    private List<Object[]> b;
    private Map<String, Object> a;

    public eq(Throwable throwable) {
        this.a = throwable;
        this.a = new ArrayList();
        this.b = new ArrayList<Object[]>();
        this.a = new HashMap();
    }

    public final void a(er er2, Object ... objectArray) {
        this.a.add(er2);
        this.b.add(ev.a(objectArray));
    }

    public final String a(Locale locale, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        int n2 = this.a.size();
        for (int i = 0; i < n2; ++i) {
            Serializable serializable = (er)this.a.get(i);
            Object[] objectArray = this.b.get(i);
            serializable = new MessageFormat(serializable.a(locale), locale);
            stringBuilder.append(((Format)serializable).format(objectArray));
            if (++n >= n2) continue;
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
