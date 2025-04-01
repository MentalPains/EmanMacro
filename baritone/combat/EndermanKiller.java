package baritone.combat;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;

public class EndermanKiller {
    private static final Minecraft mc = Minecraft.getMinecraft();

    public static void killEndermen() {
        for (Object entity : mc.theWorld.loadedEntityList) {
            if (entity instanceof EntityEnderman enderman) {
                
                // Check if Enderman is within attack range
                if (mc.thePlayer.getDistanceToEntity(enderman) < 6) {
                    
                    // Smoothly face the Enderman
                    Vec3 lookAt = new Vec3(enderman.posX, enderman.posY + 1, enderman.posZ);
                    HumanLikeCamera.smoothlyLookAt(lookAt);

                    // Attack
                    mc.playerController.attackEntity(mc.thePlayer, enderman);
                    mc.thePlayer.swingItem();
                }
            }
        }
    }
}
