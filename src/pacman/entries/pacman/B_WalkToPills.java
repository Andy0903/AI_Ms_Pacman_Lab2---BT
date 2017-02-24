package pacman.entries.pacman;

import pacman.game.Constants;

/**
 * Created by Andy on 2017-02-23.
 */
public class B_WalkToPills extends Leaf {

    int currentTarget = -1;
    int targetSize;

    @Override
    protected Output ProcessLeaf(DataContext data) {

        if (currentTarget == -1) {
            double closestDist = Double.POSITIVE_INFINITY;
            targetSize = data.targetDistances.length;

            for (int i = 0; i < data.targetDistances.length; i++) {
                if(closestDist > data.targetDistances[i]) {
                    closestDist = data.targetDistances[i];
                    currentTarget = i;
                }
            }
        }

        if (currentTarget != -1)
        {
            if (targetSize > data.targetDistances.length){
                currentTarget = -1;
                return Output.SUCCESS;
            }

            data.nextMove = data.nextMoveToTarget[currentTarget];
            return Output.RUNNING;
        }

        return  Output.FAILURE;
    }
}