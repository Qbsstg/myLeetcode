package method;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    public static void main(String[] args) {
        lengthOfLongestSubstring1("abcc");
    }

    public static int lengthOfLongestSubstring(String s) {

        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < length; ) {
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i), i);
            int j = i + 1;
            for (; j < length; j++) {
                char s1 = s.charAt(j);
                if (map.containsKey(s1)) {
                    i = map.get(s1) + 1;
                    break;
                } else {
                    map.put(s1, j);
                }
            }
            count = Math.max(count, map.size());
            if (j >= length) {
                break;
            }
        }
        return count;
    }

    public static int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


}
