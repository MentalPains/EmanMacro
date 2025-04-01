/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class TypeUtils {
    private TypeUtils() {
    }

    public static Class<?> resolveBaseClass(Type type) {
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            return (Class)((ParameterizedType)type).getRawType();
        }
        return null;
    }
}
