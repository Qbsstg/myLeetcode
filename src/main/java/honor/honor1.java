package honor;

import java.util.*;

public class honor1 {

    public static int[][] dis = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                nums[i][i1] = scanner.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int y = 0; y < n; y++) {
                if (nums[i][y] == 1) {
                    result++;
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    int new_i = i + dis[j][0];
                    int new_y = y + dis[j][1];
                    if (new_i >= 0 && new_i < m && new_y >= 0 && new_y < n && nums[new_i][new_y] == 1) {
                        result++;
                        break;
                    }
                }
            }
        }

    }

}
