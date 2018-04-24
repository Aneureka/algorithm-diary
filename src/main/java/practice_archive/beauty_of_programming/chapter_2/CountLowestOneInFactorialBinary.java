package practice_archive.beauty_of_programming.chapter_2;

/**
 * @author hiki on 2018-04-24
 */

public class CountLowestOneInFactorialBinary {

    /**
     * 求 N! 的二进制表示中最低位1的位置
     * 思路：将此问题转化为该数的质因子2的个数，因为寻找最低位1的过程其实就是不断除2直到N为奇数
     * @param number
     * @return
     */
    static int findIndex(int number) {
        int ans = 0;
        while (number != 0) {
            number >>= 1;
            ans += number;
        }
        return ans + 1;
    }

    /**
     * 引申：判断一个数是否为2的正整数次幂
     * 思路：如果一个数N为2的正整数次幂，那么N的二进制表示只可能有一个1，且N-1的二进制表示除了该位置为0，其他都为1
     * 故可以利用 N & (N-1) == 0 判断
     * @param number
     * @return
     */
    static boolean checkPowOfTwo(int number) {
        return number > 0 && (number & (number-1)) == 0;
    }
}
