/**
 * 【题目描述】
 *     回文：一个序列是回文的，是指这个序列从左往右读，从右往左读是一样的。
 *     子序列：一个序列a1, a2, …, an，它的子序列指的是从中任选几个元素，按照其原先序号从小到大排好。比如a5, a9, a11就是原序列的一个子序列（假设n>=11）。
 *
 *     求：一个序列的最长回文子序列的长度。
 *
 * 【输入】
 *     一个字符序列，字符之间以空格隔开
 *
 * 【输出】
 *     最长回文子序列的长度
 *
 * 【样例输入】
 *     A C G T G T C A A A A T C G
 *
 * 【样例输出】
 *     8
 *
 * 【提示】
 *     算法的时间复杂度不要超过O(n2)
 *     使用short而不是int以节省内存
 *     使用scanf而不是cin来节约时间和内存
 *     少做没有意义的操作，否则可能会时间超限
 *
 */



#include <iostream>
#include <math.h>
#include <stdio.h>
#include <vector>
using namespace std;

short get_palindrome_count(vector<char> seq) {

    short n = seq.size();
    short** count = new short*[n];
    for (short i = 0; i < n; ++i) {
        count[i] = new short[n];
    }
    for (short i = 0; i < n; ++i) {
        for (short j = 0; j < n; ++j) {
            count[i][j] = 0;
        }
    }
    for (short i = 0; i < n; ++i) {
        count[i][i] = 1;
    }

    for (short l = 1; l < n; ++l) {
        for (short i = 0; i < n-l; ++i) {
            short low = i;
            short high = i+l;
            // the first & last char may be counted in or not
            count[low][high] = max(count[low][high-1], count[low+1][high]);
            if (seq[low] == seq[high]) {
                count[low][high] = max(count[low][high], (short)(2+count[low+1][high-1]));
            }
        }
    }

    short c = count[0][n-1];
    delete[] count;

    return c;
}


int main() {

    vector<char> seq;

    char c;
    while (scanf("%c ", &c) != EOF) {
        seq.push_back(c);
    }

    cout << "I have read the rules about plagiarism punishment" << endl;
    cout << get_palindrome_count(seq) << endl;

}
