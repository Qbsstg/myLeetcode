package method;

import java.util.List;

/**
 * @author Qbss
 * @date 2021/3/30
 * @desc
 */
public class Solution448 {


    public List<Integer> findDisappearedNumbers(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }


    }


}
