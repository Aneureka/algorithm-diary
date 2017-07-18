package search;

/**
 * Created by Hiki on 2017/7/16.
 */
public class BinarySearch {

    public static int binarySearch(int[] a, int key){

        int low = 0;
        int high = a.length-1;

        if (key < a[low] || key > a[high])
            return -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < a[mid])
                high = mid - 1;
            else if (key > a[mid])
                low = mid + 1;
            else return mid;
        }

        return -1;

    }




}
