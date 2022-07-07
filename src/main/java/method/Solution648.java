package method;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Qbss
 * @date 2022/7/7
 * @desc
 */
public class Solution648 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(list, sentence));
    }


    //public static String replaceWords(List<String> dictionary, String sentence) {
    //
    //    String[] s = sentence.split(" ");
    //    for (int i = 0; i < s.length; i++) {
    //        for (String value : dictionary) {
    //            if (s[i].startsWith(value)) {
    //                s[i] = value;
    //            }
    //        }
    //    }
    //    return String.join(" ", s);
    //}

    public static String replaceWords(List<String> dictionary, String sentence) {

        String[] s = sentence.split(" ");

        Set<String> collect = new HashSet<>(dictionary);

        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            for (int j = 0; j < str.length(); j++) {
                if (collect.contains(str.substring(0, j + 1))) {
                    s[i] = str.substring(0, j + 1);
                    break;
                }
            }
        }
        return String.join(" ", s);
    }

}
