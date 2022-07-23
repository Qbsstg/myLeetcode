package method;

import java.util.*;
import java.util.stream.Collectors;

public class Solution6128 {

    public String bestHand(int[] ranks, char[] suits) {

        Set<Character> set = new HashSet<>();
        for (char suit : suits) {
            set.add(suit);
        }
        if (set.size() == 1) {
            return "Flush";
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        List<Integer> collect = map.values().stream().filter(v -> v >= 3).collect(Collectors.toList());
        if (collect.size() > 0){
            return "Three of a Kind";
        }
        List<Integer> collect1 = map.values().stream().filter(v -> v >= 2).collect(Collectors.toList());
        if (collect1.size()>0){
            return "Pair";
        }
        if (map.size() == 5){
            return "High Card";
        }
        return "";

    }

}
