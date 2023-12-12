package method;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Qbss
 * @date: 2023/12/12
 * @desc:
 */
public class Solution2423 {

    public static boolean equalFrequency(String word) {
        int[] nums = new int[26];
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            nums[c - 'a']++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                continue;
            }
            nums[i] --;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (num > 0){
                    set.add(num);
                }
            }
            if (set.size() == 1){
                return true;
            }
            nums[i]++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(equalFrequency("ddaccb"));
    }
}
