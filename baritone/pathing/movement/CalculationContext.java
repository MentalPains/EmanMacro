import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.GoalBlock;
import net.minecraft.util.BlockPos;

public class EndermanPath {
    public static void followPath() {
        // Define waypoints
        BlockPos[] waypoints = {
            new BlockPos(-556, 17, -260), // Example X, Y, Z
            new BlockPos(-548, 18, -262),
            new BlockPos(-542, 21, -267),
            new BlockPos(-531, 22, -272),
            new BlockPos(-542, 21, -267),
            new BlockPos(-531, 22, -272),
            new BlockPos(-528, 18, -282),
            new BlockPos(-523, 16, -295),
            new BlockPos(-520, 14, -307),
            new BlockPos(-525, 11, -321),
            new BlockPos(-534, 8, -325),
            new BlockPos(-546, 5, -318),
            new BlockPos(-557, 6, -314),
            new BlockPos(-563, 6, -308),
            new BlockPos(-560, 9, -295),
            new BlockPos(-566, 15, -282),
            new BlockPos(-554, 11, -271),
            new BlockPos(-546, 8, -270),
            new BlockPos(-538, 6, -274),
            new BlockPos(-531, 5, -278),
            new BlockPos(-529, 6, -269),
            new BlockPos(-545, 1, -252),
            new BlockPos(-567, 4, -233),
            new BlockPos(-579, 7, -228),
            new BlockPos(-595, 19, -214),
            new BlockPos(-594, 23, -204),
            new BlockPos(-588, 28, -198),
            new BlockPos(-581, 32, -200),
            new BlockPos(-566, 40, -207),
            new BlockPos(-566, 38, -214),
            new BlockPos(-582, 35, -218),
            new BlockPos(-584, 31, -227),
            new BlockPos(-573, 27, -229),
            new BlockPos(-563, 20, -242)  // Loop back
        };

        for (BlockPos point : waypoints) {
            // Move to each point
            BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(new GoalBlock(point));
            
            // Wait until the bot reaches the destination
            while (!BaritoneAPI.getProvider().getPrimaryBaritone().getPathingBehavior().isPathing()) {
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        }
    }
}
