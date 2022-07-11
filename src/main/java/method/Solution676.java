package method;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Qbss
 * @date 2022/7/11
 * @desc
 */
public class Solution676 {


    static class MagicDictionary {

        private Set<String> magicString;

        public MagicDictionary() {
            this.magicString = new HashSet<>();
        }

        public void buildDict(String[] dictionary) {
            magicString = Arrays.stream(dictionary).collect(Collectors.toSet());
        }

        public boolean search(String searchWord) {
            if (this.magicString == null) {
                return false;
            } else {
                for (String s : this.magicString) {
                    if (checkEquals(s, searchWord)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static boolean checkEquals(String a, String b) {
        if (a.length() != b.length() || a.equals(b)) {
            return false;
        } else {
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
       MagicDictionary magicDictionary = new MagicDictionary();
       magicDictionary.buildDict(new String[]{"hello", "leetcode"});
       magicDictionary.search("hello");
       magicDictionary.search("hhllo");
       magicDictionary.search("hell");
       magicDictionary.search("leetcode");

    }

}
