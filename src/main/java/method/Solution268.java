package method;

/**
 * @author Qbss
 * @date 2021/3/28
 * @desc
 */
public class Solution268 {

    public int missingNumber(int[] nums) {

        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length + 1; i++) {
            sum += i;
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return sum - total;
    }


}
