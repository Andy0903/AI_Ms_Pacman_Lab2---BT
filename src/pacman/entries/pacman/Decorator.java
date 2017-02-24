package pacman.entries.pacman;

import java.util.ArrayList;

/**
 * Created by Andy on 2017-02-23.
 */
public abstract class Decorator extends Node {

    Node child = null;

    @Override
    public void SetChild(Node child) {
        child.parent = this;
        this.child = child;
    }
    @Override
    public Output Process(DataContext data) {
        if (child == null)
        {
            throw new RuntimeException("Decorator without a child processed.");
        }

        return ProcessChild(data);
    }

    protected abstract Output ProcessChild(DataContext data);
}
