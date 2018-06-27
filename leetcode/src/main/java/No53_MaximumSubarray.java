/**
 * @author hiki on 2017-12-26
 */

public class No53_MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int max = nums[0];
        int cur = 0;

        for (int i = 0; i < n; i++) {
            if (cur < 0) {
                cur = nums[i];
            }
            else {
                cur += nums[i];
            }
            if (cur > max) {
                max = cur;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        No53_MaximumSubarray mms = new No53_MaximumSubarray();
        System.out.println(mms.maxSubArray(nums));
    }
}
