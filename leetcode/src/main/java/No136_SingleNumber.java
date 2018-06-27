/**
 * Created by Hiki on 9/28/2017.
 */
public class No136_SingleNumber {

	public int singleNumber(int[] nums) {

		int res = nums[0];

		for (int i = 1; i < nums.length; i++){
			res ^= nums[i];
		}

		return res;
	}

}
