import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hiki on 10/22/2017.
 */
public class No118_Pascals_Triangle {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> res = new ArrayList<>();
		if (numRows < 1)
			return res;
		res.add(Arrays.asList(1));

		for (int i = 2; i <= numRows; i++){
			List<Integer> cnt = new ArrayList<>();
			List<Integer> before = res.get(i-2);
			for (int j = 1; j <= i; j++){
				if (j == 1 || j == i)
					cnt.add(1);
				else
					cnt.add(before.get(j-2)+before.get(j-1));
			}
			res.add(cnt);
		}

		res.stream().forEach(integers -> System.out.println(integers));

		return res;
	}

	public static void main(String[] args) {
		No118_Pascals_Triangle a = new No118_Pascals_Triangle();
		a.generate(5);
	}
}
