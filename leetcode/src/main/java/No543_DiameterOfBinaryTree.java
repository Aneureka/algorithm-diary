import data_helper.TreeNode;

/**
 * Created by Hiki on 2017/8/22.
 */
public class No543_DiameterOfBinaryTree {

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		else
			return getMaxNum(height(root.left) + height(root.right), diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
	}

	private int height(TreeNode x){
		if (x == null) return 0;
		return 1 + Math.max(height(x.left), height(x.right));
	}

	private int getMaxNum(int a, int b, int c) {
		return (a < b ? (b < c ? c : b) : (a < c ? c : a));
	}
}
