/**
 * Created by Hiki on 9/28/2017.
 */
public class No168_ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		String res = "";
		while (n > 0){
			int c = n % 26;
			if (c == 0){
				res = 'Z' + res;
				n -= 26;
			}
			else{
				res = (char)('A'+c-1) + res;
			}
			n = n / 26;
		}
		return res;
	}

}
