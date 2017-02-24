package pacman.entries.pacman;

/**
 * Created by Andy on 2017-02-23.
 */
public class Sequence extends Composite {

    int activeChildIndex = 0;

    public Sequence(Node... children)
    {
        super(children);
    }

    @Override
    protected Output ProcessChildren(DataContext data) {

        for (int i = activeChildIndex; i < children.size(); i++) {

            Output childOutput = children.get(i).Process(data);

            if (childOutput == Output.RUNNING) {
                activeChildIndex = i;
                return childOutput;
            }
            else if (childOutput == Output.FAILURE) {
                activeChildIndex = 0;
                return childOutput;
            }
        }

        activeChildIndex = 0;
        return Output.SUCCESS;
    }
}
