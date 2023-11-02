package method;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Qbss
 * @date: 2023/11/2
 * @desc:
 */
public class Solution2013 {

    //B0B6G0R6R0R6G9
    public static int countPoints(String rings) {

        int count = 0;
        Map<Integer, Set<String>> map = new HashMap<>();
        String[] charArray = rings.split("");
        for (int i = 1; i < charArray.length; i = i + 2) {
            int num = Integer.parseInt(charArray[i]);
            String color = charArray[i - 1];
            Set<String> set = map.get(num);
            if (set == null) {
                set = new HashSet<>();
                set.add(color);
                map.put(num, set);
            } else {
                if (set.size() != 3) {
                    set.add(color);
                    if (set.size() == 3) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }

}
