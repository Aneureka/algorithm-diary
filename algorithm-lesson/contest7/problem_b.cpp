/**
 * 【题目描述】
 *     经过一通计算，小雷同学最后还是乖乖听叔叔的话飞到了北京，开始了他快乐的旅程。在北京玩了一番之后，他决定租车去东三省进行自驾游，再回到北京飞去其他的城市。
 *
 *     小雷从爸爸手上得到了一份东三省的地图，上面标有若干城市，城市之间由高速公路连接。
 *     他按照老规矩把这份地图上的城市和公路用无向图进行了建模，每个城市为图中的一个顶点v，而每条公路e则是图中连接两个顶点的一条边，这样这份地图就变成了无向图G=(V,E)的样子。
 *     根据地图上的信息，每一条边e的长度le是已知的。
 *
 *     不幸的是，小雷发现在他的目的区域中，只有每座城市建有加油站，而高速公路上却没有，
 *     所以他在租车的时候，需要好好考虑租用车型的油箱容量。那么现在的问题是，油箱容量越大的车租金越贵，小雷希望能尽可能的省钱，
 *     但是若他想从某个城市s开车到另一个城市t，他需要确保路径上每段路e的长度le都小于等于油箱的容量L（在这里，为了方便比较，油箱容量L的单位用装满油箱能跑的公里数表示）。
 *
 *     同学们，你们能再帮小雷一次，替他算出要在地图上的城市之间进行自驾旅游，怎样才能用最少的钱租到最合适的车，而又不至于在两个城市间行驶时因为没油而无法继续旅行嘛？（即算出所需租用车的最小油箱容量L）。
 *
 * 【输入】
 *     第一行依次是城市个数n，以及s和t的编号。城市编号从0开始。
 *     下面每一行第一个数是高速公路长度，长度非负。后两个数是高速公路连接的城市编号。
 *
 *     s和t是存在通路的。
 *
 * 【输出】
 *     第二行输出最小需要的油箱能跑过的距离L。
 *
 * 【样例输入】
 *     6 1 5
 *     5 0 1
 *     1 1 2
 *     2 2 3
 *     2 0 4
 *     2 1 4
 *     2 2 5
 *     4 3 5
 *     1 4 5
 *
 * 【样例输出】
 *     2
 *
 * 【提示】
 *     使用 O((|V| + |E|）log|V|）的算法计算。
 *
 */



#include <iostream>
#include <stdio.h>
#include <vector>
#include <queue>

using namespace std;

typedef struct Edge {
    int v;
    int weight;
    Edge(int v1, int weight1) {
        v = v1;
        weight = weight1;
    }
} Edge;

typedef struct PQV {
    int from;
    int v;
    int max_weight;

    PQV(int from1, int v1, int max_weight1) {
        from = from1;
        v = v1;
        max_weight = max_weight1;
    }

    friend bool operator< (const PQV v1, const PQV v2) {
        return v1.max_weight > v2.max_weight;
    }

} pqv;


int dijstra(vector<Edge>* graph, int n, int s, int t) {
    // set all vertices as unseen

    int* froms = new int[n];
    for (int i = 0; i < n; ++i) {
        froms[i] = -1;
    }

    froms[s] = -2;

    priority_queue<pqv> pq;

    for (int i = 0; i < graph[s].size(); ++i) {
        int v = graph[s][i].v;
        int weight = graph[s][i].weight;
        pq.push(pqv(s, v, weight));
    }


    while (!pq.empty()) {
        pqv x = pq.top();
        pq.pop();
        int v = x.v;
        if (froms[v] != -1) {
            continue;
        }
        froms[v] = x.from;

        if (v == t) {
            delete[] froms;
            return x.max_weight;
        }

        // add neighbors of v
        vector<Edge> neighbor = graph[v];
        for (int i = 0; i < neighbor.size(); ++i) {
            int w = neighbor[i].v;
            int weight = neighbor[i].weight;
            if (froms[w] == -1) {
                int new_priority = max(x.max_weight, weight);
                pq.push(pqv(v, w, new_priority));
            }
        }
    }

    delete[] froms;
    return 0;

}

int main() {

    cout << "I have read the rules about plagiarism punishment" << endl;

    int n=0, s=0, t=0;
    cin >> n >> s >> t;

    vector<Edge>* graph = new vector<Edge>[n];
    int u, v, weight;
    while (scanf("%d %d %d", &weight, &u, &v) != EOF) {
        graph[u].push_back(Edge(v, weight));
        graph[v].push_back(Edge(u, weight));
    }

    priority_queue<pqv> pq;

    cout << dijstra(graph, n, s, t) << endl;

    delete[] graph;

}