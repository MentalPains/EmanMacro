package baritone.pathing;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.GoalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class PathFollower {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private static final KeyBinding followPathKey = new KeyBinding("Follow Path", Keyboard.KEY_P, "Macros");

    // Define waypoints
    private static final BlockPos[] waypoints = {
        new BlockPos(-556, 17, -260), new BlockPos(-548, 18, -262),
        new BlockPos(-542, 21, -267), new BlockPos(-531, 22, -272),
        new BlockPos(-528, 18, -282), new BlockPos(-523, 16, -295),
        new BlockPos(-520, 14, -307), new BlockPos(-525, 11, -321),
        new BlockPos(-534, 8, -325), new BlockPos(-546, 5, -318),
        new BlockPos(-557, 6, -314), new BlockPos(-563, 6, -308),
        new BlockPos(-560, 9, -295), new BlockPos(-566, 15, -282),
        new BlockPos(-554, 11, -271), new BlockPos(-546, 8, -270),
        new BlockPos(-538, 6, -274), new BlockPos(-531, 5, -278),
        new BlockPos(-529, 6, -269), new BlockPos(-545, 1, -252),
        new BlockPos(-567, 4, -233), new BlockPos(-579, 7, -228),
        new BlockPos(-595, 19, -214), new BlockPos(-594, 23, -204),
        new BlockPos(-588, 28, -198), new BlockPos(-581, 32, -200),
        new BlockPos(-566, 40, -207), new BlockPos(-566, 38, -214),
        new BlockPos(-582, 35, -218), new BlockPos(-584, 31, -227),
        new BlockPos(-573, 27, -229), new BlockPos(-563, 20, -242)
    };

    private static boolean isFollowingPath = false;
    private static int currentWaypoint = 0;

    public PathFollower() {
        mc.gameSettings.keyBindings = appendKeybinding(mc.gameSettings.keyBindings, followPathKey);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (followPathKey.isPressed()) {
            isFollowingPath = !isFollowingPath;
            mc.thePlayer.sendChatMessage(isFollowingPath ? "🔵 Path Following: ON" : "🔴 Path Following: OFF");
            if (isFollowingPath) followPath();
        }
    }

    private static void followPath() {
        new Thread(() -> {
            while (isFollowingPath) {
                if (currentWaypoint >= waypoints.length) currentWaypoint = 0; // Loop back

                BlockPos target = waypoints[currentWaypoint];
                mc.thePlayer.sendChatMessage("📍 Moving to: " + target);

                BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(new GoalBlock(target));

                // Wait until bot reaches the location before moving to next point
                while (BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing()) {
                    try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                }

                currentWaypoint++; // Move to the next waypoint
            }
        }).start();
    }

    private static KeyBinding[] appendKeybinding(KeyBinding[] original, KeyBinding newKey) {
        KeyBinding[] newBindings = new KeyBinding[original.length + 1];
        System.arraycopy(original, 0, newBindings, 0, original.length);
        newBindings[original.length] = newKey;
        return newBindings;
    }
}
