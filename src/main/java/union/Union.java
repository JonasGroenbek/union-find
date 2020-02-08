package union;

public class Union implements IUnion {

    int[] union;

    /**
     * Constructor
     * @param amountOfNodes the amount of root nodes to create
     */
    public Union(int amountOfNodes){
        union = new int[amountOfNodes];
        for(int i = 0; i < amountOfNodes; i++){
            union[i] = i;
        }
    }

    public int nodeDepth(int node){
        int depth = 1;
        while(union[node] != node){
            System.out.println(find(node));
            node = union[node];
            depth = depth + 1;
        }
        return depth;
    }

    /**
     * Unifying p's root node into q's root node
     * @param p
     * @param q
     */
    @Override
    public boolean union(int p, int q) {
        if(connected(p, q)) {
            return false;
        }
        System.out.println("setting " + p + " to " + q);
        union[p] = q;
        return true;
    }

    /**
     * Unifying two nodes if they do not belong in the same forrest. If there is a depth difference in the trees,
     * point the shallow root to the deep root.
     * @param p node p
     * @param q node q
     */
    public void weightedUnion(int p, int q) {
        //TODO
    }

    /**
     * Get the parent of a specific node
     * @param p node
     * @return parent node index
     */
    @Override
    public int find(int p) {
        return union[p];
    }

    /**
     *
     * @param p node p
     * @param q node q
     * @return whether or not the two nodes are in the same forrest
     */
    @Override
    public boolean connected(int p, int q) {
        int pRoot = p;
        int qRoot = q;
        while(union[p] != p){
            p = union[p];
            pRoot =  p;
        }

        while(union[q] != q){
            q = union[q];
            qRoot = q;
        }

        return pRoot == qRoot;
    }

    /**
     * gets the size of the union strucutre
     * @return int size
     */
    @Override
    public int count() {
        return union.length;
    }
}