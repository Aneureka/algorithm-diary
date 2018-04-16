package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by Hiki on 2017/7/21.
 */
public class ElementalSort {

    // Selection Sort
    public static void selectionSort(Comparable[] items){
        int n = items.length;
        for (int i = 0; i < n; i++){
            // find the smallest item after this one
            int min = i;
            for (int j = i+1; j < n; j++)
                if (less(items[j], items[min]))
                    min = j;
            swap(items, i, min);
        }

        print(items);

    }

    // Insertion Sort
    public static void insertionSort(Comparable[] items){
        int n = items.length;
        for (int i = 0; i < n; i++)
            for (int j = i; j > 0 && less(items[j], items[j-1]); j--)
                    swap(items, j, j-1);

        print(items);

    }

    // Shell Sort
    public static void shellSort(Comparable[] items){
        int n = items.length;

        // compute h: h = 3h + 1
        int h = 1;
        while (h < n/3)
            h = 3*h + 1;

        // h-insertion_sort
        while (h >= 1){
            for (int i = h; i < n; i++)
                for (int j = i; j >= h && less(items[j], items[j-h]); j -= h)
                    swap(items, j, j-h);
            h = h / 3;
        }

        print(items);
    }


    public static void print(Comparable[] items){
        Arrays.stream(items).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void swap(Comparable[] items, int i, int j){
        Comparable tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 10;
        Comparable[] t = new Comparable[n];
        for (int i = 0; i < t.length; i++){
            t[i] = (int)(Math.random()*10);
        }

        shellSort(t);
    }
}
