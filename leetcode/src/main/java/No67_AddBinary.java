import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 9/18/2017.
 */
public class No67_AddBinary {

	public String addBinary(String a, String b) {
		int m = a.length(), n = b.length();
		int ptr = 1;
		int c = 0;
		List<Integer> ctn = new ArrayList<>();
		while (m-ptr >= 0 || n-ptr >= 0 || c == 1){
			int s = c;
			if (m-ptr >= 0)
				s += a.charAt(m-ptr) - '0';
			if (n-ptr >= 0)
				s += b.charAt(n-ptr) - '0';

			c = s / 2;
			s = s % 2;

			ctn.add(s);

			ptr++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = ctn.size()-1; i >= 0; i--){
			sb.append(ctn.get(i));
		}


		return sb.toString();

	}

	public static void main(String[] args) {
		No67_AddBinary ab = new No67_AddBinary();
		System.out.println(ab.addBinary("0", "0"));
	}

}
