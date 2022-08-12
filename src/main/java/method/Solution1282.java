package method;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/8/12
 * @desc
 */
public class Solution1282 {

    public static void main(String[] args) {
        groupThePeople(new int[]{3,3,3,3,3,1,3});
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> orDefault = map.getOrDefault(groupSizes[i], new ArrayList<>());
            orDefault.add(i);
            map.put(groupSizes[i], orDefault);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> next : map.entrySet()) {
            Integer key = next.getKey();
            List<Integer> value = next.getValue();

            int size = 0;
            while (size < value.size()) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < key; i++) {
                    list.add(value.get(i + size));
                }
                res.add(list);
                size = size + key;
            }
        }
        return res;

    }

}
