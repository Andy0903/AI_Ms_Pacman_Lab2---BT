package pacman.entries.pacman;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	Node rootNode;

	public MyPacMan()
	{
		/*rootNode = new Selector(
						new Sequence(
							new B_CheckGhostTooClose(),
							new Selector(
								new Sequence(
									new B_CheckEdibleGhost(),
									new B_HuntGhost()),
								new B_RunAway())),
						new Sequence(
							new B_CheckPills(),
							new B_WalkToPills()));*/

		rootNode = new Selector(
						new B_HuntGhost(),
						new Sequence(
								new B_RunAway(),
								new B_WalkToPills()));
	}

	public MOVE getMove(Game game, long timeDue) 
	{
		DataContext data = new DataContext(game);
		rootNode.Process(data);
		return data.nextMove;
	}
}