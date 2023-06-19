package method;

import java.util.*;

public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> orDefault = map.getOrDefault(s, new ArrayList<>());
            orDefault.add(str);
            map.put(s, orDefault);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(new String(s.toCharArray()));
    }

}
