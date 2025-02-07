package method;

import java.util.Arrays;

/**
 *@author Qbss
 *@date 2025/2/7 11:24
 *@desc 59. 螺旋矩阵 II
 **/
public class Solution59 {

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        //定义边界
        int top = 0;
        int bottom = n - 1;
        int right = n - 1;
        int left = 0;
        int val = 1;

        while (val <= n * n) {
            //先往右边走
            for (int i = left; i <= right; i++) {
                res[top][i] = val++;
                ;
            }
            //跑到头，高度+1
            top++;
            //往下跑
            for (int j = top; j <= bottom; j++) {
                res[j][right] = val++;
            }
            //跑到头，右边界-1
            right--;
            //往左跑
            for (int i = right; i >= left; i--) {
                res[bottom][i] = val++;
            }
            //跑到头，底边界-1
            bottom--;
            //往上跑
            for (int j = bottom; j >= top; j--) {
                res[j][left] = val++;
            }
            //跑到头,左边界+1
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix(2)));
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

}
