import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hiki on 2017/9/13.
 */
public class No20_ValidParentheses {

	public boolean isValid(String s) {
		List<Character> st = new ArrayList<>();
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')'); map.put('[', ']'); map.put('{', '}');
		for (int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{'){
				st.add(ch);
			}
			else{
				int p = st.size()-1;
				if (p < 0 || ch != map.get(st.get(p))){
					return false;
				}
				else{
					st.remove(p);
				}
			}
		}
		if (st.size() != 0)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		No20_ValidParentheses vp = new No20_ValidParentheses();
		System.out.println(vp.isValid("((("));
	}

}
