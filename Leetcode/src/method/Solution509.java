package method;

/**
 * @author Qbss
 * @date 2021/3/31
 * @desc
 */
public class Solution509 {

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fb(6));
    }


    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        if (n >= 2) {
            return fib(n - 1) + fib(n - 2);
        }
        return 0;
    }

    public static int fb(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i < n + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
