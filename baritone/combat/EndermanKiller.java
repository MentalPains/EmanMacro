package baritone.combat;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class EndermanKiller {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private static final KeyBinding killEndermanKey = new KeyBinding("Kill Endermen", Keyboard.KEY_K, "Macros");

    public EndermanKiller() {
        // Register the keybinding
        mc.gameSettings.keyBindings = appendKeybinding(mc.gameSettings.keyBindings, killEndermanKey);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (killEndermanKey.isPressed()) {
            mc.thePlayer.sendChatMessage("Enderman Kill Macro Activated!");
            killEndermen();
        }
    }

    public static void killEndermen() {
        for (Object entity : mc.theWorld.loadedEntityList) {
            if (entity instanceof EntityEnderman enderman) {
                if (mc.thePlayer.getDistanceToEntity(enderman) < 6) {
                    Vec3 lookAt = new Vec3(enderman.posX, enderman.posY + 1, enderman.posZ);
                    HumanLikeCamera.smoothlyLookAt(lookAt);

                    // Attack
                    mc.playerController.attackEntity(mc.thePlayer, enderman);
                    mc.thePlayer.swingItem();
                }
            }
        }
    }

    private static KeyBinding[] appendKeybinding(KeyBinding[] original, KeyBinding newKey) {
        KeyBinding[] newBindings = new KeyBinding[original.length + 1];
        System.arraycopy(original, 0, newBindings, 0, original.length);
        newBindings[original.length] = newKey;
        return newBindings;
    }
}
