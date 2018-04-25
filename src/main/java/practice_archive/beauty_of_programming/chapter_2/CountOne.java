package practice_archive.beauty_of_programming.chapter_2;

/**
 * @author hiki on 2018-04-25
 */

public class CountOne {

    /**
     * 计算从1到N之间出现的"1"的个数
     * 思路：从各个位出现1的个数规律入手，以百位为例
     * -->如果百位上的数字为0，则百位上可能出现的"1"的个数由更高位决定，个数为高位的数字*100，如12013 => 12*100
     * -->如果百位上的数字为1，则百位上可能出现的"1"的个数由更高位和更低位决定，个数为高位的数字*100+低位数字+1，如12113 => 12*100+13+1
     * -->如果百位上的数字>1，则百位上可能出现的"1"的个数仅由更高位决定，个数为高位的数字*100+100
     * @param number
     */
    static int countOne(int number) {
        int count = 0;
        int factor = 1;
        int lowerNum = 0;
        int curNum = 0;
        int higherNum = 0;

        // 遍历每一位
        while (number / factor != 0) {
            lowerNum = number - (number / factor) * factor;
            curNum = (number / factor) % 10;
            higherNum = number / (factor * 10);
            switch (curNum) {
                case 0:
                    count += higherNum * factor;
                    break;
                case 1:
                    count += higherNum * factor + lowerNum + 1;
                    break;
                default:
                    count += (higherNum + 1) * factor;
                    break;
            }
            factor *= 10;
        }

        return count;
    }





}
