/**
 * 【题目描述】
 *     输入多组整数，每组2个整数，输出他们的和
 *
 * 【输入】
 *     多组整数，组内两个整数以空格隔开，组间以换行隔开
 *
 * 【输出】
 *     各组的和，以换行隔开
 *
 * 【样例输入】
 *     2 3
 *     4 5
 *
 * 【样例输出】
 *     5
 *     9
 *
 */


#include <iostream>
using namespace std;

int main() {

    int a, b;
    while (cin >> a >> b) {
        cout << a+b << endl;
    }
    return 0;
}