package method;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Qbss
 * @date 2022/9/19
 * @desc
 */
public class Solution1636 {


    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> data = new HashMap<>();
        int[] res = new int[nums.length];

        for (int num : nums) {
            data.put(num, data.getOrDefault(num, 0) + 1);
        }

        Map<Integer, TreeSet<Integer>> map = new TreeMap<>();

        data.forEach((key, value) -> {
            TreeSet<Integer> orDefault = map.getOrDefault(value, new TreeSet<>((o1, o2) -> o2 - o1));
            orDefault.add(key);
            map.put(value, orDefault);
        });


        int k = 0;

        for (Map.Entry<Integer, TreeSet<Integer>> next : map.entrySet()) {
            TreeSet<Integer> value = next.getValue();
            for (Integer next1 : value) {
                for (int i = 0; i < next.getKey(); i++) {
                    res[k] = next1;
                    k++;
                }
            }
        }

        return res;

    }

}
