package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/10/11
 * @desc
 */
public class Solution1790 {

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("attack", "defend"));
    }


    public static boolean areAlmostEqual(String s1, String s2) {

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < chars1.length; i++) {
            int a = chars1[i] ^ chars2[i];
            if (a != 0) {
                indexes.add(i);
            }
        }

        int size = indexes.size();
        if (size == 2) {
            return s1.charAt(indexes.get(0)) == s2.charAt(indexes.get(1)) && s1.charAt(indexes.get(1)) == s2.charAt(indexes.get(0));
        } else return size == 0;

    }


}
