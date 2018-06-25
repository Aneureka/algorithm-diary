/**
 * 【题目描述】
 *     变位词是指由相同的字母组成的单词，如eat、tea是变位词。本次问题给出一串单词，你需要找到所有的变位词。
 *
 * 【输入】
 *     输入由两行组成：第一行是所有单词的总数，第二行是由空格分隔的单词列表。两行末尾都有空格。
 *
 *     注：为防歧义，输入的单词都是小写
 *
 * 【输出】
 *     第一行是变位词组的个数，后面是所有的变位词。每个输出的变位词占一行。一组变位词只需要输出一个字典序最小的代表即可，如eat、tea中eat字典序小于tea，所以输出eat。变位词与变位词也按照字典序从小到大排列，如eat和el中eat字典序小于el所以eat在el前面。
 *
 *     输出的每一行最后都没有空格。
 *
 * 【样例输入】
 *     9
 *     a ew vc tea oe eat zoo el le
 *
 * 【样例输出】
 *     2
 *     eat
 *     el
 *
 * 【提示】
 *     使用代价为O(nlgn)的方法。
 *
 */

#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

struct WordNCount {
    string word;
    int count;
    WordNCount(string w, int c) {
        word = w;
        count = c;
    }
    WordNCount() {}
};


int main() {

    int n = 0;
    cin >> n;
    auto words = new string[n];
    for (int i = 0; i < n; ++i) {
        cin >> words[i];
    }

    unordered_map<string, WordNCount> word_map;
    for (int i = 0; i < n; ++i) {
        string str = words[i];
        string temp_str = string(str);
        sort(temp_str.begin(), temp_str.end());
        unordered_map<string, WordNCount>::iterator itr;
        itr = word_map.find(temp_str);
        if (itr == word_map.end()) {
            word_map.insert(pair<string, WordNCount>(temp_str, WordNCount(str, 1)));
        }
        else {
            WordNCount wc = word_map.at(temp_str);
            wc.count += 1;
            string origin_word = wc.word;
            if (str.compare(origin_word) < 0) {
                wc.word = str;
            }
            word_map[temp_str] = wc;
        }

    }

    vector<string> ans;
    unordered_map<string, WordNCount>::iterator itr;
    for (itr = word_map.begin(); itr != word_map.end(); itr++) {
        WordNCount wc = itr->second;
        string word = wc.word;
        int count = wc.count;
        if (count > 1) {
            ans.push_back(word);
        }
    }

    cout << "wo yi yue du guan yu chao xi de shuo ming" << endl;
    sort(ans.begin(), ans.end());
    cout << ans.size() << endl;
    vector<string>::iterat or ans_itr;
    for (ans_itr = ans.begin(); ans_itr != ans.end(); ans_itr++) {
        cout << *ans_itr << endl;
    }
}