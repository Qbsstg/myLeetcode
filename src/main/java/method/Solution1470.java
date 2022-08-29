package method;

/**
 * @author Qbss
 * @date 2022/8/29
 * @desc
 */
public class Solution1470 {


    public int[] shuffle(int[] nums, int n) {


        int[] res = new int[n << 1];
        for (int i = 0; i < n; i++) {
            res[i << 1] = nums[i];
        }
        for (int i = n; i < nums.length; i++) {
            res[((i - n) << 1) + 1] = nums[i];
        }
        return res;
    }


}
