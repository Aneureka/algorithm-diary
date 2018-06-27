import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2017/10/12.
 */
public class No442_FindAllDuplicatesInAnArray {

	public List<Integer> findDuplicates(int[] nums) {
		int n = nums.length;
		int[] cnt = new int[n+1];
		for (int i : nums)
			cnt[i]++;

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i <= n; i++){
			if (cnt[i] == 2)
				res.add(i);
		}
		return res;
	}

}
