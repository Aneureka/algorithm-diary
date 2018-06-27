import data_helper.TreeNode;

/**
 * Created by Hiki on 2017/8/22.
 */
public class No112_PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		else
			return judge(root, sum);
	}

	private boolean judge(TreeNode root, int sum){
		if (root == null)
			return sum == 0;
		else{
			if (root.left != null && root.right == null)
				return judge(root.left, sum-root.val);
			else if (root.right != null && root.left == null)
				return judge(root.right, sum-root.val);
			else if (root.left != null && root.right != null)
				return judge(root.left, sum-root.val) || judge(root.right, sum-root.val);
			else
				return sum == root.val;
		}
	}
}
