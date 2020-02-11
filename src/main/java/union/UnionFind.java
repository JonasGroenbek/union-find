package union;

public class UnionFind implements Unions {

    private int[] unions;
    private int[] setSizes;
    private int count;

    /**
     * Constructor
     * @param n the amount of root nodes to create
     */
    public UnionFind(int n){
        count = n;
        unions = new int[n];
        setSizes = new int[n];

        for(int i = 0; i < n; i++){
            unions[i] = i;
            setSizes[i] = 1;
        }
    }

    /*
    public int nodeDepth(int node){
        int depth = 1;
        while(union[node] != node){
            node = union[node];
            depth = depth + 1;
        }
        return depth;
    }
    */

    /**
     * Unifying two nodes and prioritize to point the shallow root to the deep root, should depth difference exist.
     * @param p node p
     * @param q node q
     */
    @Override
    public boolean union(int p, int q) {
        if(connected(p, q)) return false;
        int pRoot = find(p);
        int qRoot= find(q);

        if(setSizes[qRoot] > setSizes[pRoot]){
            unions[qRoot] = pRoot;
            setSizes[qRoot] += setSizes[pRoot];
        } else {
            unions[pRoot] = qRoot;
            setSizes[pRoot] += setSizes[qRoot];
        }
        unions[p] = q;
        count--;
        return true;
    }

    /**
     * returns the root of a specific node
     * @param p node index
     */
    @Override
    public int find(int p) {
        fit(p);
        while (p != unions[p])
            p = unions[p];
        return p;
    }

    /**
     * Checks whether the index input fits the union array
     * @param p node index
     * @throws IllegalArgumentException
     */
    private void fit(int p){
        if ( p >= unions.length || p < 0 ) throw new IllegalArgumentException("index does not exist");
    }

    /**
     *
     * @param p node index
     * @param q node index
     * @return whether or not the two nodes are in the same tree
     */
    @Override
    public boolean connected(int p, int q) { return find(p) == find(q); }

    /**
     * gets the amount of sets
     * @return count
     */
    @Override
    public int count() { return count; }
}

class main {
    public static void main(String[] args) {
            UnionFind uf = new UnionFind(10);
            //Test...
    }
}
