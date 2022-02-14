package method;

import java.util.Arrays;

public class Solution1 {


    public static int[] twoSum(int[] nums, int target) {
        int[] reNums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int b = nums[j];
                if (a+b == target){
                    reNums[0] = i;
                    reNums[1] = j;
                    break;
                }else {
                    continue;
                }
            }
        }
        return reNums;
    }


    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] reNums = twoSum(nums,target);



        System.out.println(Arrays.toString(reNums));
    }



}
