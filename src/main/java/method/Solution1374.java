package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/8/1
 * @desc
 */
public class Solution1374 {

    public static void main(String[] args) {
        System.out.println(generateTheString(2));
    }


    public static String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        if (n % 2 == 0) {
            chars[n - 1] = 'b';
        }
        return new String(chars);
    }
}
