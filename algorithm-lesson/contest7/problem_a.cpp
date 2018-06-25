/**
 * 【题目描述】
 *     给定一个带权有向图无环图G，求某一点到其他所有点的最长路径。
 *
 * 【输入】
 *     第一行为一个数字n，表示总点数。之后点的标号为从0到n-1。
 *     之后的每一行，格式为3个数字，以空格隔开，分别为相连的两个点的编号，它们的边的权值。
 *
 *     注：输入为有向图。如果出现了“0 1 50”表示点0到点1之间有一条边，权值为50。
 *
 * 【输出】
 *     点0到其他所有点的最长路径，以空格隔开。注：点0到其他所有点都是可达的。
 *
 * 【样例输入】
 *     6
 *     0 1 1
 *     0 3 2
 *     1 2 6
 *     2 4 1
 *     2 5 2
 *     3 4 3
 *     3 1 4
 *     4 5 1
 *
 * 【样例输出】
 *     6 12 2 13 14
 *
 * 【提示】
 *     线性时间复杂度O(m+n)
 *     节省时间、空间可以尝试将cin输入换成scanf输入，如果你使用了cin的话。
 *
 */


#include <iostream>
#include <stdio.h>
#include <vector>

#define WHITE 0
#define GREY 1
#define BLACK 2

using namespace std;

typedef struct Edge {
    int v;
    int weight;
    Edge(int v1, int weight1) {
        v = v1;
        weight = weight1;
    }
} Edge;

void _dfs(vector<Edge>* graph, vector<int>& typo_list, int* color, int u) {
    color[u] = GREY;
    vector<Edge> neighbor = graph[u];
    for (int i = 0; i < neighbor.size(); ++i) {
        int v = neighbor[i].v;
        if (color[v] == WHITE) {
            _dfs(graph, typo_list, color, v);
        }
    }
    typo_list.push_back(u);
    color[u] = BLACK;
}

void dfs(vector<Edge>* graph, vector<int>& typo_list, int n) {
    int* color = new int[n];
    for (int i = 0; i < n; ++i) {
        color[i] = WHITE;
    }

    _dfs(graph, typo_list, color, 0);

    delete[] color;
}

int main() {

    int n = 0;
    cin >> n;

    vector<Edge>* graph = new vector<Edge>[n];
    int u, v, weight;
    while (scanf("%d %d %d", &u, &v, &weight) != EOF) {
        graph[u].push_back(Edge(v, weight));
    }

    // get typo-order list
    vector<int> typo_list;
    dfs(graph, typo_list, n);

    // dp
    int* maxs = new int[n];
    for (int i = 0; i < n; ++i) {
        maxs[i] = INT32_MIN;
    }
    maxs[0] = 0;



    for (int i = typo_list.size()-1; i >= 0; --i) {
        int v = typo_list[i];
        for (int j = 0; j < graph[v].size(); ++j) {
            int weight = graph[v][j].weight;
            int to = graph[v][j].v;
            if (maxs[to] < maxs[v] + weight) {
                maxs[to] = maxs[v] + weight;
            }
        }
    }

    cout << "I have read the rules about plagiarism punishment" << endl;
    for (int i = 1; i < n; ++i) {
        cout << maxs[i] << " ";
    }
    cout << endl;

    delete[] graph;
    delete[] maxs;
}
