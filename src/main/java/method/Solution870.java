package method;

import java.util.TreeMap;

/**
 * @author Qbss
 * @date 2022/10/8
 * @desc
 */
public class Solution870 {



    /*
     *
     * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
     * 输出：[2,11,7,15]
     *
     * */
    public int[] advantageCount(int[] nums1, int[] nums2) {


        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int j : nums1) {
            treeMap.put(j, treeMap.getOrDefault(j, 0) + 1);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            int a = nums2[i];
            Integer integer = treeMap.higherKey(a);
            if (integer == null) {
                Integer firstKey = treeMap.firstKey();
                if (firstKey != null) {
                    Integer firstValue = treeMap.get(firstKey);
                    result[i] = firstKey;
                    if (firstValue == 1) {
                        treeMap.remove(firstKey);
                    } else {
                        treeMap.put(firstKey, firstValue - 1);
                    }
                }

            } else {
                Integer key = treeMap.get(integer);
                result[i] = integer;
                if (key == 1) {
                    treeMap.remove(integer);
                } else {
                    treeMap.put(integer, key - 1);
                }
            }

        }


        return result;
    }

}
