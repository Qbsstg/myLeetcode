package method;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/7/19
 * @desc
 */
public class Solution542 {

    public static void main(String[] args) {
        //int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        //int[][] mat = {{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}};

        int[][] mat =
                {
                        {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                        {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                        {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                        {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
                };


        System.out.println(Arrays.deepToString(updateMatrix(mat)));
        //System.out.println(mat1[1][1]);

    }


    private static int[] dx = {-1, 0, 0, 1};

    private static int[] dy = {0, -1, 1, 0};

    public static int[][] updateMatrix(int[][] mat) {




        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];




        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = mat[i][j];
                if (value == 1) {
                    if (ans[i][j] == -1) {
                        int count = 0;

                        Set<Map<Integer, Integer>> set = new HashSet<>();
                        Map<Integer, Integer> map = new HashMap<>();
                        map.put(i, j);
                        set.add(map);

                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[]{i, j});

                        while (!queue.isEmpty()) {
                            count++;
                            int size = queue.size();
                            for (int s = 0; s < size; s++) {
                                int[] poll = queue.poll();
                                for (int k = 0; k < 4; k++) {
                                    int mx = poll[0] + dx[k];
                                    int my = poll[1] + dy[k];
                                    if (mx >= 0 && my >= 0 && mx < n && my < m) {
                                        if (mat[mx][my] == 0) {
                                            queue.clear();
                                            map.clear();
                                            s = size;
                                            break;
                                        } else {
                                            Map<Integer, Integer> integerMap = new HashMap<>();
                                            integerMap.put(mx, my);
                                            if (set.add(integerMap)) {
                                                queue.offer(new int[]{mx, my});
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        ans[i][j] = count;
                    }
                } else {
                    ans[i][j] = 0;
                }
            }
        }
        return ans;
    }


}
