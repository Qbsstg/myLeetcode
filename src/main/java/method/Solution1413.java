package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/8/9
 * @desc
 */
public class Solution1413 {


    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{2, 3, 5, -5, -1}));
    }

    /*
     * sum[i] = s[i-1] + arr[i]
     * interval[i,j] = sum[j] - sum[i-1]
     * ==> sum[i-1] = sum[j] - interval[i,j]
     *
     * */
    public static int minStartValue(int[] nums) {
        int count = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            res[i] = count;
        }

        int asInt = Arrays.stream(res).min().getAsInt();
        if (asInt >= 1) {
            return 1;
        } else {
            return 1 - asInt;
        }

    }


}
