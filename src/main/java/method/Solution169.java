package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2021/3/27
 * @desc
 */
public class Solution169 {


    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
//        sort(nums);
//        System.out.println(Arrays.toString(nums));
        System.out.println(getSomeThing(nums));

    }


    public int majorityElement(int[] nums) {
        //冒泡排序
        sort(nums);
        return nums[nums.length / 2];

    }


    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }


    private static int getSomeThing(int[] nums) {

        int a = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (a == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    a = nums[i];
                    count++;
                }
            }
        }
        return a;

    }

}
