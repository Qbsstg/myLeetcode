package method;

import java.util.HashSet;
import java.util.Set;

public class Solution387 {

    //重复

    public int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        Set<Character> repeatSet = new HashSet<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!set.add(aChar)) {
                repeatSet.add(aChar);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (!repeatSet.contains(chars[i])){
                return i;
            }
        }
        return -1;
    }

}
