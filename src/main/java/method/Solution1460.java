package method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/8/24
 * @desc
 */
public class Solution1460 {

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                map.put(target[i], map.getOrDefault(target[i], 0) + 1);
                map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
                if (map.get(target[i]) == 0) {
                    map.remove(target[i]);
                }
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
            }
        }
        return map.isEmpty();
    }
}
