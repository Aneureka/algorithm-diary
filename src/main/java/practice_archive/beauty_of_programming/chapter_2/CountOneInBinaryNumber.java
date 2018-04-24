package practice_archive.beauty_of_programming.chapter_2;

/**
 * @author hiki on 2018-04-24
 */

public class CountOneInBinaryNumber {

    /**
     * 求一个数的二进制表示中"1"的个数
     * @param number
     * @return
     */
    static int countOne(int number) {
        int ans = 0;
        while (number != 0) {
            number &= (number-1);
            ans++;
        }
        return ans;
    }

}
