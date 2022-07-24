package method;

import java.util.*;

public class Solution6125 {

    public static void main(String[] args) {
        int[][] nums = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};

        System.out.println(equalPairs(nums));
    }

    public static int equalPairs(int[][] grid) {

        int n = grid.length;
        int[][] ans = new int[n][n];
        TreeMap<int[], Integer> set = new TreeMap<>(Arrays::compare);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = grid[j][i];
            }
            set.put(grid[i], set.getOrDefault(grid[i], 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (set.containsKey(ans[i])) {
                count += set.get(ans[i]);
            }
        }
        return count;

    }
}
