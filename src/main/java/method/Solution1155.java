package method;

/**
 * @author: Qbss
 * @date: 2023/10/24
 * @desc:
 */
public class Solution1155 {


    public int numRollsToTarget(int n, int k, int target) {

        int mod = 1000000007;

        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < target; j++) {
                for (int a = 1; a < k; a++) {
                    if (target - a >= 0) {
                        f[i][j] = (f[i][j] + f[i - 1][target - a]) % mod;
                    }
                }
            }
        }
        return f[n][target];


    }

}
