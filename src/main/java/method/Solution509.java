package method;

/**
 * @author Qbss
 * @date 2021/3/31
 * @desc
 */
public class Solution509 {

    public static void main(String[] args) {
        //System.out.println(fib(5));
        //System.out.println(fb(5));
        System.out.println(f(5));

    }


    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fb(int n) {


        //暂存的概念
        int[] a = new int[n + 1];

        a[0] = 0;
        a[1] = 1;

        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public static int f(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int c = a + b;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }


}
