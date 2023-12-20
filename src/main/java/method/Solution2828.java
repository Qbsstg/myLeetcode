package method;

import java.util.List;

/**
 * @author: Qbss
 * @date: 2023/12/20
 * @desc: 判别首字母缩略词
 */
public class Solution2828 {


    public boolean isAcronym(List<String> words, String s) {

        if (words.isEmpty() || s == null || s.isEmpty()) {
            return false;
        }

        StringBuilder stb = new StringBuilder();

        for (String word : words) {
            stb.append(word.charAt(0));
        }

        return stb.toString().equals(s);
    }

}
