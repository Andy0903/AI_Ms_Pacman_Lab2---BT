package pacman.entries.pacman;

import pacman.game.Constants;

import java.lang.reflect.Array;

/**
 * Created by Andy on 2017-02-23.
 */
public class B_HuntGhost extends Leaf {

    @Override
    protected Output ProcessLeaf(DataContext data) {
        int closestDist = Integer.MAX_VALUE;
        int minGhostIndex = -1;

        for (int i = 0; i < Constants.GHOST.values().length; i++) {
            if(closestDist > data.ghostDistances[i] && data.ghostEdibleTimes[i] > 0) {
                closestDist = data.ghostDistances[i];
                minGhostIndex = i;
            }
        }

        if (minGhostIndex != -1)
        {
            data.nextMove = data.nextMoveToGhosts[minGhostIndex];
            return Output.SUCCESS;
        }

        return  Output.FAILURE;
    }
}