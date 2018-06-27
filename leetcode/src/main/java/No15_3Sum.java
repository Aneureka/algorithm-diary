import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Hiki on 2017/8/30.
 */
public class No15_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		// 先对数组进行排序
		Arrays.sort(nums);
		int n = nums.length;

		// 排除不可能情况
		if (nums.length < 3) return new ArrayList<>();
		if (nums[0] > 0 || nums[n-1] < 0) return new ArrayList<>();

		// 找出分界线
		int m = 0;
		for (int i = 0; i < n; i++){
			if (nums[i] >= 0){
				m = i;
				break;
			}
		}

		// 遍历
		int ni = 0, nj = 0, nk = 0;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < m-1; i++){
			for (int j = i+1; j < m; j++){
				for (int k = n-1; k >= m; k--){
					ni = nums[i]; nj = nums[j]; nk = nums[k];
					if (ni + nj + nk == 0){
						List<Integer> now = Arrays.asList(ni, nj, nk);
						if (res.isEmpty() || !same(now, res.get(res.size()-1)))
							res.add(now);
					}
					else if (ni + nj + nk < 0)
						break;
				}
			}
		}

		for (int k = 0; k < m; k++){
			if (nums[k] + nums[n-1] + nums[n-2] < 0 || n - m < 2 || nums[k] + nums[m] + nums[m+1] > 0) continue;
			for (int i = m; i < n-1; i++){
				for (int j = i+1; j < n; j++){
					ni = nums[i]; nj = nums[j]; nk = nums[k];
					if (ni + nj + nk == 0){
						List<Integer> now = Arrays.asList(nk, ni, nj);
						if (res.isEmpty() || !(same(now, res.get(res.size()-1)) || (k-1 >= 0 && nums[k] == nums[k-1])))
							res.add(now);
					}
					else if (ni + nj + nk > 0)
						break;
				}

			}

		}


		if (nums[m] == 0 && n - m >= 3 && nums[m+2] == 0)
			res.add(Arrays.asList(0, 0, 0));

		res.sort(Comparator.comparingInt(o -> o.get(0)));

		return res;
	}


	private boolean same(List<Integer> a, List<Integer> b){
		if (a.size() != b.size())
			return false;
		for (int i = 0; i < a.size(); i++){
			if (a.get(i) != b.get(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		No15_3Sum a = new No15_3Sum();
		System.out.println(a.threeSum(new int[]{-1,0,1}));;
	}
}
