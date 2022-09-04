package contest.weekly.w309;

import java.util.Arrays;

public class Solution1 {


    public boolean checkDistances(String s, int[] distance) {

        char[] chars = s.toCharArray();
        int[] ans = new int[26];
        Arrays.fill(ans, -1);
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int dis = aChar - 'a';
            if (ans[dis] == -1) {
                ans[dis] = i;
            } else {
                int ance = i - ans[dis] - 1;
                if (distance[dis] != ance) {
                    return false;
                }
            }
        }

        return true;
    }
}
