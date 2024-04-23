package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2024/4/22
 * @desc: 377. 组合总和 Ⅳ
 */
public class Solution377 {


    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, nums, new ArrayList<>(), 0, target);

        return result.size();
    }

    private static void dfs(List<List<Integer>> result, int[] candidates, List<Integer> list, int sum, int target) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            List<Integer> ans = new ArrayList<>(list);
            result.add(ans);
            return;
        }

        for (int candidate : candidates) {
            sum = sum + candidate;
            list.add(candidate);
            dfs(result, candidates, list, sum, target);
            sum = sum - candidate;
            list.remove(list.size() - 1);
        }
    }
}
