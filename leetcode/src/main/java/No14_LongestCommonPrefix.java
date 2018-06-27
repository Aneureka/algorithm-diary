/**
 * Created by Hiki on 2017/8/24.
 */
public class No14_LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {

		if (strs.length == 0)
			return "";

		// 先求出最小长度
		int minLen = strs[0].length();
		for (int i = 0; i < strs.length; i++)
			minLen = Math.min(minLen, strs[i].length());

		// 遍历
		String common = "";
		int i = 0;
		while (i < minLen){
			char c = strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++)
				if (strs[j].charAt(i) != c)
					return common;
			common += c;
			i++;
		}

		return common;
	}
}
