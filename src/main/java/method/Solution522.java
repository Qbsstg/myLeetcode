package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2024/6/17
 * @desc:
 */
public class Solution522 {

    public static void main(String[] args) {
        String[] strs = {"aaa", "aaa", "aa"};
        String[] strs1 = {"aabbcc", "aabbcc", "cb", "abc"};
        String[] strs2 = {"abcabc", "abcabc", "abcabc", "abc", "abc", "cca"};
        String[] strs3 = {"abcabc", "abcabc", "abcabc", "abc", "abc", "bac"};
        // System.out.println(findLUSlength(strs1));
        // ["aabbcc", "aabbcc","cb","abc"]
        System.out.println(check("abc", "cb"));
        System.out.println(check("abcabc", "cca"));
        System.out.println(check("aabbcc", "abc"));
        System.out.println(check("abcabc", "bac"));
    }

    public static int findLUSlength(String[] strs) {
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String a = strs[i];
            for (int j = 0; j < strs.length; j++) {
                if (i != j) {
                    String b = strs[j];
                    if (check(b, a)) {
                        nums[i] = 1;
                        break;
                    }
                }
            }
        }
        if (Arrays.stream(nums).sum() == nums.length) {
            return -1;
        } else {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    max = Math.max(max, strs[i].length());
                }
            }
            return max;
        }
    }


    // 判断b是否为a的子序列
    private static boolean check(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        if (a.contains(b)) {
            return true;
        }

        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        if (b.length() > a.length()) {
            return false;
        }

        int slow = 0;
        int fast = slow;
        List<Integer> list = new ArrayList<>();
        for (slow = 0; slow < bCharArray.length; slow++) {
            for (; fast < aCharArray.length; fast++) {
                if (aCharArray[fast] == bCharArray[slow]){
                    list.add(1);
                    fast++;
                    break;
                }
            }
        }

        return list.size() == bCharArray.length;
    }

}
