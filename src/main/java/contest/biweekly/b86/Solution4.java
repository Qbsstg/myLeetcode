package contest.biweekly.b86;

public class Solution4 {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

        int n = chargeTimes.length;

        for (int i = 0; i < n; i++) {
            int max = chargeTimes[i];
            int sum = runningCosts[i];

            while (max + 3L * sum <= budget) {

            }

        }
        return 1;
    }

}
