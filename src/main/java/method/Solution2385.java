package method;

import common.TreeNode;

import java.util.*;

/**
 * @author: Qbss
 * @date: 2024/4/24
 * @desc:
 */
public class Solution2385 {

    public int amountOfTime(TreeNode root, int start) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        dfsNew(map, root);

        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        set.add(start);
        int time = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nodeVal = poll[0];
            time = poll[1];

            for (Integer i : map.get(nodeVal)) {
                if (set.add(i)) {
                    queue.offer(new int[]{i, time + 1});
                }
            }
        }

        return time;
    }

    private void dfsNew(Map<Integer, List<Integer>> map, TreeNode root) {
        map.putIfAbsent(root.val, new ArrayList<>());
        for (TreeNode child : Arrays.asList(root.left, root.right)) {
            if (child != null){
                map.get(root.val).add(child.val);
                map.putIfAbsent(child.val, new ArrayList<>());
                map.get(child.val).add(root.val);
                dfsNew(map, child);
            }
        }
    }

    static Graph g = new Graph();

    static class Graph {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        void addEdge(int u, int v) {
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        void printGraph() {
            for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }


    static void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            g.addEdge(root.val, parent.val);
        }
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        dfs(root, null);
        g.printGraph();
    }

}
