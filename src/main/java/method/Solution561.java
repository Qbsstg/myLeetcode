package method;

/**
 * @author Qbss
 * @date 2021/3/31
 * @desc
 */
public class Solution561 {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 2, 6, 5, 1, 2};
        System.out.println(arrayPairSum(nums));
    }


    public static int arrayPairSum(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;

                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        int sum = 0;
        for (int i = 0; i < nums.length; ) {
            sum = sum + nums[i];
            i = i + 2;
        }
        return sum;

    }

}
