package method;

/**
 * @author Qbss
 * @date 2021/3/31
 * @desc
 */
public class Solution70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }


    public static int climbStairs(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int a = 1;
        int b = 2;
        int c = 0;

        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


}
