/**
 * Created by Hiki on 2017/10/12.
 */
public class No485_MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, cur = 0;
		for (int i = 0; i < nums.length; i++){
			if (nums[i] == 1){
				cur++;
				max = Math.max(cur, max);
			}
			else{
				cur = 0;
			}
		}
		return max;
	}

}
