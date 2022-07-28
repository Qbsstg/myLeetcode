package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/7/28
 * @desc
 */
public class Solution2354 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(countExcellentPairs(nums, k));
    }

    public static long countExcellentPairs(int[] nums, int k) {


        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        int length = nums.length;
        boolean[] used = new boolean[length];
        //dfs(nums, length, 0, used, res, ans);
        dfs(nums, 0, res, ans);
        System.out.println(res);


        return 0L;

    }

    private static void dfs(int[] nums, int length, int depth, boolean[] used, List<List<Integer>> res, List<Integer> ans) {
        if (depth == 2) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                ans.add(nums[i]);
                used[i] = true;
                dfs(nums, length, depth + 1, used, res, ans);
                ans.remove(ans.size() - 1);
                used[i] = false;
            }
        }
    }


    private static void dfs(int[] nums, int index, List<List<Integer>> res,
                            List<Integer> ans) {

        if (ans.size() == 2) {
            res.add(new ArrayList<>(ans));
            return;
        }

        if (ans.size() + nums.length - index + 1 < 2) {
            return;
        }

        if (index >= nums.length){
            return;
        }

        ans.add(nums[index]);
        dfs(nums, index + 1, res, ans);
        ans.remove(ans.size() - 1);
        dfs(nums, index + 1, res, ans);
    }
}
