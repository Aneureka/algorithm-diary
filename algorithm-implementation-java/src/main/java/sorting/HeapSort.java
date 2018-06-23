package sorting;

/**
 * Created by Hiki on 2017/8/20.
 */
public class HeapSort {

    private HeapSort(){}

    public static void sort(Comparable[] pq){
        int n = pq.length;
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
        while (n > 1){
            swap(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    private static void sink(Comparable[] pq, int k, int n){
        while (2*k <= n){
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            swap(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j){
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void swap(Object[] pq, int i, int j){
        Object temp = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = temp;
    }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public static void main(String[] args) {
        String a[] = {"abc", "ww", "ge", "sc", "gs"};
        HeapSort.sort(a);
        show(a);
    }

}

