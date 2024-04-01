package method;

/**
 * @author: Qbss
 * @date: 2024/4/1
 * @desc: 2810. 故障键盘
 */
public class Solution2810 {

    public String finalString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder stb = new StringBuilder();
        for (char c : charArray) {
            if (c == 'i') {
                stb.reverse();
            } else {
                stb.append(c);
            }
        }
        return stb.toString();
    }

    public static void main(String[] args) {
        StringBuilder stb = new StringBuilder();
        stb.append("a").append("b").append("c");
        stb.reverse();
        System.out.println(stb);
    }
}
