package method;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Qbss
 * @date: 2023/11/7
 * @desc: 2586. 统计范围内的元音字符串数
 */
public class Solution2586 {

    public int vowelStrings(String[] words, int left, int right) {
        Set<String> set = Stream.of("a", "e", "i", "o", "u").collect(Collectors.toSet());
        int count = 0;
        for (String word : words) {
            String[] split = word.split("");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                for (int j = i; j < length; j++) {
                    String[] sub = Arrays.copyOfRange(split, i, j + 1);
                    String s = String.join("", sub);
                    if (set.contains(s)) {
                        count++;
                    }
                }
            }
        }
        return count;



    }


}
