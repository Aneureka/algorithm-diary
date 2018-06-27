/**
 * Created by Hiki on 9/15/2017.
 */
public class No38_CountAndSay {

	public String countAndSay(int n) {

		String res = "1";
		for (int i = 1; i < n; i++){
			res = nextString(res);
		}

		return res;
	}

	private String nextString(String s){
		int n = s.length();
		StringBuilder res = new StringBuilder();
		char tmp = ' ';
		int count = 0;
		int i = 0;
		while (i < n){
			char ch = s.charAt(i);
			if (ch != tmp){
				if (tmp != ' '){
					res.append(count).append(tmp);
				}
				tmp = ch;
				count = 1;
			}
			else{
				count++;
			}
			i++;
		}

		res.append(count).append(tmp);
		return res.toString();

	}
}
