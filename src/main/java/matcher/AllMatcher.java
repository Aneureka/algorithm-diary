package matcher;

/**
 * @author hiki on 2018-04-16
 */

public class AllMatcher {

    static void showAllMatcher(int k) {
        showAllMatcher(k, 0, 0);
    }

    static void showAllMatcher(int all, int left, int right) {
        if (left == all && right == all) {
            System.out.println();
            return;
        }

        for (int i = 0; i <= all-left; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("(");
            }
            for (int j = 1; j <= left+i-right && j <= all-right; j++) {
                System.out.print(")");
                showAllMatcher(all, left+i, right+j);
            }
        }
    }

    public static void main(String[] args) {
        showAllMatcher(4);
    }
}
