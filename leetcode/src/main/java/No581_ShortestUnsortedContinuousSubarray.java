/**
 * Created by Hiki on 2017/10/11.
 */
public class No581_ShortestUnsortedContinuousSubarray {

	public int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		if (n == 1) return 0;

		// get the head and tail
		int head = 0, tail = n-1;
		for (int i = 0; i < tail; i++){
			// get minimum of the rest
			int min = nums[i+1];
			for (int j = i+1; j <= tail; j++)
				min = Math.min(min, nums[j]);

			if (nums[i] > min)
				break;
			else
				head++;
		}

		if (head == tail) return 0;

		for (int i = n-1; i > head; i--){
			// get maximum of the rest
			int max = nums[i-1];
			for (int j = i-1; j >= head; j--)
				max = Math.max(max, nums[j]);

			if (nums[i] < max)
				break;
			else{
				tail--;
			}

		}
		return tail-head+1;

	}

	public static void main(String[] args) {
		No581_ShortestUnsortedContinuousSubarray s = new No581_ShortestUnsortedContinuousSubarray();
		int[] a = {1,2,3,4};
		System.out.println(s.findUnsortedSubarray(a));
	}
}
