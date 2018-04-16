package union_find;

/**
 * Created by Hiki on 2017/7/16.
 */
public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    // to find the root of the element
    // if i==id[i], it's the root
    private int root(int i){
        while (i != id[i])
            i = id[i];
        return i;
    }

    // just compare the root of these two element
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    // connect the root of these two element
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }


}
