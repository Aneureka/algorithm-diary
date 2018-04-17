package data_structure.priority_queue;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Created by Hiki on 2017/8/20.
 */
public class MaxPQ<T> {

    private T[] pq;
    private int n;
    private Comparator<T> comparator;

    public MaxPQ(int initCapacity){
        pq = (T[]) new Object[initCapacity+1];
        n = 0;
    }

    public MaxPQ(){
        this(1);
    }

    public MaxPQ(int initCapacity, Comparator<T> comparator){
        this(initCapacity);
        this.comparator = comparator;
    }

    public MaxPQ(Comparator<T> comparator){
        this(1, comparator);
    }

    public MaxPQ(T[] keys){
        n = keys.length;
        pq = (T[]) new Object[keys.length+1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }


    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public T max(){
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow.");
        return pq[1];
    }

    private void resize(int capacity){

        T[] temp = (T[]) new Object[capacity];
        for (int i = 1; i < n && i < capacity; i++){
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(T t){
        // double size of array if necessary
        if (n == pq.length - 1)
            resize(2 * pq.length);
        pq[++n] = t;
        swim(n);
        assert isMaxHeap();
    }

    public T delMax(){
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow.");
        T max = pq[1];
        swap(1, n--);
        sink(1);
        pq[n+1] = null;
        if (n > 0 && n == (pq.length-1)/4)
            resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }

    // 上浮
    private void swim(int k){
        while (k > 1 && less(k/2, k)){
            swap(k, k/2);
            k /= 2;
        }
    }

    // 下沉
    private void sink(int k){
        while (2*k <= n){
            int j = 2 * k;
            if (j < n && less(j, j+1))
                j++;
            if (!less(k, j))
                break;
            swap(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        if (comparator == null)
            return ((Comparable<T>) pq[i]).compareTo(pq[j]) < 0;
        else
            return comparator.compare(pq[i], pq[j]) < 0;
    }

    private void swap(int i, int j){
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean isMaxHeap(){
        return isMaxHeap(1);
    }

    private boolean isMaxHeap(int k){
        if (k > n)
            return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && less(k, left)) return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }


}
