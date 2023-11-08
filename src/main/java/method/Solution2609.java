package method;

/**
 * @author: Qbss
 * @date: 2023/11/8
 * @desc:
 */
public class Solution2609 {

    public int findTheLongestBalancedSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = Integer.MIN_VALUE;
        char[] charArray = s.toCharArray();
        int slow = 0;

        int zeroCount = 0;
        int oneCount = 0;

        while (slow <= charArray.length - 1) {
            char a = charArray[slow];
            if (a == '0') {
                if (zeroCount != 0 && oneCount != 0) {
                    count = Math.max(count, Math.min(zeroCount, oneCount));
                    zeroCount = 0;
                    oneCount = 0;
                }
                zeroCount++;
            } else {
                if (zeroCount != 0) {
                    oneCount++;
                }
            }
            slow++;
        }


        return count;
    }

}
