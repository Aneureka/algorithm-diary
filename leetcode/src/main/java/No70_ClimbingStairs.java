/**
 * Created by Hiki on 9/18/2017.
 */
public class No70_ClimbingStairs {

	public int climbStairs(int n) {
		if (n == 1 || n == 2)
			return n;

		int a = 1, b = 2;
		for (int i = 3; i <= n; i++){
			int temp = b;
			b = b + a;
			a = temp;
		}

		return b;
	}


	/*
	public int climbStairs(int n) {
		if (n <= 1)
			return 1;
		return climbStairs(n-1) + climbStairs(n-2);

	}
	 */


	public static void main(String[] args) {
		No70_ClimbingStairs cs = new No70_ClimbingStairs();
		System.out.println(cs.climbStairs(3));
	}
}
