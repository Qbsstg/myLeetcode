package study.backtracking;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2023/10/25
 * @desc:
 */
public class Learn {

    List<TreeNode> res = new ArrayList<>();

    //给定一个二叉树，搜索并记录所有值为7的节点，请返回节点列表
    void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.val == 7) {
            res.add(node);
        }

        preOrder(node.left);
        preOrder(node.right);
    }

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res1 = new ArrayList<>();

    //在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径。
    void preOrder1(TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.val == 7) {
            res1.add(path);
        }

        preOrder(node.left);
        preOrder(node.right);

        path.remove(path.size() - 1);
    }

    //在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点。
    void preOrder2(TreeNode node) {
        if (node == null || node.val == 3) {
            return;
        }
        path.add(node.val);
        if (node.val == 7) {
            res1.add(path);
        }

        preOrder(node.left);
        preOrder(node.right);

        path.remove(path.size() - 1);
    }



    /* 判断当前状态是否为解 */
    boolean isSolution(List<TreeNode> state) {
        return !state.isEmpty() && state.get(state.size() - 1).val == 7;
    }

    /* 记录解 */
    void recordSolution(List<TreeNode> state, List<List<TreeNode>> res) {
        res.add(new ArrayList<>(state));
    }

    /* 判断在当前状态下，该选择是否合法 */
    boolean isValid(List<TreeNode> state, TreeNode choice) {
        return choice != null && choice.val != 3;
    }

    /* 更新状态 */
    void makeChoice(List<TreeNode> state, TreeNode choice) {
        state.add(choice);
    }

    /* 恢复状态 */
    void undoChoice(List<TreeNode> state, TreeNode choice) {
        state.remove(state.size() - 1);
    }

    /* 回溯算法：例题三 */
    void backtrack(List<TreeNode> state, List<TreeNode> choices, List<List<TreeNode>> res) {
        // 检查是否为解
        if (isSolution(state)) {
            // 记录解
            recordSolution(state, res);
        }
        // 遍历所有选择
        for (TreeNode choice : choices) {
            // 剪枝：检查选择是否合法
            if (isValid(state, choice)) {
                // 尝试：做出选择，更新状态
                makeChoice(state, choice);
                // 进行下一轮选择
                backtrack(state, Arrays.asList(choice.left, choice.right), res);
                // 回退：撤销选择，恢复到之前的状态
                undoChoice(state, choice);
            }
        }
    }




}
