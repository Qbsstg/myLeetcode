package method;

/**
 * @author: Qbss
 * @date: 2024/4/9
 * @desc:
 */
public class Solution2529 {

    public int maximumCount(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (num > 0) {
                a++;
            } else if (num < 0) {
                b++;
            }
        }
        return Math.max(a, b);
    }

}
