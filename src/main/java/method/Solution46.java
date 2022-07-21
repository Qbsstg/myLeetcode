package method;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/7/21
 * @desc
 */
public class Solution46 {


    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        boolean[] used = new boolean[length];

        dfs(nums, length, 0, deque, res, used);

        return res;
    }

    private static void dfs(int[] nums, int length, int depth, Deque<Integer> deque,
                            List<List<Integer>> res, boolean[] used) {

        if (depth == length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }
            deque.addLast(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, deque, res, used);
            used[i] = false;
            deque.removeLast();
        }
    }


}
