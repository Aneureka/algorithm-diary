/**
 * Created by Hiki on 2017/10/18.
 */
public class No238_ProductOfArrayExceptSelf	 {

	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		// 保存前缀积（不包含本身）
		res[0] = 1;
		for (int i = 1; i < n; i++){
			res[i] = res[i-1]*nums[i-1];
		}
		// 从右到左扫描
		int right = 1;
		for (int j = n-2; j >= 0; j--){
			right *= nums[j+1];
			res[j] *= right;
		}
		return res;
	}

}
