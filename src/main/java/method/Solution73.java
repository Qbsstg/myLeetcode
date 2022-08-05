package method;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qbss
 * @date 2022/8/5
 * @desc
 */
public class Solution73 {

    public void setZeroes(int[][] matrix) {


        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x.contains(i) || y.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}
