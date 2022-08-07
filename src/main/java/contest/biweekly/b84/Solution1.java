package contest.biweekly.b84;

import java.util.*;

public class Solution1 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map1 = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();

        for (int i = 0; i < items1.length; i++) {
            int[] ints = items1[i];
            map1.put(ints[0], ints[1]);
        }

        for (int i = 0; i < items2.length; i++) {
            int[] ints = items2[i];
            map2.put(ints[0], ints[1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            Integer integer = map2.get(key);
            if (integer != null) {
                value = integer + value;
                map2.remove(key);
                map1.put(key,value);
            }
        }
        map1.putAll(map2);
        Iterator<Map.Entry<Integer, Integer>> iterator1 =
                map1.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<Integer, Integer> next = iterator1.next();
            res.add(Arrays.asList(next.getKey(),next.getValue()));
        }
return res;
    }
}
