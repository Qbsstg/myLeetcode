package method;

import java.util.Arrays;

/**
 *@author Qbss
 *@date 2025/2/13 16:04
 *@desc 1742. 盒子中小球的最大数量
 **/
public class Solution1742 {

    public int countBalls(int lowLimit, int highLimit) {

        int[] ans = new int[46];
        for (; lowLimit <= highLimit; lowLimit++) {
            ans[cal(lowLimit)]++;
        }
        return Arrays.stream(ans).max().getAsInt();
    }

    private static int cal(int a) {
        int total = 0;
        while (a >= 10) {
            total += a % 10;
            a = a / 10;
        }
        total += a;
        return total;
    }

}
