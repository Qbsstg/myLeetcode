package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qbss
 * @date 2021/4/8
 * @desc
 */
public class Solution566 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3, 4}};
        int[][] ints = matrixReshape(nums, 1, 4);
        System.out.println(ints);
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        int high = nums.length;
        int length = nums[0].length;

        int[][] result = new int[r][c];

        if (length * high != r * c) {
            return nums;
        } else {
            List<Integer> temp = new ArrayList<>();
            for (int[] num : nums) {
                for (int j = 0; j < length; j++) {
                    int a = num[j];
                    temp.add(a);
                }
            }
            int j = 0;
            for (int i = 0; i < r; i++) {
                for (int i1 = 0; i1 < c; i1++) {
                    result[i][i1] = temp.get(j);
                    j++;
                }
            }
        }
        return result;
    }


}
