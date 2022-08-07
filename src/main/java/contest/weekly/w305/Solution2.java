package contest.weekly.w305;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        int[][] nums = {{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}};
        //System.out.println(reachableNodes(10, nums, new int[]{2, 7}));
        System.out.println(reachableNodes(2, new int[][]{{0, 1}}, new int[]{1}));
        System.out.println(reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}},
                new int[]{4, 5}));
    }


    public static int reachableNodes(int n, int[][] edges, int[] restricted) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int j : restricted) {
            set.add(j);
        }
        for (int[] edge : edges) {
            if (set.contains(edge[0]) || set.contains(edge[1])) {
                continue;
            }

            Set<Integer> orDefault1 = map.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> orDefault2 = map.getOrDefault(edge[1], new HashSet<>());
            orDefault1.add(edge[1]);
            orDefault2.add(edge[0]);
            map.put(edge[0], orDefault1);
            map.put(edge[1], orDefault2);
        }


        Set<Integer> res = new HashSet<>();
        boolean[] used = new boolean[n];
        add(map, 0, res, used);
        res.remove(0);

        return res.size() + 1;

    }

    private static void add(Map<Integer, Set<Integer>> map, int a, Set<Integer> res,
                            boolean[] used) {
        Set<Integer> integers = map.get(a);
        if (integers != null) {
            used[a] = true;
            res.addAll(integers);
            for (Integer integer : integers) {
                if (!used[integer]) {
                    add(map, integer, res, used);
                }
            }
        }
    }
}
