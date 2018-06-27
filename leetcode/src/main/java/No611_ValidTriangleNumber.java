import java.util.Arrays;

/**
 * Created by Hiki on 2017/10/10.
 */
public class No611_ValidTriangleNumber {

	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		if (n < 3) return 0;

		int ans = 0;
		for (int i = 0; i < n-2; i++){
			for (int j = i+1; j < n-1; j++){
				for (int k = j+1; k < n; k++){
					if (nums[k] < nums[i] + nums[j])
						ans++;
					else
						break;
				}
			}

		}

		return ans;
	}
}
