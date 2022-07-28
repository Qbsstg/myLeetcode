package method;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/7/28
 * @desc
 */
public class Solution1331 {


    public int[] arrayRankTransform(int[] arr) {

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            List<Integer> orDefault = treeMap.getOrDefault(v, new ArrayList<>());
            orDefault.add(i);
            treeMap.put(v, orDefault);
        }

        Iterator<Map.Entry<Integer, List<Integer>>> iterator = treeMap.entrySet().iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            List<Integer> value = next.getValue();
            for (Integer integer : value) {
                arr[integer] = i;
            }
            i++;
        }
        return arr;
    }


}
