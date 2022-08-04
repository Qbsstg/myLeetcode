package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/8/4
 * @desc
 */
public class Solution1602 {

    public static void main(String[] args) {
        int[][] towers = {{2, 1, 9}, {0, 1, 9}};
        int[][] towers1 =
                {{32, 36, 27}, {17, 22, 43}, {8, 11, 41}, {46, 28, 7}, {22, 4, 35}, {41, 8, 33}, {32, 29, 4}, {44, 32, 16}, {33, 20, 16}, {3, 38, 35}, {17, 47, 23}, {33, 0, 29}, {29, 19, 6}, {4, 50, 46}, {19, 47, 6}, {48, 6, 41}, {20, 26, 35}};
        System.out.println(Arrays.toString(bestCoordinate(towers1, 2)));
    }

    public static int[] bestCoordinate(int[][] towers, int radius) {
        int[] ans = new int[2];
        int max = 0;
        int ax = Integer.MAX_VALUE;
        int bx = 0;

        int ay = Integer.MAX_VALUE;
        int by = 0;
        int radius2 = radius * radius;

        for (int[] tower : towers) {
            ax = Math.min(tower[0], ax);
            bx = Math.max(tower[0], bx);
            ay = Math.min(tower[1], ay);
            by = Math.max(tower[1], by);
        }


        for (int i = ax; i <= bx; i++) {
            for (int j = ay; j <= by; j++) {
                int signal = 0;
                for (int[] tower : towers) {
                    int distance = (tower[0] - i) * (tower[0] - i) + (tower[1] - j) * (tower[1] - j);

                    if (distance <= radius2) {
                        signal += Math.floor(tower[2] / (1 + Math.sqrt(distance)));
                    }
                }
                if (signal > max) {
                    max = signal;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }

    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int[] ans = new int[2];
            int max = 0;
            int radius2 = radius * radius;

            //获得需要遍历的范围
            int ax = Integer.MAX_VALUE, ay = Integer.MAX_VALUE, bx = 0, by = 0;
            for (int[] tower : towers) {
                ax = Math.min(tower[0], ax);
                bx = Math.max(tower[0], bx);
                ay = Math.min(tower[1], ay);
                by = Math.max(tower[1], by);

            }


            for (int i = ax; i <= bx; i++) {
                for (int j = ay; j <= by; j++) {
                    int signal = 0;
                    for (int[] tower : towers) {
                        int distance2 =
                                (tower[0] - i) * (tower[0] - i) +
                                        (tower[1] - j) * (tower[1] - j);
                        //如果距离小于radius，则signal加上此塔的信号
                        if (distance2 <= radius2) {
                            signal += Math.floor(tower[2] / (1 + Math.sqrt(distance2)));
                        }
                    }
                    //取得最大的信号值和坐标点位置
                    if (signal > max) {
                        max = signal;
                        ans[0] = i;
                        ans[1] = j;
                    }
                }
            }
            return ans;
        }
    }


}
