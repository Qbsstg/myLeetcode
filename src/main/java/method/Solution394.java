package method;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: Qbss
 * @date: 2024/1/8
 * @desc: 字符串解码
 */
public class Solution394 {

    // "abc3[cd]xyz"
    // "3[a2[c]]"
    public static String decodeString(String s) {
        StringBuilder stb = new StringBuilder();
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c <= 'z' && c >= 'a') {
                stb.append(c);
            } else if (c <= '9' && c >= '0') {
                int fast = i;
                StringBuilder num = new StringBuilder();
                StringBuilder sValue = new StringBuilder();
                for (; fast < length; fast++) {
                    char fastValue = charArray[fast];
                    if (fastValue <= 'z' && fastValue >= 'a') {
                        sValue.append(fastValue);
                    } else if (fastValue <= '9' && fastValue >= '0') {
                        num.append(fastValue);
                    } else if (fastValue == ']') {
                        break;
                    }
                }
                i = fast;
                int numValue = Integer.parseInt(num.toString());
                stb.append(String.valueOf(sValue).repeat(Math.max(0, numValue)));
            }
        }
        return stb.toString();
    }

    public static String decodeString1(String s) {
        Queue<CharSequence> queue = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= 'a' && c <= 'z') {
                stb.append(c);
            } else if (c >= '0' && c <= '9') {
                    int fast = i;

            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("abc3[cd]xyz"));
    }

}
