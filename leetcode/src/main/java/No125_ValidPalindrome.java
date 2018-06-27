/**
 * Created by Hiki on 9/28/2017.
 */
public class No125_ValidPalindrome {

	public boolean isPalindrome(String s) {
		int n = s.length();

		int low = 0, high = n - 1;
		while (low < n && high >= 0 && low <= high) {
			while (!Character.isLetter(s.charAt(low)) && !Character.isDigit(s.charAt(low))){
				low++;
				if (low >= n)
					return true;
			}
			while (high > 0 && !Character.isLetter(s.charAt(high)) && !Character.isDigit(s.charAt(high))){
				high--;
				if (high < 0)
					return true;
			}
			if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)))
				return false;
			low++;
			high--;
		}
		return true;
	}

	public static void main(String[] args) {
		No125_ValidPalindrome vp = new No125_ValidPalindrome();
		System.out.println(vp.isPalindrome(" "));
	}
}
