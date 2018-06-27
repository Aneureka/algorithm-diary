import data_helper.TreeNode;

/**
 * Created by Hiki on 2017/8/22.
 */
public class No617_MergeTwoBinaryTrees {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		if (t1 == null && t2 == null)
			return null;
		else if (t1 != null && t2 == null)
			return t1;
		else if (t1 == null && t2 != null)
			return t2;
		else {
			TreeNode x = new TreeNode(t1.val + t2.val);
			x.left = mergeTrees(t1.left, t2.left);
			x.right = mergeTrees(t1.right, t2.right);
			return x;
		}

	}

}
