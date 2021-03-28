package method;

import java.util.Arrays;

public class Solution66 {

    /*
    给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例 1:

    输入: [1,2,3]
    输出: [1,2,4]
    解释: 输入数组表示数字 123。
    示例 2:

    输入: [4,3,2,1]
    输出: [4,3,2,2]
    解释: 输入数组表示数字 4321。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/plus-one
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        * */

    public int[] plusOne(int[] digits) {

        int[] reNums = new int[digits.length + 1];

        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            reNums[i+1] = (digits[i] + temp) % 10;
            temp = (digits[i] + temp) / 10;
            if (i == 0) {
                if (temp == 1 && digits[0] + temp > 9){
                    reNums[0] = 1;
                }else {
                    for (int j = 0; j < reNums.length-1; j++) {
                        reNums[j] = reNums[j+1];
                    }
                    reNums = Arrays.stream(reNums).limit(digits.length).toArray();
                }
            }
        }
        return reNums;
    }

    public static void main(String[] args) {
        Solution66 Solution66
                 = new Solution66();
        int [] nums = {9,9,9};
        System.out.println(Arrays.toString(Solution66.plusOne(nums)));
    }
}