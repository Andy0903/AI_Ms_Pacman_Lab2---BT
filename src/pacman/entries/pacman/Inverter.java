package pacman.entries.pacman;

/**
 * Created by Andy on 2017-02-23.
 */
public class Inverter extends Decorator {

    @Override
    protected Output ProcessChild(DataContext data) {
        Output childOutput = child.Process(data);

        if (childOutput == Output.FAILURE)
        {
            return Output.SUCCESS;
        }
        else if (childOutput == Output.SUCCESS)
        {
            return Output.FAILURE;
        }

        return childOutput;
    }
}
