package contest.LCCUP;

import java.util.*;

public class Solution2 {
    public int transportationHub(int[][] path) {

        //p[0]->p[1]
        Map<Integer, List<Integer>> map = new HashMap<>();
        //p[1]
        Set<Integer> set = new HashSet<>();

        for (int[] p : path) {
            set.add(p[0]);
            set.add(p[1]);
        }

        int length = set.size();

        for (int[] p : path) {
            set.remove(p[0]);
            List<Integer> orDefault = map.getOrDefault(p[1], new ArrayList<>());
            orDefault.add(p[0]);
            map.put(p[1], orDefault);
        }

        if (set.size() != 0) {
            for (Integer next : set) {
                List<Integer> list = map.get(next);
                if (list.size() == length - 1) {
                    return next;
                }
            }
        }

        return -1;
    }
}
