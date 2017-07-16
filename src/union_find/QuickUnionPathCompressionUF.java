package union_find;

/**
 * Created by Hiki on 2017/7/16.
 */
public class QuickUnionPathCompressionUF {

    private int[] id;
    private int count;

    public QuickUnionPathCompressionUF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    // return the number of components
    public int count(){
        return count;
    }

    // return the component identifier for the component containing site
    public int find(int p){
        int root = p;
        while (root != id[root])
            root = id[root];
        // compression when finding
        while (p != root){
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        id[rootP] = rootQ;
        count--;
    }

}
