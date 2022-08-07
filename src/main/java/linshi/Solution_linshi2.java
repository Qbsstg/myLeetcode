package linshi;

import java.util.*;

public class Solution_linshi2 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};
        //countBadPairs(nums);
        //System.out.println(count1(new int[]{4, 1, 3, 3,}));
        //System.out.println(count1(new int[]{1, 2, 3, 4, 5}));
        System.out.println(add(100));
    }

    public static long countBadPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - num != j - i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long count1(int[] nums)  


    private static int add(int l) {

        return ((1 + l) * l) >> 1;

    }

}
