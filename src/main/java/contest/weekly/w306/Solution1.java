package contest.weekly.w306;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})));
    }

    public static int[][] largestLocal(int[][] grid) {

        int h = grid.length;
        int[][] res = new int[h - 2][h - 2];


        for (int n = 0; n + 3 <= h; n++) {
            for (int m = 0; m + 3 <= h; m++) {
                int max = 0;
                for (int i = 0; i < 3; i++) {
                    int x = n + i;
                    for (int j = 0; j < 3; j++) {
                        int y = m + j;
                        max = Math.max(grid[x][y], max);
                    }
                }
                res[n][m] = max;
            }
        }

        return res;
    }

}
