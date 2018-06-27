/**
 * Created by Hiki on 2017/10/16.
 */
public class No283_MoveZeroes {

	public void moveZeroes(int[] nums) {
		// 计算0的个数
		int n = nums.length;
		for (int i = 0; i < n; i++){
			if (i > 0 && nums[i] != 0){
				int pos = i;
				while (pos > 0 && nums[pos-1] == 0) pos--;
				swap(nums, i, pos);
			}
		}
	}

	private void swap(int[] array, int a, int b){
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
