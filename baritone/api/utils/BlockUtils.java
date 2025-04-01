/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afh
 *  jy
 */
package baritone.api.utils;

import java.util.HashMap;
import java.util.Map;

public class BlockUtils {
    private static transient Map<String, afh> resourceCache = new HashMap<String, afh>();

    public static String blockToString(afh afh2) {
        afh2 = (jy)afh.c.c((Object)afh2);
        String string = afh2.a();
        if (!afh2.b().equals("minecraft")) {
            string = afh2.toString();
        }
        return string;
    }

    public static afh stringToBlockRequired(String string) {
        afh afh2 = BlockUtils.stringToBlockNullable(string);
        if (afh2 == null) {
            throw new IllegalArgumentException(String.format("Invalid block name %s", string));
        }
        return afh2;
    }

    public static afh stringToBlockNullable(String string) {
        afh afh2 = resourceCache.get(string);
        if (afh2 != null) {
            return afh2;
        }
        if (resourceCache.containsKey(string)) {
            return null;
        }
        afh2 = afh.b((String)(string.contains(":") ? string : "minecraft:".concat(String.valueOf(string))));
        HashMap<String, afh> hashMap = new HashMap<String, afh>(resourceCache);
        hashMap.put(string, afh2);
        resourceCache = hashMap;
        return afh2;
    }

    private BlockUtils() {
    }
}
