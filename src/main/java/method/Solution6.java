package method;

/**
 * @author Qbss
 * @date 2022/2/16
 * @desc
 */
public class Solution6 {


    public static int convert(String s, int numRows) {

        //int[] nums = new int[numRows];
        //
        //nums[0] = 1;
        //if (numRows > 1) {
        //    nums[1] = 1;
        //}
        //for (int i = 2; i < numRows; i++) {
        //    nums[i] = nums[i - 1] + nums[i - 2];
        //}

        int a = 1;
        int b = 1;
        int c = 2;

        if (numRows == 1 || numRows == 2) {
            return 1;
        }
        for (int i = 2; i < numRows; i++) {
            a = b;
            b = c;
            c = a + b;
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(convert("", 4));
    }
}
