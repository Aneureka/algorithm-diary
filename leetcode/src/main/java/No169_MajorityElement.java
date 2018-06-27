import java.util.Arrays;

/**
 * Created by Hiki on 9/28/2017.
 */
public class No169_MajorityElement {

	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

}
