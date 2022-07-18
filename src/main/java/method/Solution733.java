package method;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Qbss
 * @date 2022/7/18
 * @desc
 */
public class Solution733 {

    private int[] dx = {1, 0, 0, -1};
    private int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) {
        Solution733 solution733 = new Solution733();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        solution733.floodFill(image, sr, sc, newColor);
        System.out.println(Arrays.deepToString(image));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color){
            return image;
        }
        dfs1(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {


        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
        }

        if (sr < image[0].length) {
            if (sr - 1 >= 0 && image[sr - 1][sc] == color) {
                dfs(image, sr - 1, sc, color, newColor);
            }
            if (sr + 1 < image[0].length && image[sr + 1][sc] == color) {
                dfs(image, sr + 1, sc, color, newColor);
            }

        }
        if (sc < image.length) {
            if (sc - 1 >= 0 && image[sr][sc - 1] == color) {
                dfs(image, sr, sc - 1, color, newColor);
            }
            if (sc + 1 < image.length && image[sr][sc + 1] == color) {
                dfs(image, sr, sc + 1, color, newColor);
            }
        }

    }

    private void dfs1(int[][] image, int x, int y, int color, int newColor) {

        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && my >= 0 && mx < image.length && my < image[0].length) {
                    dfs1(image, mx, my, color, newColor);
                }
            }
        }
    }

    public int[][] bfs(int[][] image, int x, int y, int color) {

        int currColor = image[x][y];
        if (currColor == color) {
            return image;
        }

        int n = image.length;
        int m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            for (int i = 0; i < 4; i++) {
                int mx = x1 + dx[i];
                int my = y1 + dy[i];
                if (mx >= 0 && my <= 0 && mx < n && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;
    }


}
