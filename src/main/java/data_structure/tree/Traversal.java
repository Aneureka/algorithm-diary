package data_structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hiki on 2018-04-17
 */

public class Traversal {

    static <T> void levelTraversal(TreeNode<T> root) {
        if (root == null)
            return;

        Queue<TreeNode<?>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode<T> node = (TreeNode<T>) nodes.remove();
            visit(node);
            if (node.left != null)
                nodes.add(node.left);
            if (node.right != null)
                nodes.add(node.right);
        }
    }

    static <T> void preOrderTraversal(TreeNode<T> root) {
        if (root == null)
            return;
        visit(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static <T> void inOrderTraversal(TreeNode<T> root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        visit(root);
        inOrderTraversal(root.right);
    }
    static <T> void postOrderTraversal(TreeNode<T> root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        visit(root);
    }

    static <T> void zhiTraversal(TreeNode<T> root) {
        if (root == null)
            return;

        boolean leftToRight = true;
        Stack<TreeNode<T>> curLevel = new Stack<>();
        Stack<TreeNode<T>> nextLevel = new Stack<>();
        curLevel.push(root);
        while (!curLevel.isEmpty()) {
            TreeNode<T> node = curLevel.pop();
            visit(node);
            if (leftToRight) {
                if (node.right != null)
                    nextLevel.push(node.right);
                if (node.left != null)
                    nextLevel.push(node.left);
            }
            else {
                if (node.left != null)
                    nextLevel.push(node.left);
                if (node.right != null)
                    nextLevel.push(node.right);
            }
            if (curLevel.isEmpty()) {
                curLevel.addAll(nextLevel);
                nextLevel.clear();
                leftToRight = !leftToRight;
            }
        }

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.right.left = new TreeNode<>(5);
        root.left.right = new TreeNode<>(6);
        zhiTraversal(root);
    }

    static <T> void visit(TreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.value + " ");
    }

}
