package com.yourmod;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.GoalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Arrays;
import java.util.List;

public class EndermanHunter {
    private final Minecraft mc = Minecraft.getMinecraft();
    private boolean hunting = true;
    private int currentWaypoint = 0;

    // Define the movement path
    private final List<BlockPos> path = Arrays.asList(
        new BlockPos(-553, 18, -261),
        new BlockPos(-542, 20, -266),
        new BlockPos(-531, 22, -271),
        new BlockPos(-529, 21, -276),
        new BlockPos(-526, 15, -290),
        new BlockPos(-523, 16, -295),
        new BlockPos(-529, 21, -276),
        new BlockPos(-529, 21, -276),
        new BlockPos(-529, 21, -276),
        new BlockPos(-529, 21, -276),
    );

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (!hunting || mc.thePlayer == null) return;

        // Attack nearby Endermen
        for (Entity entity : mc.theWorld.loadedEntityList) {
            if (entity instanceof EntityEnderman) {
                mc.playerController.attackEntity(mc.thePlayer, entity);
                mc.thePlayer.swingItem();
                return; // Stop and attack first before moving
            }
        }

        // Move to the next waypoint if close to current one
        if (mc.thePlayer.getDistance(path.get(currentWaypoint).getX(), path.get(currentWaypoint).getY(), path.get(currentWaypoint).getZ()) < 2) {
            moveToNextWaypoint();
        }
    }

    private void moveToNextWaypoint() {
        currentWaypoint = (currentWaypoint + 1) % path.size();
        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(
            new GoalBlock(path.get(currentWaypoint))
        );
    }
}
