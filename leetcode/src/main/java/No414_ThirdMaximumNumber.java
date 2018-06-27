/**
 * Created by Hiki on 2017/10/12.
 */
public class No414_ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
		int n = nums.length;
		Integer max = null, secondMax = null, thirdMax = null;
		for (Integer i : nums){
			if (i.equals(max) || i.equals(secondMax) || i.equals(thirdMax)) continue;
			if (max == null || i > max){
				thirdMax = secondMax;
				secondMax = max;
				max = i;
			}
			else if(secondMax == null || i > secondMax){
				thirdMax = secondMax;
				secondMax = i;
			}
			else if (thirdMax == null || i > thirdMax){
				thirdMax = i;
			}

		}

		return thirdMax == null ? max : thirdMax;

	}

}
