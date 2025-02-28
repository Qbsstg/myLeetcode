package method;

import java.util.*;

/**
 *@author Qbss
 *@date 2025/2/28 11:43
 *@desc TODO
 **/
public class Solution2506 {

    public int similarPairs(String[] words) {

        int count = 0;
        String[] flags = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            flags[i] = deal(words[i]);
        }

        for (int i = 0; i < flags.length; i++) {
            for (int j = i + 1; j < flags.length; j++) {
                if (flags[i].equals(flags[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static String deal(String str) {
        int[] arr = new int[26];
        str.chars().forEach(c -> arr[c - 'a'] = 1);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(sb::append);
        return sb.toString();
    }

}
