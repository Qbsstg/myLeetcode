package test;

/**
 * @author Qbss
 * @date 2022/7/22
 * @desc
 */
public class test1 {

    public static void main(String[] args) {
        climbStairs(4);
    }

    public static int climbStairs(int n) {
        int[] nums = new int[n + 1];
        if (n == 1 || n == 2) {
            return n;
        }
        nums[1] = 1;
        nums[2] = 2;

        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
