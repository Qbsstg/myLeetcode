package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2024/6/23
 * @desc:
 */
public class Solution520 {

    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int upperCount = 0;
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                upperCount++;
            }
        }
        if (upperCount == 0 || upperCount == chars.length) {
            return true;
        }
        return upperCount == 1 && Character.isUpperCase(chars[0]);

    }


}
