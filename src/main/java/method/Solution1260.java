package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/7/20
 * @desc
 */
public class Solution1260 {


    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        System.out.println(shiftGrid(grid, k));
    }


    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        List<Integer> list = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                list.add(ints[j]);
            }
        }

        int i = k % (m * n);

        for (int t = list.size() - i; t < list.size(); t++) {
            nums.add(list.get(t));
        }

        for (int j = 0; j < list.size() - i; j++) {
            nums.add(list.get(j));
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (Integer num : nums) {
            ans.add(num);
            if (ans.size() == m) {
                result.add(ans);
                ans = new ArrayList<>();
            }
        }

        return result;

    }

}
