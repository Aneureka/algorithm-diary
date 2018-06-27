/**
 * Created by Hiki on 9/26/2017.
 */
public class No453_MinimumMovesToEqualArrayElements {

	public int minMoves(int[] nums) {
		int n = nums.length;
		int res = 0;

		while(true){
			boolean same = true;
			for (int i = 0; i < n; i++){
				if (nums[i] != nums[0]){
					same = false;
					break;
				}
			}
			if (same) return res;

			int max = nums[0], max_pos = 0, min = nums[0], min_pos = 0;
			for (int i = 0; i < n; i++){
				if (nums[i] > max){
					max = nums[i];
					max_pos = i;
				}
				if (nums[i] < min){
					min = nums[i];
					min_pos = i;
				}

			}

			int dis = max - min;

			for (int i = 0; i < n; i++){
				if (i != max_pos)
					nums[i] += dis;
			}

			res += dis;
		}


	}

	/**
	 * Created by Hiki on 9/28/2017.
	 */
	public static class No169_MajorityElement {
	}
}
