package method;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution695 {

    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, 1, -1, 0};


    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0
                , 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland2(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int s = grid[i][j];
                if (!(s == 0 || s == -1)) {
                    List<Integer> counts = new ArrayList<>();
                    dfs(grid, i, j, counts, n, m);
                    count = Math.max(counts.stream().reduce(Integer::sum).orElse(0), count);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int x, int y, List<Integer> counts, int n, int m) {
        if (grid[x][y] == 1) {
            grid[x][y] = -1;
            counts.add(1);
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && my >= 0 && mx < m && my < n) {
                    dfs(grid, mx, my, counts, n, m);
                }
            }
        }
    }

    public static int maxAreaOfIsland1(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int s = grid[i][j];
                if (!(s == 0 || s == -1)) {
                    count = Math.max(count, dfs1(grid, i, j));
                }
            }
        }
        return count;
    }

    private static int dfs1(int[][] grid, int x, int y) {
        int ans = 1;
        grid[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && my >= 0 && mx < grid.length && my < grid[0].length && grid[mx][my] == 1) {
                ans += dfs1(grid, mx, my);
            }
        }
        return ans;
    }

    public static int maxAreaOfIsland2(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int s = grid[i][j];
                if (!(s == 0 || s == -1)) {
                    count = Math.max(count, bfs(grid, i, j));
                }
            }
        }
        return count;
    }

    private static int bfs(int[][] grid, int x, int y) {

        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            ans++;
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            grid[x1][y1] = -1;
            for (int i = 0; i < 4; i++) {
                int mx = x1 + dx[i];
                int my = y1 + dy[i];
                if (mx >= 0 && my >= 0 && mx < grid.length && my < grid[0].length && grid[mx][my] == 1) {
                    queue.offer(new int[]{mx, my});
                }
            }
        }
        return ans;
    }
}
