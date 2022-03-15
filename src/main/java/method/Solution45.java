package method;

/**
 * @author Qbss
 * @date 2022/3/10
 * @desc
 */
public class Solution45 {


    public int jump(int[] nums) {

        int m = nums[0];
        int count = 1;


        for (int i = 0; i < nums.length; i++) {

            m = nums[i] + i;
            if (m >= nums.length - 1) {
                return count;
            } else {
                //for (int j = i; j <100; j++) {
                //    b
                //}
            }
        }

        return 1;

    }

}
