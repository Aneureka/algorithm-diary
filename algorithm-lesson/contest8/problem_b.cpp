/**
 * 【题目描述】
 *     一个图G=(V,E)的点覆盖是点集的子集S, 使得G上的每条边至少有一个端点在S内。给出一个无向树，求出它的最小点覆盖的大小。
 *
 * 【输入】
 *     每行第一个数是节点的id，从0开始，后面的每个数是节点的孩子的id。最后都有一个空格。
 *     输入已经经过BFS处理，参考输入样例，从头开始读就是一个BFS过程。
 *
 * 【输出】
 *     最小点覆盖的大小。
 *
 * 【样例输入】
 *     0 1 2
 *     1 3
 *     2
 *     3 4 5
 *     4
 *     5 6
 *     6
 *
 * 【样例输出】
 *     3
 *
 * 【提示】
 *     线性时间复杂度
 *
 */



#include <iostream>
#include <stdio.h>
#include <sstream>
#include <vector>
#include <math.h>

#define WHITE 0
#define BLACK 1

using namespace std;

int min_cover_recursive(const vector<vector<int> >& tree, int cur_node, int color) {

    if (tree[cur_node].empty()) {
        return color == BLACK ? 1 : 0;
    }

    int res_white = 0, res_black = 1;

    vector<int> children = tree[cur_node];

    for (int i = 0; i < children.size(); ++i) {
        int cur_child = children[i];
        res_black += min_cover_recursive(tree, cur_child, WHITE);
    }

    if (color == BLACK)
        return res_black;

    for (int i = 0; i < children.size(); ++i) {
        int cur_child = children[i];
        res_white += min_cover_recursive(tree, cur_child, BLACK);
    }

    return min(res_white, res_black);

}

int min_cover_dp(const vector<vector<int> >& tree) {
    int n = tree.size();
    int* black_count = new int[n];
    int* white_count = new int[n];

    for (int i = n-1; i >= 0; --i) {
        vector<int> children = tree[i];
        if (children.empty()) {
            black_count[i] = 1;
            white_count[i] = 0;
            continue;
        }

        int bc = 1, wc = 0;
        for (int j = 0; j < children.size(); ++j) {
            int child = children[j];
            bc += min(black_count[child], white_count[child]);
            wc += black_count[child];
        }
        black_count[i] = bc;
        white_count[i] = wc;
    }

    int res = min(black_count[0], white_count[0]);
    delete[] black_count;
    delete[] white_count;
    return res;
}


int main() {

    vector<vector<int> > tree;
    string line;
    while (getline(cin, line)) {
        stringstream ss;
        ss << line;
        vector<int> t;
        int tmp;
        ss >> tmp;
        while (ss >> tmp) {
            t.push_back(tmp);
        }
        tree.push_back(t);
    }

    cout << "I have read the rules about plagiarism punishment" << endl;
    cout << min_cover_dp(tree) << endl;

}

