/**
 * Created by Hiki on 9/18/2017.
 */
public class No69_Sqrt {

	public int mySqrt(int x) {
		return mySqrt(1, x, x);
	}

	private int mySqrt(int low, int high, int x){

		if ((long)low*(long)low == x) return low;
		if ((long)high*(long)high == x) return high;
		if (high-low <= 1){
			return low;
		}


		long mid = (long)low + (long)high >> 1;
		long m2 = mid * mid;

		if (m2 < x)
			return mySqrt((int)mid, high, x);
		else if (m2 > x)
			return mySqrt(low, (int)mid, x);
		else
			return (int)mid;
	}

	public static void main(String[] args) {
		No69_Sqrt s = new No69_Sqrt();
		System.out.println(s.mySqrt(2147483647));
	}
}
