import java.util.Arrays;

/**
 * Created by Hiki on 10/7/2017.
 */
public class No665_NonDecreasingArray {

	public boolean checkPossibility(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return true;

		boolean[] used = new boolean[n];
		Arrays.fill(used, false);
		int diff = 0;
		for (int i = 0; i < n-1; i++){
			for (int j = i+1; j < n; j++){
				if (nums[i] > nums[j]){
					used[j] = true;
					diff++;
					if (diff > 1)
						return false;
					break;
				}
			}
		}
		return true;
	}
}
