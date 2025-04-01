/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afh
 *  cq
 *  df
 *  jy
 *  zw
 */
package baritone.api.utils;

import baritone.api.utils.BlockUtils;
import baritone.api.utils.SettingsUtil;
import baritone.api.utils.TypeUtils;
import java.awt.Color;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

static enum SettingsUtil.Parser implements SettingsUtil.ISettingParser
{
    DOUBLE(Double.class, Double::parseDouble),
    BOOLEAN(Boolean.class, Boolean::parseBoolean),
    INTEGER(Integer.class, Integer::parseInt),
    FLOAT(Float.class, Float::parseFloat),
    LONG(Long.class, Long::parseLong),
    STRING(String.class, String::new),
    DIRECTION(cq.class, cq::a),
    COLOR(Color.class, string -> new Color(Integer.parseInt(string.split(",")[0]), Integer.parseInt(string.split(",")[1]), Integer.parseInt(string.split(",")[2])), color -> color.getRed() + "," + color.getGreen() + "," + color.getBlue()),
    VEC3I(df.class, string -> new df(Integer.parseInt(string.split(",")[0]), Integer.parseInt(string.split(",")[1]), Integer.parseInt(string.split(",")[2])), df2 -> df2.n() + "," + df2.o() + "," + df2.p()),
    BLOCK(afh.class, string -> BlockUtils.stringToBlockRequired(string.trim()), BlockUtils::blockToString),
    ITEM(zw.class, string -> (zw)zw.e.a((Object)new jy(string.trim())), zw2 -> ((jy)zw.e.c(zw2)).toString()),
    LIST{

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
    ,
    MAPPING{

        @Override
        public final Object parse(SettingsUtil.ParserContext parserContext, String string2) {
            Object object = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0];
            Object object2 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[1];
            object = SettingsUtil.Parser.getParser((Type)object);
            object2 = SettingsUtil.Parser.getParser((Type)object2);
            return Stream.of(string2.split(",(?=[^,]*->)")).map(string -> string.split("->")).collect(Collectors.toMap(arg_0 -> 2.lambda$parse$1((SettingsUtil.Parser)object, parserContext, arg_0), arg_0 -> 2.lambda$parse$2((SettingsUtil.Parser)object2, parserContext, arg_0)));
        }

        @Override
        public final String toString(SettingsUtil.ParserContext parserContext, Object object) {
            Object object2 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[0];
            Object object3 = ((ParameterizedType)parserContext.getSetting().getType()).getActualTypeArguments()[1];
            object2 = SettingsUtil.Parser.getParser((Type)object2);
            object3 = SettingsUtil.Parser.getParser((Type)object3);
            return ((Map)object).entrySet().stream().map(arg_0 -> 2.lambda$toString$3((SettingsUtil.Parser)object2, parserContext, (SettingsUtil.Parser)object3, arg_0)).collect(Collectors.joining(","));
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
    };

    private final Class<?> cla$$;
    private final Function<String, Object> parser;
    private final Function<Object, String> toString;

    private SettingsUtil.Parser() {
        this.cla$$ = null;
        this.parser = null;
        this.toString = null;
    }

    private <T> SettingsUtil.Parser(Class<T> clazz, Function<String, T> function) {
        this(clazz, function, Object::toString);
    }

    private <T> SettingsUtil.Parser(Class<T> clazz, Function<String, T> function, Function<T, String> function2) {
        this.cla$$ = clazz;
        this.parser = function::apply;
        this.toString = object -> (String)function2.apply(object);
    }

    public Object parse(SettingsUtil.ParserContext object, String string) {
        object = this.parser.apply(string);
        Objects.requireNonNull(object);
        return object;
    }

    public String toString(SettingsUtil.ParserContext parserContext, Object object) {
        return this.toString.apply(object);
    }

    @Override
    public boolean accepts(Type type) {
        return type instanceof Class && this.cla$$.isAssignableFrom((Class)type);
    }

    public static SettingsUtil.Parser getParser(Type type) {
        return Stream.of(SettingsUtil.Parser.values()).filter(parser -> parser.accepts(type)).findFirst().orElse(null);
    }
}
