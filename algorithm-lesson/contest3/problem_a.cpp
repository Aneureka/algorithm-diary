/**
 * 【题目描述】
 *     输入一组整数a1, a2, …, an ，每输入一个整数，输出到此时为止的中位数。
 *
 *     中位数定义：如果数串的大小是偶数 2j，中位数是从小到大排列的第 j 个数；如果数串的大小是奇数 2j+1，中位数是从小到大排列的第 j+1 个数。
 *
 * 【输入】
 *     一组整数，数字和数字之间以空格隔开。
 *
 * 【输出】
 *     一组整数，数字和数字之间以空格隔开。最后一个数后面也有空格。
 *     第 i 个输出的整数，是前 i 个输入的中位数。
 *
 * 【样例输入】
 *     -18 -2 14 -20 -6 7 2 14 11 6
 *
 * 【样例输出】
 *     -18 -18 -2 -18 -6 -6 -2 -2 2 2
 *
 * 【提示】
 *     时间复杂度请不要超过O(nlogn)。
 *     由于输入输出的量会比较大，因此推荐使用c语言中的scanf和printf函数来进行输入输出，能比c++中cin和cout节省许多时间。
 *
 *     在处理该问题时，【堆结构】也许能给你带来意想不到的帮助。
 *
 */

#include <iostream>
#include <stdio.h>
#include <queue>
#include <algorithm>
#include <functional>
using namespace std;

int main() {

    priority_queue<int, vector<int>, less<int>> max_heap;
    priority_queue<int, vector<int>, greater<int>> min_heap;
    int median = 0;
    scanf("%d", &median);
    printf("%d ", median);
    int count = 1;

    int temp = 0;
    while (scanf("%d", &temp) != -1) {
        if (temp >= median) {
            min_heap.push(temp);
            if (count % 2 == 0) {
                int temp_median = min_heap.top();
                min_heap.pop();
                max_heap.push(median);
                median = temp_median;
            }
            printf("%d ", median);
            count++;
        }
        else {
            max_heap.push(temp);
            if (count % 2 == 1) {
                int temp_median = max_heap.top();
                max_heap.pop();
                min_heap.push(median);
                median = temp_median;
            }
            printf("%d ", median);
            count++;
        }
    }

}

