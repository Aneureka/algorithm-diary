import java.util.Arrays;

/**
 * Created by Hiki on 2017/10/11.
 */
public class No532_KdiffPairsInAnArray {

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		int res = 0;

		// 如果k<0，不符合题意，返回0
		if (k < 0) return 0;

		// 如果k=0，则直接返回数组中相同的数字对数
		if (k == 0){
			for (int i = 0; i < n-1; i++){
				if (nums[i] == nums[i+1]) {
					while (i < n-1 && nums[i] == nums[i+1]) i++;
					res++;
				}
			}
			return res;
		}

		// 如果k>0（一般情况），先将数组中的数字和其+k的结果放到数组中（排除原数组中相同的数字），排序，找出相同数字的对数即可
		int index = 0;
		int[] tmp = new int[2*n];
		Arrays.fill(tmp, Integer.MAX_VALUE);
		for (int i = 0; i < n; i++){
			if (i == n-1) {
				tmp[index++] = nums[i];
				tmp[index++] = nums[i] + k;
			}
			else{
				if (nums[i] != nums[i+1]){
					tmp[index++] = nums[i];
					tmp[index++] = nums[i] + k;
				}
			}

		}

		Arrays.sort(tmp);
		for (int i = 0; i < index-1; i++){
			if (tmp[i] == tmp[i+1]) {
				res++;
				i++;
			}
		}
		return res;
	}

}
