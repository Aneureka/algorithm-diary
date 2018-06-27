import data_helper.TreeNode;

import java.util.*;

/**
 * Created by Hiki on 9/21/2017.
 */
public class No107_BinaryTreeLevelOrderTraversal_II {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		// create the container to save the result
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new ArrayDeque<>();
		if (root != null) queue.add(root);

		while (!queue.isEmpty()){

			List<TreeNode> sons = new ArrayList<>();
			List<Integer> item = new ArrayList<>();

			while (!queue.isEmpty()){
				TreeNode tmp = queue.remove();
				item.add(tmp.val);
				if (tmp.left != null) sons.add(tmp.left);
				if (tmp.right != null) sons.add(tmp.right);
			}

			queue.addAll(sons);
			res.add(0, item);
		}

		return res;
	}
}
