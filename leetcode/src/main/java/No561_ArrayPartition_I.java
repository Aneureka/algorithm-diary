import java.util.Arrays;

/**
 * Created by Hiki on 10/7/2017.
 */
public class No561_ArrayPartition_I {

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length; i+=2){
			res += nums[i];
		}
		return res;
	}
}
