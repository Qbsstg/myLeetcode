package method;

/**
 * @author: Qbss
 * @date: 2024/6/17
 * @desc:
 */
public class Solution521 {

    public int findLUSlength(String a, String b) {
        return a.equals(b)?-1:Math.max(a.length(),b.length());
    }
}
