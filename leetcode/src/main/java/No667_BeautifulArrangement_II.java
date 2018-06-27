import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 10/7/2017.
 */
public class No667_BeautifulArrangement_II {

	public int[] constructArray(int n, int k) {
		List<Integer> cnt = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			cnt.add(i);
		}

		int insertIndex = 0;
		for (int i = 1; i < k;){
			if (i == k-1){
				int tmp = cnt.get(insertIndex+1);
				cnt.remove(insertIndex+1);
				cnt.add(insertIndex, tmp);
				break;
			}
			int end = cnt.get(n-1);
			cnt.remove(n-1);
			cnt.add(insertIndex, end);
			i += insertIndex == 0 ? 1 : 2;
			insertIndex += 2;
		}

		int[] res = new int[n];
		for (int i = 0; i < n; i++){
			res[i] = cnt.get(i);
		}
		return res;
	}
}
