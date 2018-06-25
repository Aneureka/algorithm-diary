/**
 * 【题目描述】
 *     记T为一棵二叉树，树中共有n个节点。
 *     定义根节点的深度为0，其余节点的深度为其父节点的深度加1。T的高度定义为其叶节点深度的最大值。
 *     定义树中任意两点a和b之间的距离为其间最短简单路径的长度。T的直径定义为T中所有点对间距离的最大值。
 *
 *     输入一棵二叉树T，请计算它的高度和直径。
 *
 *
 * 【输入】
 *     输入共3行。
 *
 *     第一行输入n的值，表示树中结点的总个数。
 *     第二行为树的前序遍历表示，每个节点之间用空格隔开。
 *     第三行为树的中序遍历表示，每个节点之间也用空格隔开。
 *
 * 【输出】
 *     输出共2行。
 *
 *     第1行输出树的高度。
 *     第2行输出树的直径。
 *
 * 【样例输入】
 *     10
 *     0 1 9 3 8 4 2 7 5 6
 *     3 9 8 1 2 4 0 5 7 6
 *
 * 【样例输出】
 *     3
 *     5
 *
 * 【提示】
 *     分治算法可以在O(n)的时间内完成相应的计算。
 *
 */


#include <iostream>
#include <algorithm>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int v) {
        val = v;
    }
};

void print(TreeNode* root);
int high_of(TreeNode* root);
int diameter_of(TreeNode* root);

TreeNode* build_tree(int pre_order[], int in_order[], int low1, int high1, int low2, int high2);
int index_of(const int nums[], int low, int high, int val);


int main() {

    int n = 0;
    cin >> n;
    auto pre_order = new int[n];
    auto in_order = new int[n];
    for (int i = 0; i < n; ++i) {
        cin >> pre_order[i];
    }
    for (int i = 0; i < n; ++i) {
        cin >> in_order[i];
    }

    TreeNode* root = build_tree(pre_order, in_order, 0, n-1, 0, n-1);
    cout << "I have read the rules about plagiarism punishment" << endl;
    cout << high_of(root) << endl;
    cout << diameter_of(root) << endl;

}

TreeNode* build_tree(int pre_order[], int in_order[], int low1, int high1, int low2, int high2) {
    int root_val = pre_order[low1];
    TreeNode* root = new TreeNode(root_val);
    if (low1 >= high1)
        return root;
    int index_in_order = index_of(in_order, low2, high2, root_val);
    int index_pre_order = low1+index_in_order-low2+1;
    if (index_in_order > low2)
        root->left = build_tree(pre_order, in_order, low1+1, index_pre_order-1, low2, index_in_order-1);
    if (index_in_order < high2)
        root->right = build_tree(pre_order, in_order, index_pre_order, high1, index_in_order+1, high2);
    return root;
}

int high_of(TreeNode* root) {
    if (root == NULL)
        return 0;
    if (root->left == NULL && root->right == NULL) {
        return 0;
    }
    return 1 + max(high_of(root->left), high_of(root->right));
}

int diameter_of(TreeNode* root) {
    if (root == NULL) {
        return 0;
    }
    if (root->left == NULL && root->right == NULL) {
        return 0;
    }
    int high_of_left = high_of(root->left);
    int high_of_right = high_of(root->right);
    int diameter = 0;
    if (root->left != NULL) {
        diameter += 1 + high_of_left;
    }
    if (root->right != NULL) {
        diameter += 1 + high_of_right;
    }
    return max(max(diameter, diameter_of(root->left)), max(diameter, diameter_of(root->right)));

}

void print(TreeNode* root) {
    if (root == NULL) {
        return;
    }
    cout << root->val << " ";
    print(root->left);
    print(root->right);
}

int index_of(const int nums[], int low, int high, int val) {
    for (int i = low; i <= high; ++i) {
        if (val == nums[i])
            return i;
    }
    return -1;
}