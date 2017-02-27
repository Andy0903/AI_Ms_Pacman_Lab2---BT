package pacman.entries.pacman;

import pacman.game.Constants;

/**
 * Created by Andy on 2017-02-23.
 */
public class B_WalkToPills extends Leaf {

    int currentTarget = -1;
    int targetSize;
    boolean targetExists = false;

    @Override
    protected Output ProcessLeaf(DataContext data) {

        if (!targetExists){
            for (boolean pill : data.pillsAvailable) {
                if (pill == true){
                    targetExists = true;
                }
            }

            for (boolean pill : data.powerPillsAvailable) {
                if (pill == true){
                    targetExists = true;
                }
            }
        }

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

        int ghostDist = 20;
        for (int i = 0; i < Constants.GHOST.values().length; i++) {
            if(ghostDist > data.ghostDistances[i] && data.ghostLairTimes[i] <= 0) {
                currentTarget = -1;
            }
        }

        if (currentTarget != -1)
        {
            if (targetSize > data.targetDistances.length){
                currentTarget = -1;
                System.out.println("Success WalkToPill");
                return Output.SUCCESS;
            }

            data.nextMove = data.nextMoveToTarget[currentTarget];
            System.out.println("Running WalkToPill");
            return Output.RUNNING;
        }

        currentTarget = -1;
        System.out.println("Failure WalkToPill");
        return  Output.FAILURE;
    }
}