package pacman.entries.pacman;

import pacman.game.Constants;
import pacman.game.Game;

import java.util.ArrayList;

/**
 * Created by Andy on 2017-02-21.
 */
public class DataContext {

    public int[] ghostEdibleTimes = new int[4];
    public int[] ghostDistances = new int[4];
    public int[] ghostLairTimes = new int[4];
    public Constants.MOVE[] nextMoveToGhosts = new Constants.MOVE[4];
    public Constants.MOVE[] nextMoveAwayFromGhosts = new Constants.MOVE[4];

    public boolean[] pillsAvailable;
    public boolean[] powerPillsAvailable;
    public double[] targetDistances;
    public Constants.MOVE[] nextMoveToTarget;

    public int[] ghostNodeIndices = new int[4];
    public int pacmanCurrentNodeIndex;
    public Constants.MOVE nextMove = Constants.MOVE.NEUTRAL;

    public DataContext(Game game)
    {
        pacmanCurrentNodeIndex=game.getPacmanCurrentNodeIndex();

        for (int i = 0; i < Constants.GHOST.values().length; i++) {
            ghostLairTimes[i] = game.getGhostLairTime(Constants.GHOST.values()[i]);
            ghostEdibleTimes[i] = game.getGhostEdibleTime(Constants.GHOST.values()[i]);
            ghostNodeIndices[i] = game.getGhostCurrentNodeIndex(Constants.GHOST.values()[i]);
            ghostDistances[i] = game.getShortestPathDistance(pacmanCurrentNodeIndex, ghostNodeIndices[i]);
            nextMoveToGhosts[i] = game.getNextMoveTowardsTarget(pacmanCurrentNodeIndex, ghostNodeIndices[i], Constants.DM.PATH);
            nextMoveAwayFromGhosts[i] = game.getNextMoveAwayFromTarget(pacmanCurrentNodeIndex, ghostNodeIndices[i], Constants.DM.PATH);
        }


        ArrayList<Integer> targets = new ArrayList<>();

        int[] pills=game.getPillIndices();
        pillsAvailable = new boolean[pills.length];
        for(int i=0;i<pills.length;i++){
            pillsAvailable[i] = game.isPillStillAvailable((i));
            if(pillsAvailable[i] == true){
                targets.add(pills[i]);
            }
        }

        int[] powerPills=game.getPowerPillIndices();
        powerPillsAvailable = new boolean[pills.length];
        for(int i=0;i<powerPills.length;i++){
            powerPillsAvailable[i] = game.isPowerPillStillAvailable((i));
            if(powerPillsAvailable[i] == true){
                targets.add(pills[i]);
            }
        }

        targetDistances = new double[targets.size()];
        nextMoveToTarget = new Constants.MOVE[targets.size()];
        for (int i = 0; i < targetDistances.length; i++) {
            targetDistances[i] = game.getDistance(pacmanCurrentNodeIndex, targets.get(i), Constants.DM.PATH);
            nextMoveToTarget[i] = game.getNextMoveTowardsTarget(pacmanCurrentNodeIndex, targets.get(i), Constants.DM.PATH);
        }

    }
}
