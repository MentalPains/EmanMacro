package baritone.combat;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import java.util.Random;

public class HumanLikeCamera {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private static final float ROTATION_SPEED = 5.0f; // Degrees per tick (adjust as needed)
    private static final Random random = new Random();

    public static void smoothlyLookAt(Vec3 target) {
        float targetYaw = getYawTo(target);
        float targetPitch = getPitchTo(target);

        mc.thePlayer.rotationYaw = smoothRotation(mc.thePlayer.rotationYaw, targetYaw, ROTATION_SPEED);
        mc.thePlayer.rotationPitch = smoothRotation(mc.thePlayer.rotationPitch, targetPitch, ROTATION_SPEED);
    }

    private static float smoothRotation(float current, float target, float speed) {
        float diff = target - current;

        // Ensure shortest rotation path
        if (diff > 180) diff -= 360;
        if (diff < -180) diff += 360;

        // Add small random variance for natural feel
        float randomness = (random.nextFloat() - 0.5f) * 2.0f;
        speed += randomness;

        // Apply smoothing
        if (diff > speed) return current + speed;
        if (diff < -speed) return current - speed;
        return target;
    }

    private static float getYawTo(Vec3 target) {
        double dx = target.xCoord - mc.thePlayer.posX;
        double dz = target.zCoord - mc.thePlayer.posZ;
        return (float) Math.toDegrees(Math.atan2(dz, dx)) - 90;
    }

    private static float getPitchTo(Vec3 target) {
        double dx = target.xCoord - mc.thePlayer.posX;
        double dy = target.yCoord - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
        double dz = target.zCoord - mc.thePlayer.posZ;
        double distance = Math.sqrt(dx * dx + dz * dz);
        return (float) -Math.toDegrees(Math.atan2(dy, distance));
    }
}
