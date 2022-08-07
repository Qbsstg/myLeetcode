package method;

import java.util.HashMap;
import java.util.Map;


public class Solution383 {

    public static void main(String[] args) {
        canConstruct("aa","ab");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Integer integer = map.get(ransomNote.charAt(i));
            if (integer == null) {
                return false;
            } else {
                integer--;
                if (integer < 0){
                    return false;
                }else {
                    map.put(ransomNote.charAt(i),integer);
                }
            }
        }
        return true;
    }
}
