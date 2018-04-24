package practice_archive.beauty_of_programming.chapter_2;

/**
 * @author hiki on 2018-04-24
 */

public class CountZeroInFactorial {

    /**
     * 计算一个数的阶乘中"0"的个数
     * 思路：计算每一个数里面"5"的因子个数
     * @param num
     * @return
     */
    static int countZero(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            int cur = i;
            while (cur % 5 == 0) {
                ans++;
                cur /= 5;
            }
        }
        return ans;
    }

    /**
     * 思路更好的版本，先看这个数num能提供多少个5，然后在看num/5能提供多少个5，依次类推
     * Z = [N/5] + [N/5^2] + [N/5^3] + ...
     * 其中，[N/5]表示不大于N的数中5的倍数贡献一个5，依次类推
     * @param num
     * @return
     */
    static int countZeroAdvanced(int num) {
        int ans = 0;
        while (num > 0) {
            num /= 5;
            ans += num;
        }
        return num;
    }

}
