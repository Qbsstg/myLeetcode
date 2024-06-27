package method;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author: Qbss
 * @date: 2024/6/27
 * @desc:
 */
public class Solution2734 {

    public static void main(String[] args) {
        // System.out.println(smallestString("cbabc").equals("baabc"));
        // System.out.println(smallestString("acbbc").equals("abaab"));
        // System.out.println(smallestString("leetcode").equals("kddsbncd"));
        System.out.println(smallestString("aa").equals("az"));
        // System.out.println(Stream.of("aa", "az").sorted().toList());
    }

    // 找第一个不是'a'的字符，再找第二个'a'
    public static String smallestString(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, "a", true);
        List<String> list = new ArrayList<>();
        int aCount = 0;
        while (tokenizer.hasMoreTokens()) {
            String s1 = tokenizer.nextToken();
            if (s1.equals("a")) {
                aCount++;
            }
            list.add(s1);
        }

        if (aCount == list.size()){
            list.set(list.size()-1,"z");
            return String.join("",list);
        }

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("a")) {
                char[] charArray = list.get(i).toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    charArray[j] = (char) (charArray[j] - 1);
                }
                list.set(i, new String(charArray));
                break;
            }
        }
        return String.join("", list);
    }

}
