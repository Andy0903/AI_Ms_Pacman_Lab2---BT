package pacman.entries.pacman;

import pacman.game.Constants;

/**
 * Created by Andy on 2017-02-23.
 */
/*public class B_CheckGhostTooClose extends Leaf {

    @Override
    protected Output ProcessLeaf(DataContext data) {

        final int MIN_DISTANCE=20;	//if a ghost is this close, run away

        for (int i = 0; i < Constants.GHOST.values().length; i++) {
            if(data.ghostDistances[i] < MIN_DISTANCE && data.ghostLairTimes[i] == 0){
                return Output.SUCCESS;
            }
        }

        return  Output.FAILURE;
    }
}
*/