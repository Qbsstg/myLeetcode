package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/7/22
 * @desc
 */
public class test1 {

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        System.out.println(ceShi(5));
    }

    public static int climbStairs(int n) {
        int[] nums = new int[n + 1];
        if (n == 1 || n == 2) {
            return n;
        }
        nums[1] = 1;
        nums[2] = 2;

        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        List<Integer> list = new ArrayList<>();
        for (int[] ints : mat) {
            for (int j = 0; j < n; j++) {
                list.add(ints[j]);
            }
        }
        int[][] res = new int[r][c];
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = list.get(k);
                k++;
            }
        }
        return res;
    }

    public static List<List<Integer>> ceShi(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            generate(res, i);
        }
        return res;
    }

    public static void generate(List<List<Integer>> res, int numRows) {
        if (numRows == 0) {
            res.add(List.of(1));
        }
        if (numRows == 1) {
            res.add(List.of(1, 1));
        }
        if (numRows > 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> integers = res.get(numRows - 1);
            for (int i = 0; i < integers.size(); i++) {
                if (i + 1 < integers.size()) {
                    list.add(integers.get(i) + integers.get(i + 1));
                }
            }
            list.add(1);
            res.add(list);
        }
    }
}
