/**
 * 【题目描述】
 *     给定一整数序列 a1, a2, …, an，求 a1~an 的一个子序列 ai~aj，使得从 ai 到 aj 的和最大。
 *     只需要求出最大子序列的和，而不需要求出最大的那个序列。
 *
 * 【输入】
 *     一组整数，数字和数字之间以空格隔开。
 *
 * 【输出】
 *     该整数序列中最大子序列的和
 *
 * 【样例输入】
 *     -2 11 -4 13 -5 -2
 *
 * 【样例输出】
 *     20
 *
 * 【提示】
 *     应用穷举法可以得到 O(n^3) 的算法，优化它即可得到 O(n^2) 的算法。这两个算法将会超时。
 *     利用分治的思想可以有 O(n*logn) 的算法。
 *     也有聪明的算法，它的复杂度是 O(n) 的。
 *     另请注意：输入多少个数是未知的。请思考如何处理。
 *
 */



#include <iostream>
using namespace std;

int main() {

    int max, temp, cur;
    cin >> temp;
    max = temp;

    while (cin >> cur) {
        if (temp < 0) {
            temp = cur;
        }
        else {
            temp += cur;
        }
        if (temp > max) {
            max = temp;
        }
    }
    cout << max;
}