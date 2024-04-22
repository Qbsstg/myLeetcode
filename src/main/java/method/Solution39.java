package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2024/4/22
 * @desc: 39. 组合总和
 */
public class Solution39 {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5, 7};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, candidates, new ArrayList<>(), 0, target, 0);

        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] candidates, List<Integer> list, int sum, int target, int index) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            List<Integer> ans = new ArrayList<>(list);
            result.add(ans);
            return;
        }

        for (; index < candidates.length; index++) {
            sum = sum + candidates[index];
            list.add(candidates[index]);
            dfs(result, candidates, list, sum, target, index);
            sum = sum - candidates[index];
            list.remove(list.size() - 1);
        }
    }

}