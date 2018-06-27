/**
 * Created by Hiki on 2017/10/11.
 */
public class No560_SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		int n = nums.length;
		int ans = 0;
		for (int i = 0; i < n; i++){
			int cnt = 0;
			for (int j = i; j < n; j++){
				cnt += nums[j];
				if (cnt == k)
					ans++;
			}
		}
		return ans;

	}

}
