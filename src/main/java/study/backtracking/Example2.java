package study.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2023/10/25
 * @desc: 子集和问题
 */
public class Example2 {

    /*给定一个正整数数组 nums 和一个目标正整数 target ，
    请找出所有可能的组合，使得组合中的元素和等于 target 。
    给定数组无重复元素，每个元素只可以被选择一次。
    请以列表形式返回这些组合，列表中不应包含重复组合。*/
    void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        if (!state.isEmpty() && state.stream().reduce(Integer::sum).get() == 9) {
            res.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < choices.length; i++) {
            if (!selected[i]) {
                state.add(choices[i]);
                selected[i] = true;
                backtrack(state, choices, selected, res);
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    /*给定一个正整数数组 nums 和一个目标正整数 target ，
    请找出所有可能的组合，使得组合中的元素和等于 target 。
    给定数组无重复元素，每个元素可以被重复使用。
    请以列表形式返回这些组合，列表中不应包含重复组合。*/
    void backtrack1(List<Integer> state, int[] choice, List<List<Integer>> res) {
        if (!state.isEmpty()) {
            int sum = state.stream().reduce(Integer::sum).get();
            if (sum == 9) {
                res.add(new ArrayList<>(state));
                return;
            } else if (sum > 9) {
                return;
            }
        }

        for (int i = 0; i < choice.length; i++) {
            state.add(choice[i]);
            backtrack1(state, choice, res);
            state.remove(state.size() - 1);
        }
    }

    void backtrack2(List<Integer> state, int target, int total, int[] choices, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(state));
            return;
        }

        for (int choice : choices) {
            if (total + choice > target) {
                continue;
            }
            state.add(choice);
            backtrack2(state, target, total + choice, choices, res);
            state.remove(state.size() - 1);
        }
    }

    void backtrack3(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        for (int i = start; i < choices.length; i++) {
            if (target - choices[i] < 0) {
                break;
            }
            state.add(choices[i]);
            backtrack3(state, target - choices[i], choices, i, res);
            state.remove(state.size() - 1);
        }
    }

    public static void main(String[] args) {
        Example2 example2 = new Example2();
        int[] nums = {3, 4, 5};
        List<List<Integer>> res = new ArrayList<>();
        //example2.backtrack(new ArrayList<>(), nums, new boolean[nums.length], res);
        //example2.backtrack1(new ArrayList<>(), nums, res);
        //example2.backtrack2(new ArrayList<>(), 9, 0, nums, res);
        example2.backtrack3(new ArrayList<>(), 9, nums, 0, res);
        System.out.println(res);
    }

}
