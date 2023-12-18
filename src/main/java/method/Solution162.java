package method;

/**
 * @author: Qbss
 * @date: 2023/12/18
 * @desc: 寻找峰值
 */
public class Solution162 {


    public static int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean temp = true;
            int num = nums[i];
            if (i - 1 >= 0) {
                temp = num > nums[i - 1];
            }
            if (i + 1 <= nums.length - 1) {
                temp = temp && (num > nums[i + 1]);
            }
            if (temp){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

}
