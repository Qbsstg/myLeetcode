package contest.weekly.w308;

import java.util.Arrays;

public class Solution1 {

    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i];
            int sum = 0;
            int index = -1;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if (sum > temp) {
                    break;
                }
                index = j;
            }
            res[i] = index + 1;
        }
        return res;
    }
}
