package method;

import java.util.*;

public class Solution1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                int diff = arr[i + 1] - arr[i];
                if (map.containsKey(diff)) {
                    map.get(diff).add(Arrays.asList(arr[i], arr[i + 1]));
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[i + 1]);
                    List<List<Integer>> lists = new ArrayList<>();
                    lists.add(list);
                    map.put(diff, lists);
                }
            }
        }
        return map.get(map.keySet().stream().sorted().findFirst().get());
    }

}
