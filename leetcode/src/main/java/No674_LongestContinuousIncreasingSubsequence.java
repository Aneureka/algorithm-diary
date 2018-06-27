/**
 * Created by Hiki on 10/6/2017.
 */
public class No674_LongestContinuousIncreasingSubsequence {

	public int findLengthOfLCIS(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		int res = 1, tmp = 1;
		for (int i = 1; i < n; i++){
			if (nums[i] > nums[i-1]){
				tmp++;
				res = Math.max(res, tmp);
			}
			else{
				tmp = 1;
			}
		}
		return res;
	}

}
