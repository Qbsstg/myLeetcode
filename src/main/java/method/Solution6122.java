package method;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/7/18
 * @desc
 */
public class Solution6122 {


    public static void main(String[] args) {
        Object o = new Object();

        int[] nums = {2, 3, 2, 4, 3};
        //int[] nums = {2,3,2,4,3};
        int[] numsDivide = {9, 6, 9, 3, 15};
        //int[] numsDivide = {9, 6, 9, 3, 11};

        //System.out.println(minOperations(nums, numsDivide));

        checkDepth("[1,[2,3],[1,4,[5]]]");
    }



    class Main {
        public void checkDepth(String str) {
            String[] split = str.split("");
            int depth = 0;
            int max = 0;

            for (String s : split) {
                if (s.equals("[")) {
                    depth++;
                    max = Math.max(max, depth);
                } else if (s.equals("]")) {
                    depth--;
                }
            }
            System.out.println(max);
        }
    }


    private static void checkDepth(String str) {
        String[] split = str.split("");

        int depth = 0;
        int max = 0;
        for (String s : split) {
            if (s.equals("[")) {
                depth++;
                max = Math.max(depth, max);
            } else if (s.equals("]")) {
                depth--;
            }
        }
        System.out.println(max);
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
