package method;

/**
 *@author Qbss
 *@date 2025/2/8 14:48
 *@desc 63. 不同路径 II
 **/
public class Solution63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        //行数
        int m = obstacleGrid.length;
        //列数
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        //dp[i][j] = dp[i][j-1]+dp[i-1][j]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遇到障碍
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (j - 1 >= 0) {
                        dp[i][j] += (obstacleGrid[i][j - 1] == 0 ? dp[i][j - 1] : 0);
                    }
                    if (i - 1 >= 0) {
                        dp[i][j] += (obstacleGrid[i - 1][j] == 0 ? dp[i - 1][j] : 0);
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
