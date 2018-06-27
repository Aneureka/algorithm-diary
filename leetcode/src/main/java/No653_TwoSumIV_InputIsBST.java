import data_helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2017/8/22.
 */
public class No653_TwoSumIV_InputIsBST {

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> collector = new ArrayList<>();
		save(collector, root);
		return isTwoSum(collector, k);
	}

	// 将BST的值存到List中
	public void save(List<Integer> collector, TreeNode x){
		if (x == null)
			return;
		save(collector, x.left);
		collector.add(x.val);
		save(collector, x.right);
	}

	public boolean isTwoSum(List<Integer> collector, int k){
		int low = 0, high = collector.size()-1;
		while (low < high){
			int t = collector.get(low) + (int)collector.get(high);
			if (t < k) low++;
			else if (t > k) high--;
			else return true;
		}
		return false;
	}

}
