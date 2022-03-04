package method;

/**
 * @author Qbss
 * @date 2022/3/4
 * @desc
 */
public class Solution746 {

    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(min(cost2));
        ;
    }

    public static int minCostClimbingStairs(int[] cost) {

        int[] a = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {

            a[i] = Math.min(a[i - 1] + cost[i - 1], a[i - 2] + cost[i - 2]);
        }

        return a[cost.length];

    }

    public static int min(int[] cost) {

        int a = 0;
        int b = 0;
        int n = cost.length;

        for (int i = 2; i <= n; i++) {
            int next = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = next;
        }

        return b;




    }

}
