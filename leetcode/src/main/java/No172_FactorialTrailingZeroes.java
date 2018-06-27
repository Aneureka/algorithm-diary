/**
 * Created by Hiki on 9/28/2017.
 */
public class No172_FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
		int count = n / 5;
		int res = 0;
		int itr = 1;
		while (count > 20){
			res = itr * 20;
			count -= 20;
			itr++;
		}

		res += itr*count;
		return res;
	}

}
