package method;

import java.util.Arrays;

public class Solution53 {

    /*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    示例:
    输入: [-2,1,-3,4,-1,2,1,-5,4]
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    进阶:
    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-subarray
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp <= 0) {
                max = Math.max(max, temp);
            } else {
                max = Math.max(max, temp);
                i++;
                for (; i < nums.length; i++) {
                    temp += nums[i];
                    if (temp > 0) {
                        max = Math.max(max, temp);
                    } else {
                        break;
                    }
                }
            }
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {

        int length = nums.length;
        int[] sum = new int[length];
        sum[0] = nums[0];

        for (int i = 1; i < length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
        }
        Arrays.sort(sum);
        return sum[length - 1];
    }


    public static void main(String[] args) {
        Solution53 Solution53 = new Solution53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Solution53.maxSubArray1(nums));
    }

}
