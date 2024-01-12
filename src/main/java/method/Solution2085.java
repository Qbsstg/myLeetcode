package method;

import java.util.Map;

/**
 * @author: Qbss
 * @date: 2024/1/12
 * @desc:
 */
public class Solution2085 {

    public int countWords(String[] words1, String[] words2) {

        Map<String, Integer> map = new java.util.HashMap<>();
        for (String s : words1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : words2) {
            Integer i = map.get(s);
            if (i != null) {
                if (i == 1) {
                    map.put(s, 0);
                } else if (i == 0) {
                    map.put(s, -1);
                }
            }
        }

        return Math.toIntExact(map.values().stream().filter(x->x.equals(0)).count());

    }
}
