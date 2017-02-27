package pacman.entries.pacman;

import pacman.game.Constants;

import java.lang.reflect.Array;

/**
 * Created by Andy on 2017-02-23.
 */
public class B_HuntGhost extends Leaf {

    final int MIN_DISTANCE=20;
    int minGhostIndex = -1;

    @Override
    protected Output ProcessLeaf(DataContext data) {
        int closestDist = Integer.MAX_VALUE;

        for (int i = 0; i < Constants.GHOST.values().length; i++) {
            if(data.ghostDistances[i] < MIN_DISTANCE && data.ghostLairTimes[i] <= 0){   //if a ghost is too close
                if(data.ghostEdibleTimes[i] > 0) {                                      //if a ghost is edible
                    if(closestDist > data.ghostDistances[i]) {
                        closestDist = data.ghostDistances[i];
                        minGhostIndex = i;
                    }
                }
            }
        }

        if (minGhostIndex != -1 && data.ghostEdibleTimes[minGhostIndex] > 0){
            if (data.pacmanCurrentNodeIndex == data.ghostNodeIndices[minGhostIndex]) {
                minGhostIndex = -1;
                System.out.println("Success HuntGhost");
                return Output.SUCCESS;
            }

            data.nextMove = data.nextMoveToGhosts[minGhostIndex];
            System.out.println("Running HuntGhost");
            return Output.RUNNING;
        }

        minGhostIndex = -1;
        System.out.println("Failure HuntGhost");
        return Output.FAILURE;
    }
}