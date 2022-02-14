package method;

/**
 * @author Qbss
 * @date 2021/3/31
 * @desc
 */
public class Solution485 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                int b = nums[j];
                if (a + b == 2) {
                    count++;
                } else {
                    if (j - i > count) {
                        count = j - i;
                    }
                    i = j;
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }


}
