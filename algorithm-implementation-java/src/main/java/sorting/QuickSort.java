package sorting;

import java.util.Arrays;

/**
 * Created by Hiki on 2017/7/22.
 */
public class QuickSort {

    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
        print(a);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        while (true){
            // find item on left to swap
            while (less(a[++i], a[lo]))
                if (i == hi) break;

            // find item on right to swap
            while (less(a[lo], a[--j]))
                if (j == lo) break;

            // check if pointers cross
            if (i >= j) break;
            swap(a, i, j);
        }

        // swap with the partitioning item
        swap(a, lo, j);
        return j;
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);

    }


    public static void print(Comparable[] a){
        Arrays.stream(a).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {
        int n = 10;
        Comparable[] t = new Comparable[n];
        for (int i = 0; i < t.length; i++){
            t[i] = (int)(Math.random()*10);
        }

        sort(t);
    }

}
