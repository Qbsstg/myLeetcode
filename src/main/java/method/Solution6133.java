package method;

import java.util.Arrays;

public class Solution6133 {

    public int maximumGroups(int[] grades) {

        int total = 1;

        Arrays.sort(grades);

        int preSum = grades[0];
        int count = 1;

        int nowCount = 0;
        int nowSum = 0;
        for (int i = 1; i < grades.length; i++) {
            nowCount++;
            nowSum = nowSum + grades[i];
            if (nowCount > count && nowSum > preSum) {
                count = nowCount;
                preSum = nowSum;

                nowCount = 0;
                nowSum = 0;

                total++;
            }
        }

        return total;
    }

}
