/*
 * Decompiled with CFR 0.152.
 */
package baritone.api.utils;

import baritone.api.utils.SettingsUtil;
import baritone.api.utils.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

static final class SettingsUtil.Parser.2
extends SettingsUtil.Parser {
    @Override
    public final Object parse(SettingsUtil.ParserContext parserContext, String string2) {
        Object object = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0];
        Object object2 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[1];
        object = SettingsUtil.Parser.getParser((Type)object);
        object2 = SettingsUtil.Parser.getParser((Type)object2);
        return Stream.of(string2.split(",(?=[^,]*->)")).map(string -> string.split("->")).collect(Collectors.toMap(arg_0 -> SettingsUtil.Parser.2.lambda$parse$1((SettingsUtil.Parser)object, parserContext, arg_0), arg_0 -> SettingsUtil.Parser.2.lambda$parse$2((SettingsUtil.Parser)object2, parserContext, arg_0)));
    }

    @Override
    public final String toString(SettingsUtil.ParserContext parserContext, Object object) {
        Object object2 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0];
        Object object3 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[1];
        object2 = SettingsUtil.Parser.getParser((Type)object2);
        object3 = SettingsUtil.Parser.getParser((Type)object3);
        return ((Map)object).entrySet().stream().map(arg_0 -> SettingsUtil.Parser.2.lambda$toString$3((SettingsUtil.Parser)object2, parserContext, (SettingsUtil.Parser)object3, arg_0)).collect(Collectors.joining(","));
    }

    @Override
    public final boolean accepts(Type type) {
        return Map.class.isAssignableFrom(TypeUtils.resolveBaseClass(type));
    }

    private static /* synthetic */ String lambda$toString$3(SettingsUtil.Parser parser, SettingsUtil.ParserContext parserContext, SettingsUtil.Parser parser2, Map.Entry entry) {
        return parser.toString(parserContext, entry.getKey()) + "->" + parser2.toString(parserContext, entry.getValue());
    }

    private static /* synthetic */ Object lambda$parse$2(SettingsUtil.Parser parser, SettingsUtil.ParserContext parserContext, String[] stringArray) {
        return parser.parse(parserContext, stringArray[1]);
    }

    private static /* synthetic */ Object lambda$parse$1(SettingsUtil.Parser parser, SettingsUtil.ParserContext parserContext, String[] stringArray) {
        return parser.parse(parserContext, stringArray[0]);
    }
}
