package pacman.entries.pacman;

import pacman.game.Constants;

/**
 * Created by Andy on 2017-02-23.
 */
public class B_RunAway extends Leaf {

    @Override
    protected Output ProcessLeaf(DataContext data) {
        int closestDist = Integer.MAX_VALUE;
        int minGhostIndex = -1;

        for (int i = 0; i < Constants.GHOST.values().length; i++) {
            if(closestDist > data.ghostDistances[i]) {
                closestDist = data.ghostDistances[i];
                minGhostIndex = i;
            }
        }

        if (minGhostIndex != -1) {
            data.nextMove = data.nextMoveAwayFromGhosts[minGhostIndex];
            return Output.SUCCESS;
        }

        return  Output.FAILURE;
    }
}