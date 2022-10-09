package contest.weekly.s;

public class Solution1 {


    public int hardestWorker(int n, int[][] logs) {

        int[] nums = new int[n];

        int time = 0;
        for (int i = 0; i < logs.length; i++) {

            int[] log = logs[i];

            int id = log[0];
            int leaveTime = log[1];

            int diff = leaveTime - time;
            if (diff > nums[id]) {
                nums[id] = diff;
            }
            time = leaveTime;
        }

        int max = Integer.MIN_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > max) {
                max = a;
                result = i;
            }
        }

        return result;

    }


}
