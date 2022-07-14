package method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/7/14
 * @desc
 */
public class Solution745 {


    private static String[] words = {};

    //WordFilter wordFilter = new WordFilter(words);
    //System.out.println(wordFilter.f("za", "a"));
    public static void main(String[] args) {
        System.out.println(words[7083]);
        System.out.println(words[4201]);
    }

    static class WordFilter {

        private Map<String, Integer> map = new HashMap<>();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int length = word.length();
                for (int j = 1; j <= length; j++) {
                    String startSub = word.substring(0, j);
                    for (int k = 1; k <= length; k++) {
                        String endSub = word.substring(length - k);
                        map.put(startSub + " " + endSub, i);
                    }
                }
            }

        }

        public int f(String pref, String suff) {
            return map.getOrDefault(pref + " " + suff, -1);

        }


    }


}
