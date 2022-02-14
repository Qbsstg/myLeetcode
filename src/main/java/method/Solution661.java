package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2021/4/14
 * @desc
 */
public class Solution661 {

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        int[][] nums = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};

        int[][] ints = imageSmoother(nums);
        System.out.println(ints);
    }

    public static int[][] imageSmoother(int[][] M) {


        int l = M[0].length;
        int h = M.length;

        int[][] result = new int[h][l];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                int a = M[i][j];
                int count = 1;
                if (i - 1 >= 0) {
                    int top = M[i - 1][j];
                    count++;
                    a += top;
                    if (j - 1 >= 0) {
                        int topLeft = M[i - 1][j - 1];
                        count++;
                        a += topLeft;
                    }
                    if (j + 1 < l) {
                        int topRight = M[i - 1][j + 1];
                        count++;
                        a += topRight;
                    }
                }
                if (i + 1 < h) {
                    int button = M[i + 1][j];
                    count++;
                    a += button;
                    if (j - 1 >= 0) {
                        int buttonLeft = M[i + 1][j - 1];
                        count++;
                        a += buttonLeft;
                    }
                    if (j + 1 < l) {
                        int buttonRight = M[i + 1][j + 1];
                        count++;
                        a += buttonRight;
                    }
                }
                if (j - 1 >= 0) {
                    int left = M[i][j - 1];
                    count++;
                    a += left;
                }
                if (j + 1 < l) {
                    int right = M[i][j + 1];
                    count++;
                    a += right;
                }
                result[i][j] = a / count;
            }
        }
        return result;
    }


}
