package union_find;

import java.util.Arrays;

/**
 * Created by Hiki on 2017/7/16.
 */
public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid)
                id[i] = qid;
    }

    public void print(){

        for (int i = 0; i < id.length; i++)
            System.out.print(i + " ");
        System.out.println();

        Arrays.stream(id).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }


    public static void main(String[] args) {
        QuickFindUF qf = new QuickFindUF(10);
        qf.union(5, 9);
        qf.union(2, 1);
        qf.union(1, 8);
        qf.union(2, 5);
        qf.print();
        System.out.println(qf.connected(1, 9));

    }
}
