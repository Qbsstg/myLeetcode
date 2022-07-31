package method;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution6135 {

    public static void main(String[] args) {
        int[] edges = {3, 3, 4, 2, 3};
        int[] edges1 = {2, -1, 3, 1};
        System.out.println(longestCycle(edges));
        System.out.println(longestCycle(edges1));
    }

    public static int longestCycle(int[] edges) {

        int length = edges.length;
        boolean[] used = new boolean[length];

        int total = -1;

        for (int i = 0; i < edges.length; i++) {
            int index = i;

            if (edges[index] == -1) {
                if (!used[index]) {
                    used[index] = true;
                }
            } else {
                Map<Integer, Integer> map = new HashMap<>();
                int count = 0;
                while (edges[index] != -1) {
                    int edge = edges[index];
                    if (map.containsKey(edge)) {
                        Integer integer = map.get(edge);
                        total = Math.max(total, count - integer+2);
                        used[index] = true;
                        map.clear();
                        break;
                    } else {
                        if (used[index]) {
                            break;
                        } else {
                            count++;
                            map.put(index, count);
                            used[index] = true;
                            index = edge;
                        }
                    }
                }
            }
        }
        return total;

    }

}
