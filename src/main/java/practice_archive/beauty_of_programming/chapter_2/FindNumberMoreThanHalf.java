package practice_archive.beauty_of_programming.chapter_2;

import java.util.Arrays;
import java.util.List;

/**
 * @author hiki on 2018-04-24
 */

public class FindNumberMoreThanHalf {

    /**
     * 寻找数组中个数超过一半的数
     * 思路：pk法
     * @param numbers
     * @return
     */
    static int findNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }
        int ans = 0;
        int count = 1;
        for (int i = 0, n = numbers.length; i < n; i++) {
            if (count == 0) {
                ans = numbers[i];
                count = 1;
            }
            else {
                if (numbers[i] == ans) {
                    count++;
                }
                else {
                    count--;
                }
            }
        }
        return ans;
    }

    /**
     * 如果在数组中，有三个数的个数各占超过数组1/4的容量，求这三个数
     * 思路：同样用pk法，用三个num和三个count保存当前的值
     * @param numbers
     * @return
     */
    static int[] findNumberAdvanced(int[] numbers) {
        int[] candidates = new int[3];
        int[] times = new int[3];
        Arrays.fill(candidates, -1);
        Arrays.fill(times, 0);

        for (int i = 0, n = numbers.length; i < n; i++) {
            // 判断有没有在候选元素中
            boolean inCandidate = false;
            for (int j = 0; j < candidates.length; j++) {
                if (candidates[j] == numbers[i]) {
                    times[j]++;
                    inCandidate = true;
                    break;
                }
            }

            if (!inCandidate) {
                // 判断有没有候选元素个数为0
                boolean hasZero = false;
                for (int j = 0; j < times.length; j++) {
                    if (times[j] == 0) {
                        candidates[j] = numbers[i];
                        times[j] = 1;
                        hasZero = true;
                    }
                }

                if (!hasZero) {
                    // 将所有候选元素个数-1
                    for (int j = 0; j < times.length; j++) {
                        times[j]--;
                    }
                }
            }
        }

        return candidates;
    }


}
