package method;

import java.util.HashSet;
import java.util.Set;

public class Solution2062 {

    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("cuaieuouac"));
        System.out.println(countVowelSubstrings("aeiouu"));
    }

    public static int countVowelSubstrings(String word) {

        char[] chars = word.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
            if (set.size() >= 5) {
                break;
            }
        }
        if (set.size() < 5) {
            return 0;
        }

        set.clear();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int count = 0;
        Set<Character> ans = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (set.contains(aChar)) {
                ans.add(aChar);
                for (int j = i + 1; j < chars.length; j++) {
                    char bChar = chars[j];
                    if (set.contains(bChar)){
                        ans.add(bChar);
                        if (ans.size() == 5) {
                            count++;
                        }
                    }else {
                        break;
                    }
                }
                ans.clear();
            }
        }
        return count;
    }


}
