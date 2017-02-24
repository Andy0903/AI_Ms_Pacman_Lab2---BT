package pacman.entries.pacman;

/**
 * Created by Andy on 2017-02-23.
 */
public class B_CheckPills extends Leaf {

    @Override
    protected Output ProcessLeaf(DataContext data) {
        for (boolean pill : data.pillsAvailable) {
            if (pill == true){
                return Output.SUCCESS;
            }
        }

        for (boolean pill : data.powerPillsAvailable) {
            if (pill == true){
                return Output.SUCCESS;
            }
        }

        return Output.FAILURE;
    }
}