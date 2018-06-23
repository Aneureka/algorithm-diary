package searching;

/**
 * Created by Hiki on 2017/7/16.
 */
public class BinarySearch {

    // 迭代实现
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

    // 递归实现
    public static int binarySearchV2(int[] a, int key, int low, int high){

        if (high < low) return low;
        int mid = low + high >> 1;
        if (key < mid)
            return binarySearchV2(a, key, low, mid-1);
        else if (key > mid)
            return binarySearchV2(a, key, mid+1, high);
        else
            return mid;
    }


}
