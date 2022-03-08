package method;

/**
 * @author Qbss
 * @date 2022/3/8
 * @desc
 */
public class Solution213 {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {0, 0};
        int[] nums5 = {1, 2};
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
        System.out.println(rob(nums4));
        System.out.println(rob(nums5));
    }


    //拆两队列取max
    public static int rob(int[] nums) {


        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        //分成两个队列
        //1:0~n-1
        int[] dp1 = new int[length];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        if (length == 2) {
            return dp1[1];
        }

        for (int i = 2; i < length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        //2:1~n
        int[] dp2 = new int[length];

        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i + 1]);
        }

        return Math.max(dp1[length - 2], dp2[length - 2]);
    }


}
