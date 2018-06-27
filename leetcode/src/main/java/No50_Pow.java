/**
 * @author hiki on 2017-12-28
 */

public class No50_Pow {

    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 1)
            return x;
        if (n == -1)
            return 1.0/x;
        if (n == 0)
            return 1.0;

        double res = myPow(x, n/2);

        if (n % 2 == 0) {
            return res * res;
        }
        else {
            return res * res * (n > 0 ? x : 1.0/x);
        }
    }

    public static void main(String[] args) {
        No50_Pow pow = new No50_Pow();
        System.out.println(pow.myPow(0.00001, 2147483647));
    }
}
