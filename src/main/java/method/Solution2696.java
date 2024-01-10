package method;

/**
 * @author: Qbss
 * @date: 2024/1/10
 * @desc:
 */
public class Solution2696 {

    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "").replace("CD", "");
        }
        return s.length();
    }

}
