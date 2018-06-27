import data_helper.TreeNode;

/**
 * Created by Hiki on 2017/8/22.
 */
public class No606_ConstructStringFromBinaryTree {

	public String tree2str(TreeNode t) {
		if (t == null) return "";
		String res = String.valueOf(t.val);
		if (t.left != null) {
			res += "(" + tree2str(t.left) + ")";
			if (t.right != null)
				res += "(" + tree2str(t.right) + ")";
		}
		else{
			if (t.right != null)
				res += "()(" + tree2str(t.right) + ")";
		}
		return res;
	}
}
