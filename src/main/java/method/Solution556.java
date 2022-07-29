package method;

/**
 * @author Qbss
 * @date 2022/7/28
 * @desc
 */
public class Solution556 {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(123));
    }


    public static int nextGreaterElement(int n) {

        if (n <= 11) {
            return -1;
        }

        String s = String.valueOf(n);
        int res = -1;
        for (int i = s.length() - 2; i >= 0; i--) {
            char c = s.charAt(i);
            char charAt = s.charAt(i + 1);
            if (c < charAt) {

                




                break;
            }
        }
        return res;
    }
}
