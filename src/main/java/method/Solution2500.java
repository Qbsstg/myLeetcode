package method;

import java.util.Arrays;

public class Solution2500 {


    public int deleteGreatestValue(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;

        int[][] nums = new int[m][n];

        for (int[] ints : grid) {
            Arrays.sort(ints);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : grid) {
                max = Math.max(max, ints[n - i - 1]);
            }
            result += max;
        }


        return result;
    }

}
