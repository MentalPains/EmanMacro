/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.utils;

import baritone.api.utils.SettingsUtil;
import baritone.api.utils.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

static final class SettingsUtil.Parser.1
extends SettingsUtil.Parser {
    @Override
    public final Object parse(SettingsUtil.ParserContext parserContext, String string2) {
        SettingsUtil.Parser parser = SettingsUtil.Parser.getParser(((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0]);
        return Stream.of(string2.split(",")).map(string -> parser.parse(parserContext, (String)string)).collect(Collectors.toList());
    }

    @Override
    public final String toString(SettingsUtil.ParserContext parserContext, Object object2) {
        SettingsUtil.Parser parser = SettingsUtil.Parser.getParser(((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0]);
        return ((List)object2).stream().map(object -> parser.toString(parserContext, object)).collect(Collectors.joining(","));
    }

    @Override
    public final boolean accepts(Type type) {
        return List.class.isAssignableFrom(TypeUtils.resolveBaseClass(type));
    }
}
