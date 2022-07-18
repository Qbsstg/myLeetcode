package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/7/18
 * @desc
 */
public class Solution6122 {


    public static void main(String[] args) {

        int[] nums = {2, 3, 2, 4, 3};
        //int[] nums = {2,3,2,4,3};
        int[] numsDivide = {9, 6, 9, 3, 15};
        //int[] numsDivide = {9, 6, 9, 3, 11};

        System.out.println(minOperations(nums, numsDivide));
    }

    public static int minOperations(int[] nums, int[] numsDivide) {

        int gcdNum = numsDivide[0];
        int[] ints = Arrays.stream(numsDivide).distinct().toArray();
        for (int i = 1; i < ints.length; i++) {
            if (!(ints[i] % ints[i - 1] == 0)) {
                gcdNum = Math.min(gcd(ints[i], ints[i - 1]), gcdNum);
            }
        }
        Arrays.sort(nums);

        if (nums[0] > gcdNum) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (gcdNum % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    private static int gcd1(int a, int b) {
        return b != 0 ? gcd1(b, a % b) : a;
    }
}
