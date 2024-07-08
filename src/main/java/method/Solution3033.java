package method;

/**
 * @author: Qbss
 * @date: 2024/7/6
 * @desc: 3033. 修改矩阵
 */
public class Solution3033 {

    public int[][] modifiedMatrix(int[][] matrix) {

        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;

        int[] maxN = new int[n];

        for (int i = 0; i < n; i++) {
            for (int[] ints : matrix) {
                maxN[i] = Math.max(maxN[i], ints[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == -1) {
                    matrix[j][i] = maxN[i];
                }
            }
        }

        return matrix;

    }

}
