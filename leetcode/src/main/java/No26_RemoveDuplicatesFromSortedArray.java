/**
 * Created by Hiki on 2017/9/13.
 */
public class No26_RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		for (int i = 1; i < n; i++){
			if (nums[i] == nums[i-1]){
				for (int j = i; j < n-1; j++)
					nums[j] = nums[j+1];
				i--;
			}

		}
		return nums.length;
	}

}
