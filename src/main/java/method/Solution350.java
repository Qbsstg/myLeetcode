package method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/8/3
 * @desc
 */
public class Solution350 {


    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int j : nums1) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int j : nums2) {
            Integer integer = map.get(j);
            if (integer != null) {
                if (integer != 0) {
                    res.add(j);
                    int cal = integer - 1;
                    if (cal == 0) {
                        map.remove(j);
                    } else {
                        map.put(j, cal);
                    }
                } else {
                    map.remove(j);
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
