package pacman.entries.pacman;

/**
 * Created by Andy on 2017-02-27.
 */
public class RepeatUntilFail extends Decorator {

    @Override
    protected Output ProcessChild(DataContext data) {

            Output childOutput = child.Process(data);
            while (childOutput != Output.FAILURE) {
                child.Process(data);
            }

            return Output.SUCCESS;
    }
}
