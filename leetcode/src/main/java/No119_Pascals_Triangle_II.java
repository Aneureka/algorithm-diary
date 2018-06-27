import java.util.ArrayList;
		import java.util.List;

/**
 * Created by Hiki on 9/23/2017.
 */
public class No119_Pascals_Triangle_II {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++)
			res.add(cmn(i, rowIndex));
		return res;
	}

	private int cmn(int m, int n){
		if (m > n/2) m = n-m;
		double res = 1;
		for(int i = 1; i <= m; i++){
			res *= (n-m+i);
			res /= i;
		}
		return (int)res;
	}

	public static void main(String[] args) {
		No119_Pascals_Triangle_II pt = new No119_Pascals_Triangle_II();
		pt.getRow(18);
	}
}
