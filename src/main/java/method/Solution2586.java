package method;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Qbss
 * @date: 2023/11/7
 * @desc: 2586. 统计范围内的元音字符串数
 */
public class Solution2586 {


    private final Set<Integer> set = Stream.of(97, 101, 105, 111, 117).collect(Collectors.toCollection(HashSet::new));

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (set.contains(word.codePointAt(0)) && set.contains(word.codePointAt(word.length() - 1))) {
                count++;
            }
        }
        return count;
    }


}
