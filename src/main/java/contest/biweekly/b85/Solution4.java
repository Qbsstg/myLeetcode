package contest.biweekly.b85;

import java.util.TreeSet;

public class Solution4 {


    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {

        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < removeQueries.length; i++) {


        }
        return null;
    }

}
