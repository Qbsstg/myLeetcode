package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2021/3/28
 * @desc
 */
public class Solution228 {


    public static void main(String[] args) {
//        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
//        int[] nums = new int[]{0, 1, 3, 5};
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));

    }


    public static List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int j = i + 1;
            if (j < nums.length) {
                for (; j < nums.length; j++) {
                    int b = nums[j];
                    if (b == a + 1) {
                        if (j == nums.length - 1) {
                            String str = nums[i] + "->" + b;
                            result.add(str);
                            i = j;
                        }
                        a = b;
                    } else if (b > a + 1) {
                        String str;
                        if (nums[i] == nums[j - 1]) {
                            str = String.valueOf(nums[i]);
                        } else {
                            str = nums[i] + "->" + nums[j - 1];
                        }
                        result.add(str);
                        i = j;
                        i--;
                        break;
                    }
                }
            } else {
                result.add(String.valueOf(nums[nums.length - 1]));
            }
        }
        return result;
    }


}
