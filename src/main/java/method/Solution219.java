package method;

/**
 * @author Qbss
 * @date 2021/3/27
 * @desc
 */
public class Solution219 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        //双指针
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] == nums[i] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }


}
