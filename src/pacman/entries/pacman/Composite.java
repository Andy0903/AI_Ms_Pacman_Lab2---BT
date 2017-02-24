package pacman.entries.pacman;

import java.util.ArrayList;

/**
 * Created by Andy on 2017-02-23.
 */
public abstract class Composite extends Node {

    ArrayList<Node> children = new ArrayList<>();

    public Composite(Node... children)
    {
        for (Node child : children) {
            this.children.add(child);
            child.parent = this;
        }
    }

    @Override
    public void SetChild(Node child) {
        child.parent = this;
        children.add(child);
    }

    @Override
    public Output Process(DataContext data) {

        if (children.size() < 1)
        {
            throw new RuntimeException("Composite without any children processed.");
        }

       return ProcessChildren(data);
    }

    protected abstract Output ProcessChildren(DataContext data);
}
