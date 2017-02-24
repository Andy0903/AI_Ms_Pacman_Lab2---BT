package pacman.entries.pacman;

/**
 * Created by Andy on 2017-02-23.
 */
public class Selector extends Composite {

    public Selector(Node... children)
    {
        super(children);
    }

    @Override
    protected Output ProcessChildren(DataContext data) {

        for (Node child : children) {

            Output childOutput = child.Process(data);

            if (childOutput == Output.RUNNING || childOutput == Output.SUCCESS)
            {
                return childOutput;
            }
        }
        return Output.FAILURE;
    }
}
