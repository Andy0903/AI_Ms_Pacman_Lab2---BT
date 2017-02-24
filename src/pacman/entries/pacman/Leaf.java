package pacman.entries.pacman;

/**
 * Created by Andy on 2017-02-23.
 */
public abstract class Leaf extends Node {

    boolean hasInitialized = false;
    /**
     * Called first time a node is visited by parent during execution.
     * Init the node and start the action the node represents.
     */
    public void Init(DataContext data) {

    }

    /**
     * Process Method;
     * Called every tick of the BT while the node is processing.
     * Returns RUNNING, SUCESS, or FAILURE.
     * If this method returns RUNNING it will be called again in the next game tick.
     */
    @Override
    public Output Process(DataContext data) {
        if (!hasInitialized)
        {
            Init(data);
            hasInitialized = true;
        }
        return ProcessLeaf(data);
    }

    protected abstract Output ProcessLeaf(DataContext data);

    @Override
    public void SetChild(Node child) {
        throw new RuntimeException("Tried to add children to a leaf node.");
    }
}
