package study.backtracking;

import common.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Qbss
 * @date: 2023/10/25
 * @desc: 全排列问题
 */
public class Example1 {


    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    void dealListToNode(List<Integer> list) {
        Node node;
        if (list.isEmpty()) {
            return;
        }
        node = new Node(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            node.next = new Node(list.get(i));
        }
    }

    //输入一个整数数组，数组中不包含重复元素，返回所有可能的排列。
    void preOrder(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {

        if (state.size() == choices.length) {
            res.add(new ArrayList<>(state));
            return;
        }

        for (int i = 0; i < choices.length; i++) {
            if (!selected[i]) {
                state.add(choices[i]);
                selected[i] = true;
                preOrder(state, choices, selected, res);
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    void preOrder1(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        if (state.size() == choices.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < choices.length; i++) {
            if (!selected[i] && !set.contains(choices[i])) {
                state.add(choices[i]);
                selected[i] = true;
                preOrder1(state, choices, selected, res);
                selected[i] = false;
                state.remove(state.size() - 1);
                set.add(choices[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Example1 example1 = new Example1();
        List<List<Integer>> res = new ArrayList<>();
        example1.preOrder1(new ArrayList<>(), nums, new boolean[nums.length], res);
        System.out.println(res);
    }

}
