/**
 * Created by Hiki on 9/28/2017.
 */
public class No167_TwoSumII_InputArrayIsSorted {

	public int[] twoSum(int[] numbers, int target) {
		int low = 0, high = numbers.length-1;
		while (low < high){
			int nl = numbers[low], nh = numbers[high];
			if (nl + nh < target)
				low++;
			else if (nl + nh > target)
				high--;
			else
				return new int[]{low+1, high+1};
		}
		return null;
	}
}
