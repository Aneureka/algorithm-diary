import java.util.Arrays;

/**
 * Created by Hiki on 10/7/2017.
 */
public class No628_MaximumProductOfThreeNumbers {
	public int maximumProduct(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);
	}
}
