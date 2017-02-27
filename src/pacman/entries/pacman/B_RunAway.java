package pacman.entries.pacman;

import pacman.game.Constants;

/**
 * Created by Andy on 2017-02-23.
 */
public class B_RunAway extends Leaf {

    final int MIN_DISTANCE=20;
    int minGhostIndex = -1;
    @Override
    protected Output ProcessLeaf(DataContext data) {
        int closestDist = Integer.MAX_VALUE;

        for (int i = 0; i < Constants.GHOST.values().length; i++) {
            if(closestDist > data.ghostDistances[i] && data.ghostLairTimes[i] <= 0) {
                closestDist = data.ghostDistances[i];
                minGhostIndex = i;
            }
        }


        if (minGhostIndex != -1) {
            if (closestDist > MIN_DISTANCE){
            minGhostIndex = -1;
                System.out.println("Success RunAway");
            return Output.SUCCESS;
            }

            data.nextMove = data.nextMoveAwayFromGhosts[minGhostIndex];
            System.out.println("Running RunAway");
            return Output.RUNNING;
        }

        minGhostIndex = -1;
        System.out.println("Failure RunAway");
        return Output.FAILURE;
    }
}