/**
 * Created by Hiki on 9/14/2017.
 */
public class No28_ImplementStrStr {


	public int strStr(String haystack, String needle) {
		int m = haystack.length(), n = needle.length();
		if (n == 0) return 0;
		if (m == 0 || m < n) return -1;
		int p = 0, q = 0;
		while (p < m && q < n){
			int temp_point = p;
			while (p < m && q < n && haystack.charAt(p) == needle.charAt(q)){
				if (q == n-1){
					return temp_point;
				}
				p++;
				q++;
			}

			p = temp_point+1;
			q = 0;

		}

		return -1;

	}

	public static void main(String[] args) {
		No28_ImplementStrStr str = new No28_ImplementStrStr();
		int a = str.strStr("mississippi","issipi");
		System.out.println(a);
	}
}
