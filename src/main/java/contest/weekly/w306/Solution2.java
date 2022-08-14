package contest.weekly.w306;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {

    public static void main(String[] args) {
        //System.out.println(edgeScore1(new int[]{1, 0, 0, 0, 0, 7, 7, 5}));
        //System.out.println(edgeScore1(new int[]{2, 0, 0, 2}));
        System.out.println(edgeScore1(new int[]{100000,1}));
    }

    public static int edgeScore(int[] edges) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            Integer orDefault = map.getOrDefault(edges[i], 0);
            map.put(edges[i], orDefault + i);
        }

        Map<Integer, List<Integer>> sortMap = new TreeMap<>((o1, o2) -> o1.compareTo(o2) * -1);
        for (Map.Entry<Integer, Integer> next : map.entrySet()) {
            Integer key = next.getKey();
            Integer value = next.getValue();

            List<Integer> orDefault = sortMap.getOrDefault(value, new ArrayList<>());
            orDefault.add(key);
            sortMap.put(value, orDefault);
        }

        Map.Entry<Integer, List<Integer>> integerListEntry = sortMap.entrySet().stream().findFirst().get();
        List<Integer> collect = integerListEntry.getValue().stream().sorted().collect(Collectors.toList());
        return collect.get(0);
    }

    public static int edgeScore1(int[] edges) {
        long[] res = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            res[edges[i]] = res[edges[i]] + i;
        }
        long max = Arrays.stream(res).max().getAsLong();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == max){
                return i;
            }
        }
        return -1;
    }

}
