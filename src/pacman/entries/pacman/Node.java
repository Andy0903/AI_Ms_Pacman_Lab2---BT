package pacman.entries.pacman;

import java.util.ArrayList;

/**
 * Created by Andy on 2017-02-21.
 */
public abstract class Node {

    public enum Output {
        SUCCESS,
        FAILURE,
        RUNNING
    }

    protected Node parent = null;

    public abstract void SetChild(Node child);

    public abstract Output Process(DataContext data);
}
