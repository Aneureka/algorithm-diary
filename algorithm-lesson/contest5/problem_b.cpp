/**
 * 【题目描述】
 *     算法助教实在是太忙了，每天有n个事情要做，但他觉得自己一件一件的做实在是太蠢了，所以想找一些班上的同学来帮忙一块做这些事。
 *     在分配任务的过程中他发现，这n个任务中有一些任务的开始需要依赖另一些任务的完成，例如，当只有先批改完算法作业（记为事件A），才能给大家登记作业成绩（记为事件B），这时我们就可称事件B依赖于事件A。
 *     机智的他利用了算法课上的知识，采用有向图中的节点来表示这些事件，并且利用图中的边来表示这些事件的依赖关系。
 *     例如，当事件B依赖于事件A时，图中就存在一条由B指向A的边。助教还对这样的有向图进行了升级，用节点的权值表示完成每个事件所需要的时间。
 *     然而，随后他发现，由于图中依赖关系的存在，即使他利用庞大的关系网能找来无穷多个同学帮他做这些事，完成所有事件的最短时间也是确定的。
 *     那么问题来了，助教每天要花多少时间来处理这n个事情呢？这时，助教想起了算法课上学到的关键路径的定义似乎能够帮他解决这个问题。
 *     聪明的同学们，你们能告诉助教他即使找到帮手，每天做完这n个事情最短也需要花多长时间吗？
 *
 *    （善良的助教已经帮你们把这些事情建模成有向图，如输入所示。）
 *
 * 【输入】
 *     第一行为图中的顶点个数n
 *
 *     第二行至第n+1行为每个顶点代表的事件编号（事件编号为1至n）及完成该事件所需的时间。 如，“1 50”代表完成事件1需要50个单位时间。
 *     余下的行中，每一行表示一个依赖关系，例如，“1 3” 表示事件1的完成依赖于事件3的完成。
 *
 * 【输出】
 *     完成所有这n个任务所需最短的执行时间。
 *
 * 【样例输入】
 *     9
 *     1 10
 *     2 6
 *     3 5
 *     4 1
 *     5 2
 *     6 3
 *     7 4
 *     8 9
 *     9 1
 *     1 9
 *     2 1
 *     2 8
 *     3 5
 *     3 6
 *     3 7
 *     4 2
 *     4 3
 *     5 9
 *     6 9
 *     7 9
 *     8 9
 *
 * 【样例输出】
 *     18
 *
 * 【提示】
 *     如果这些事情出现了循环依赖，则助教永远也不可能做完这些事（好惨 TAT）。
 *     所以你可以大胆假定，助教要做的这些事情中并不存在循环依赖，也就是说，输入的图一定是一个有向无环图。
 *
 */


#include <iostream>
#include <vector>
using namespace std;

void dfs(int* time, int* color, int* eft, vector<int>* neighbor, int index);

int main() {

    int n = 0;
    cin >> n;
    int* time = new int[n+1];
    int* color = new int[n+1];
    int* eft = new int[n+1];
    vector<int> *neighbor = new vector<int>[n+1];

    // initialization
    int t_number, t_time;
    for (int i = 1; i < n+1; ++i) {
        cin >> t_number >> t_time;
        time[t_number] = t_time;
    }

    int w = 0, v = 0;
    while (cin >> w >> v) {
        neighbor[w].push_back(v);
    }

    for (int i = 1; i < n+1; ++i) {
        color[i] = 0;
        eft[i] = 0;
    }

    for (int i = 1; i < n+1; ++i) {
        if (color[i] == 0) {
           dfs(time, color, eft, neighbor, i);
        }
    }

    int max_time = 0;
    for (int i = 1; i < n+1; ++i) {
        if (eft[i] > max_time)
            max_time = eft[i];
    }

    delete[] time;
    delete[] color;
    delete[] eft;
    delete[] neighbor;

    cout << "I have read the rules about plagiarism punishment" << endl;
    cout << max_time << endl;
}

void dfs(int* time, int* color, int* eft, vector<int>* neighbor, int index) {
    color[index] = 1;
    int est = 0;
    vector<int> t_neighbor = neighbor[index];
    for (int i = 0; i < t_neighbor.size(); ++i) {
        int n_index = t_neighbor[i];
        if (color[n_index] == 0) {
            dfs(time, color, eft, neighbor, n_index);
            if (eft[n_index] >= est) {
                est = eft[n_index];
            }
        }
        else {
            if (eft[n_index] >= est) {
                est = eft[n_index];
            }
        }
    }
    eft[index] = est + time[index];
}

