package method;

import java.util.*;

public class Solution567 {

    public static void main(String[] args) {

        checkInclusion("hello", "ooolleoooleh");

    }

    public static boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            characterIntegerMap.put(s1.charAt(i), characterIntegerMap.getOrDefault(s1.charAt(i),
                    0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            if (i + s1.length() > s2.length()) {
                return false;
            } else {
                String substring = s2.substring(i, i + s1.length());
                if (check(characterIntegerMap, substring)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean checkInclusion1(String s1, String s2) {

        Map<Character, Integer> map = new HashMap<>();
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) {
            return false;
        }

        for (int i = 0; i < l1; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }

        int diff = map.values().stream().map(Math::abs).reduce(Integer::sum).orElse(0);
        int i = 0;
        while (diff != 0 && l1 < l2) {
            char end = s2.charAt(l1+i);
            char first = s2.charAt(i);

            if (first != end) {
                Integer firstValue = map.get(first);
                Integer endValue = map.get(end);

                if (endValue == null) {
                    diff++;
                } else {
                    if (endValue > 0) {
                        diff--;
                    } else {
                        diff++;
                    }
                }

                if (firstValue == null){
                    diff++;
                }else {
                    if (firstValue > 0) {
                        diff++;
                    } else {
                        diff--;
                    }
                }

            }
            i++;
        }
        return diff == 0;
    }

    private static boolean check(Map<Character, Integer> characterIntegerMap, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> next : characterIntegerMap.entrySet()) {
            if (!(Objects.equals(map.get(next.getKey()), next.getValue()))) {
                return false;
            }
        }
        return true;
    }
}
