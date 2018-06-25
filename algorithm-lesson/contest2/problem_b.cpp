/**
 * 【题目描述】
 *     给出一个字符串数组，如果（按照字典序）一个大的字符串在比它小的字符串前面我们称这两个字符串组成一个“逆序对”。你需要找到所有的逆序对的个数。
 *
 * 【输入】
 *     第一行是数组大小，第二行是以空格分隔的字符串数组。
 *
 * 【输出】
 *     逆序对个数
 *
 * 【样例输入】
 *     3
 *     aaaaaaaaaa cccccccccc bbbbbbbbbb
 *
 * 【样例输出】
 *     1
 *
 * 【提示】
 *     注意：结果比较大，请用 long 类型保存。
 *     不要使用蛮力算法。
 *
 */


#include <iostream>
#include <string>
using namespace std;

int compare(const string& a, const string& b);

long sort(string* items, int begin, int end);

long merge_and_count(string* items, int begin, int end, int mid);

int main() {
    int n;
    cin >> n;
    string *items = new string[n];
    for (int i = 0; i < n; ++i) {
        cin >> items[i];
    }
    cout << "wo yi yue du guan yu chao xi de shuo ming" << endl;

    cout << sort(items, 0, n-1);

    delete[] items;

}

int compare(const string& a, const string& b) {

    unsigned long la = a.length();
    unsigned long lb = b.length();

    for (unsigned long i = 0; i < min(la, lb); ++i) {
        if (a.at(i) < b.at(i))
            return -1;
        if (a.at(i) > b.at(i))
            return 1;
    }

    if (la < lb) return -1;
    else if (la > lb) return 1;
    else return 0;

}

long sort(string* items, int begin, int end) {
    if (begin >= end)
        return 0;
    int mid = begin + (end-begin) / 2;
    return sort(items, begin, mid)
           + sort(items, mid+1, end)
           + merge_and_count(items, begin, end, mid);
}

long merge_and_count(string* items, int begin, int end, int mid) {

    int length = end - begin + 1;
    string *aux = new string[length];

    int i = begin, j = mid+1;
    long res = 0;

    for (int index = 0; index < length; ++index) {
        if (i > mid) {
            aux[index] = items[j++];
        }
        else if (j > end) {
            aux[index] = items[i++];
        }
        else if (compare(items[i], items[j]) <= 0) {
            aux[index] = items[i++];
        }
        else {
            aux[index] = items[j++];
            res += mid-i+1;
        }
    }

    for (int k = 0; k < length; ++k) {
        items[begin+k] = aux[k];
    }

    delete[] aux;

    return res;

}
