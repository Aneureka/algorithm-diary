import java.util.*;

/**
 * Created by Hiki on 2017/10/12.
 */
public class No448_FindAllNumbersDisappearedInAnArray {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		// 其实这个HashMap可以改成数组，更简洁一点
		Map<Integer, Integer> res = new HashMap<>();
		for (int i = 1; i <= n; i++)
			res.put(i, 0);
		for (int a : nums)
			res.remove(a);

		List<Integer> ans = new ArrayList<>();
		for (int a : res.keySet()){
			ans.add(a);
		}

		return ans;
	}

}
