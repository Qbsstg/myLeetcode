package method;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution6124 {

    public char repeatedCharacter(String s) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.add(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return 0;
    }

}
