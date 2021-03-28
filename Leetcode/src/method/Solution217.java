package method;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qbss
 * @date 2021/3/27
 * @desc
 */
public class Solution217 {


    public boolean containsDuplicate(int[] nums) {
//        int a = nums[0];
//        int count = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//
//            if (a == nums[i]) {
//                return true;
//            } else {
//
//            }
//
//
//        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;


    }


}
