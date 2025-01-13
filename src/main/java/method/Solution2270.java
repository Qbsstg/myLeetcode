package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date:
 * @desc:
 */
public class Solution2270 {


    public static int waysToSplitArray(int[] nums) {
        //Arrays.stream(nums).reduce(0, Integer::sum);
        long total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
        }

        int count = 0;

        long leftTotal = 0L;
        long rightTotal = total;
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            leftTotal += num;
            rightTotal -= num;
            if (leftTotal >= rightTotal) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ans = {2, 3, 1, 0};
        int[] ans1 = {10,4,-8,7};
        int[] ans2 = {42854,-46352,-11588,-46383,88658,10366};
        System.out.println(waysToSplitArray(ans2));
    }


}
