package method;

/**
 * @author Qbss
 * @date 2021/4/25
 * @desc
 */
public class Solution674 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(findLengthOfLCIS(nums));
    }


    public static int findLengthOfLCIS(int[] nums) {

        int max = nums.length == 0 ? 0 : 1;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (b > a) {
                    max = Math.max(max, j - i + 1);
                    a = b;
                } else {
                    max = Math.max(max, j - i);
                    i = j - 1;
                    break;
                }
            }

        }
        return max;


    }

}
