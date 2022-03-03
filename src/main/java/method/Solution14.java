package method;

/**
 * @author Qbss
 * @date 2022/3/2
 * @desc
 */
public class Solution14 {

    public static void main(String[] args) {

        String[] strs = {"flower", "flower", "flower"};
        System.out.println(longestCommonPrefix(strs));
        ;

    }

    //最大公共前缀
    public static String longestCommonPrefix(String[] strs) {

        String str = strs[0];
        if (strs.length == 1) {
            return str;
        }

        int length = str.length();

        String result = "";

        for (int i = 1; i <= length; i++) {
            String substring = str.substring(0, i);
            int j = 1;
            for (; j < strs.length; j++) {
                if (strs[j].startsWith(substring)) {
                    if (j == strs.length - 1) {
                        result = substring;
                    }
                } else {
                    break;
                }
            }
            if (j < strs.length - 1) {
                break;
            }
        }
        return result;
    }
}
