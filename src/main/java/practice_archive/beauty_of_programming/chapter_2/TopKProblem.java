package practice_archive.beauty_of_programming.chapter_2;

import java.util.List;

/**
 * @author hiki on 2018-04-25
 */

public class TopKProblem {

    /**
     * 找出数组中第K大的数，要求复杂度N*logK
     * 思路一：快排分区
     * 思路二：先求最大最小值，再二分答案d
     * 思路三：维护容量为K的最小堆，适用于数据量极大，不能一次装入内存的情况，也是此处的实现
     * 思路四：如果数据范围较小，可以采用类似计数排序的方法
     * @param nums
     * @return
     */
    static int topK(List<Integer> nums, int k) {
        MinHeap heap = new MinHeap(k);
        for (int num : nums) {
            if (heap.isFull()) {
                if (heap.peek() < num) {
                    heap.add(num);
                }
            }
            else {
                heap.add(num);
            }
        }
        return heap.peek();
    }

    static class MinHeap {
        int[] container;
        int size;
        int curSize;

        MinHeap(int k) {
            curSize = 0;
            this.size = k;
            this.container = new int[k+1];
        }

        void add(int e) {
            if (curSize < size) {
                container[++curSize] = e;
                up(curSize);
            }
            else {
                container[1] = e;
                down(1);
            }
        }

        int peek() {
            return container[1];
        }

        boolean isFull() {
            return curSize == size;
        }

        private void up(int index) {
            // todo
        }

        private void down(int index) {
            // todo
        }

    }
}
