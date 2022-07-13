package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2021/3/26
 * @desc: 测试下提交
 */
public class Solution167 {


    public static void main(String[] args) {
        int[] ints = new int[]{-1,0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(ints, target)));
    }


    public static int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
                if (numbers[j] > target) {
                    break;
                }
            }
        }
        return result;
    }


}
