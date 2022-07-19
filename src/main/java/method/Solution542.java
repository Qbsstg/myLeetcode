package method;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/7/19
 * @desc
 */
public class Solution542 {

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(mat)));
    }


    private static int[] dx = {-1, 0, 0, 1};

    private static int[] dy = {0, -1, 1, 0};

    public static int[][] updateMatrix(int[][] mat) {


        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = mat[i][j];
                if (value == 1) {
                    List<Integer> count = new ArrayList<>();
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        Queue<int[]> ints = new ArrayDeque<>();
                        for (int k = 0; k < 4; k++) {
                            int mx = poll[0] + dx[k];
                            int my = poll[1] + dy[k];
                            if (mx >= 0 && my >= 0 && mx < n && my < m) {
                                int info = mat[mx][my];
                                ints.offer(new int[]{mx, my});
                                if (info == 0) {
                                    count.add(mx);
                                    count.add(my);
                                    ints.clear();
                                    queue.clear();
                                    break;
                                }
                            }
                        }
                        queue.addAll(ints);
                    }
                    if (count.isEmpty()) {
                        ans[i][j] = -1;
                    } else {
                        ans[i][j] = Math.abs(count.get(0) - i) + Math.abs(count.get(1) - j);
                    }
                } else {
                    ans[i][j] = 0;
                }
                mat[i][j] = -1;
            }
        }
        return ans;
    }


}
