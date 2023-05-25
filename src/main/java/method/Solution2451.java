package method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qbss
 * @date 2023/5/25
 * @desc
 */
public class Solution2451 {


    public static void main(String[] args) {

        String[] words = {"abm", "bcn", "alm"};
        Map<String, List<String>> map = new HashMap<>();

        String result;

        for (String word : words) {
            String s = deal(word);

            List<String> orDefault = map.getOrDefault(s, new ArrayList<>());
            orDefault.add(word);
            map.put(s, orDefault);
        }

        result = map.entrySet().stream().filter(x -> x.getValue().size() == 1).findFirst().get().getValue().get(0);

        System.out.println(map);
        System.out.println(result);
    }

    private static String deal(String str) {

        char[] charArray = str.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < charArray.length; i++) {
            result.append(charArray[i] - charArray[i - 1]).append('_');
        }

        return String.valueOf(result);
    }

    public String oddString(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String s = deal(word);

            List<String> orDefault = map.getOrDefault(s, new ArrayList<>());
            orDefault.add(word);
            map.put(s, orDefault);
        }

        return map.entrySet().stream().filter(x -> x.getValue().size() == 1).findFirst().get().getValue().get(0);
    }

}
