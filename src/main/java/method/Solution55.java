package method;

/**
 * @author Qbss
 * @date 2022/3/10
 * @desc
 */
public class Solution55 {

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 0, 4};
        canJump(a);
    }

    public static boolean canJump(int[] nums) {

        int m = nums[0];

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (num == 0) {
                if (m < i) {
                    return false;
                } else if (m == i) {
                    return i == nums.length - 1;
                }
            }
            m = Math.max(m, num + i);
        }
        return true;
    }


}
