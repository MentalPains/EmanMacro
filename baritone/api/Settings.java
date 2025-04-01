/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  afh
 *  ave
 *  eu
 */
package baritone.api;

import baritone.api.utils.NotificationHelper;
import baritone.api.utils.SettingsUtil;
import baritone.api.utils.TypeUtils;
import java.awt.Color;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Settings {
    public final Setting<Boolean> splicePath = new Setting(Boolean.TRUE);
    public final Setting<Double> maxYawOffsetForForward = new Setting(15.0);
    public final Setting<Boolean> checkOvershootParkour = new Setting(Boolean.TRUE);
    public final Setting<Integer> pathHistoryCutoffAmount = new Setting(50);
    public final Setting<Integer> maxPathHistoryLength = new Setting(300);
    public final Setting<Boolean> allowOvershootDiagonalDescend = new Setting(Boolean.FALSE);
    public final Setting<Boolean> sprintAscends = new Setting(Boolean.TRUE);
    public final Setting<Double> maxCostIncrease = new Setting(10.0);
    public final Setting<Double> pathCutoffFactor = new Setting(0.9);
    public final Setting<Double> maxDistFromPath = new Setting(3.0);
    public final Setting<Double> maxMaxDistFromPath = new Setting(4.0);
    public final Setting<Integer> pathCutoffMinimumLength = new Setting(30);
    public final Setting<Boolean> cutoffAtLoadBoundary = new Setting(Boolean.FALSE);
    public final Setting<Long> primaryTimeoutMS = new Setting(500L);
    public final Setting<Long> failureTimeoutMS = new Setting(2000L);
    public final Setting<Long> planAheadPrimaryTimeoutMS = new Setting(4000L);
    public final Setting<Long> planAheadFailureTimeoutMS = new Setting(5000L);
    public final Setting<Boolean> simplifyUnloadedYCoord = new Setting(Boolean.TRUE);
    public final Setting<Boolean> slowPath = new Setting(Boolean.FALSE);
    public final Setting<Long> slowPathTimeDelayMS = new Setting(100L);
    public final Setting<Boolean> minimumImprovementRepropagation = new Setting(Boolean.TRUE);
    public final Setting<Long> slowPathTimeoutMS = new Setting(40000L);
    public final Setting<Integer> pathingMapDefaultSize = new Setting(1024);
    public final Setting<Float> pathingMapLoadFactor = new Setting(Float.valueOf(0.75f));
    public final Setting<Boolean> allowParkour = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowJumpAt256 = new Setting(Boolean.TRUE);
    public final Setting<Boolean> allowParkourAscend = new Setting(Boolean.FALSE);
    public final Setting<Float> yawSmoothingFactor = new Setting(Float.valueOf(0.2f));
    public final Setting<Float> pitchSmoothingFactor = new Setting(Float.valueOf(0.2f));
    public final Setting<Boolean> safeMode = new Setting(Boolean.TRUE);
    public final Setting<Boolean> allowDiagonalDescend = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowDiagonalAscend = new Setting(Boolean.FALSE);
    public final Setting<Integer> rightClickSpeed = new Setting(4);
    public final Setting<Double> walkOnWaterOnePenalty = new Setting(3.0);
    public final Setting<Double> jumpPenalty = new Setting(2.0);
    public final Setting<Double> backtrackCostFavoringCoefficient = new Setting(0.5);
    public final Setting<Integer> maxFallHeightNoWater = new Setting(10);
    public final Setting<Boolean> allowDownward = new Setting(Boolean.TRUE);
    public final Setting<Boolean> allowSprint = new Setting(Boolean.TRUE);
    public final Setting<Boolean> renderPathIgnoreDepth = new Setting(Boolean.TRUE);
    public final Setting<Float> pathRenderLineWidthPixels = new Setting(Float.valueOf(5.0f));
    public final Setting<Boolean> fadePath = new Setting(Boolean.FALSE);
    public final Setting<Color> colorCurrentPath = new Setting(Color.RED);
    public final Setting<Boolean> renderPath = new Setting(Boolean.TRUE);
    public final Setting<Integer> movementTimeoutTicks = new Setting(600);
    public final Setting<Integer> costVerificationLookahead = new Setting(5);
    public final Setting<Boolean> allowWalkOnBottomSlab = new Setting(Boolean.TRUE);
    public final Setting<Boolean> assumeWalkOnLava = new Setting(Boolean.FALSE);
    public final Setting<Boolean> allowVines = new Setting(Boolean.FALSE);
    public final Setting<Boolean> assumeWalkOnWater = new Setting(Boolean.FALSE);
    public final Setting<List<afh>> blocksToAvoid = new Setting(new ArrayList());
    public final Setting<Boolean> sprintInWater = new Setting(Boolean.FALSE);
    public final Setting<Boolean> overshootTraverse = new Setting(Boolean.TRUE);
    public final Setting<Boolean> assumeStep = new Setting(Boolean.FALSE);
    public final Setting<Integer> pathingMaxChunkBorderFetch = new Setting(50);
    public final Setting<Integer> planningTickLookahead = new Setting(150);
    public final Setting<Boolean> disconnectOnArrival = new Setting(Boolean.FALSE);
    public final Setting<Double> costHeuristic = new Setting(3.563);
    public final Setting<Integer> axisHeight = new Setting(120);
    public final Setting<Boolean> pathThroughCachedOnly = new Setting(Boolean.FALSE);
    public final Setting<Double> randomLooking = new Setting(0.0);
    public final Setting<Float> blockReachDistance = new Setting(Float.valueOf(4.5f));
    public final Setting<Double> randomLooking113 = new Setting(0.0);
    public final Setting<Boolean> freeLook = new Setting(Boolean.FALSE);
    public final Setting<Boolean> blockFreeLook = new Setting(Boolean.FALSE);
    public final Setting<Boolean> antiCheatCompatibility = new Setting(Boolean.TRUE);
    public final Setting<Boolean> shortBaritonePrefix = new Setting(Boolean.FALSE);
    public final Setting<Boolean> chatDebug = new Setting(Boolean.FALSE);
    public final Setting<Boolean> desktopNotifications = new Setting(Boolean.FALSE);
    public final Setting<Boolean> censorCoordinates = new Setting(Boolean.FALSE);
    @JavaOnly
    public final Setting<Consumer<eu>> logger = new Setting(eu2 -> ave.A().q.d().a(eu2));
    @JavaOnly
    public final Setting<BiConsumer<String, Boolean>> notifier = new Setting(NotificationHelper::notify);
    public final Map<String, Setting<?>> byLowerName;
    public final List<Setting<?>> allSettings;
    public final Map<Setting<?>, Type> settingTypes;

    Settings() {
        Field[] fieldArray = this.getClass().getFields();
        HashMap<String, Setting> hashMap = new HashMap<String, Setting>();
        ArrayList<Setting> arrayList = new ArrayList<Setting>();
        HashMap<Setting, Type> hashMap2 = new HashMap<Setting, Type>();
        try {
            for (Field field : fieldArray) {
                if (!field.getType().equals(Setting.class)) continue;
                Setting setting = (Setting)field.get(this);
                String string = field.getName();
                setting.name = string;
                setting.javaOnly = field.isAnnotationPresent(JavaOnly.class);
                string = string.toLowerCase();
                if (hashMap.containsKey(string)) {
                    throw new IllegalStateException("Duplicate setting name");
                }
                hashMap.put(string, setting);
                arrayList.add(setting);
                hashMap2.put(setting, ((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0]);
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
        this.byLowerName = Collections.unmodifiableMap(hashMap);
        this.allSettings = Collections.unmodifiableList(arrayList);
        this.settingTypes = Collections.unmodifiableMap(hashMap2);
    }

    public <T> List<Setting<T>> getAllValuesByType(Class<T> clazz) {
        ArrayList<Setting<T>> arrayList = new ArrayList<Setting<T>>();
        for (Setting<?> setting : this.allSettings) {
            if (!setting.getValueClass().equals(clazz)) continue;
            arrayList.add(setting);
        }
        return arrayList;
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.FIELD})
    static @interface JavaOnly {
    }

    public final class Setting<T> {
        public T value;
        public final T defaultValue;
        private String name;
        private boolean javaOnly;

        private Setting(T t) {
            if (t == null) {
                throw new IllegalArgumentException("Cannot determine value type class from null");
            }
            this.value = t;
            this.defaultValue = t;
            this.javaOnly = false;
        }

        public final String getName() {
            return this.name;
        }

        public final Class<T> getValueClass() {
            return TypeUtils.resolveBaseClass(this.getType());
        }

        public final String toString() {
            return SettingsUtil.settingToString(this);
        }

        public final void reset() {
            this.value = this.defaultValue;
        }

        public final Type getType() {
            return Settings.this.settingTypes.get(this);
        }

        public final boolean isJavaOnly() {
            return this.javaOnly;
        }
    }
}
