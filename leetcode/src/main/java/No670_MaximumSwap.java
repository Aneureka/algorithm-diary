import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Hiki on 10/6/2017.
 */
public class No670_MaximumSwap {

	public int maximumSwap(int num) {

		// init
		char[] digits = String.valueOf(num).toCharArray();
		int n = digits.length;
		List<Item> cnt = new ArrayList<>();
		for (int i = 0; i < digits.length; i++){
			cnt.add(new Item(i, digits[i]));
		}
		cnt.sort((o1, o2) -> o2.digit - o1.digit);


		// locate to the element to swap
		int i = 0;
		while (cnt.get(i).index == i){
			i++;
			if (i >= n) return num;
		}

		// find out the elements to swap
		int ptr1 = i;
		while(i < n-1 && cnt.get(i).digit == cnt.get(i+1).digit) i++;
		int ptr2 = cnt.get(i).index;

		// swap two elements
		char tmp = digits[ptr1];
		digits[ptr1] = digits[ptr2];
		digits[ptr2] = tmp;

		return Integer.valueOf(String.valueOf(digits));
	}

	private static class Item{
		int index;
		char digit;
		Item(int index, char digit){
			this.index = index;
			this.digit = digit;
		}
	}

	public static void main(String[] args) {
		No670_MaximumSwap a = new No670_MaximumSwap();
		System.out.println(a.maximumSwap(273687822));
	}
}
