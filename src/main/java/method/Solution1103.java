package method;

/**
 * @author: Qbss
 * @date: 2024/6/3
 * @desc:
 */
public class Solution1103 {


    public int[] distributeCandies(int candies, int num_people) {

        int[] ans = new int[num_people];
        int start = 0;

        while (candies > 0) {
            int i = start % num_people;
            int min = Math.min((start + 1), candies);
            ans[i] += min;
            candies -= min;
            start++;
        }
        return ans;
    }
}
