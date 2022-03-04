package method;

/**
 * @author Qbss
 * @date 2022/3/3
 * @desc
 */
public class Solution1137 {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tri(4));
        System.out.println(t(4));
    }

    public static int tribonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        } else if (n == 2) {
            return 1;
        } else {
            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
    }

    public static int tri(int n) {

        int[] a = new int[n + 1];

        a[0] = 0;
        a[1] = 1;
        a[2] = 1;

        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }

        return a[n];
    }

    public static int t(int n) {

        int a = 0;
        int b = 1;
        int c = 1;

        int d = 0;
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        for (int i = 3; i <= n; i++) {
            d = a + b + c;

            a = b;
            b = c;
            c = d;

        }
        return d;
    }


}
