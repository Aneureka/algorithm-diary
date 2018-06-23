package sorting;

import java.util.Arrays;

/**
 * Created by Hiki on 2017/7/21.
 */
public class MergeSort {

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        print(a);
    }


    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo)
            return;
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){

        // copy
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // merge
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }

    }


    public static void print(Comparable[] items){
        Arrays.stream(items).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
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
