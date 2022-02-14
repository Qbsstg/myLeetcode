package method;

/**
 * @author: Qbss
 * @date: 2021/3/25
 * @desc:
 */
public class Solution121 {


    public static void main(String[] args) {

        int[] ints = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(ints));


    }

    public static int maxProfit(int[] prices) {


        int min = prices[0];
        int length = 0;

        for (int i = 1; i < prices.length; i++) {
            int a = prices[i];
            if (min >= a) {
                min = a;
            }
            if (length <= prices[i] - min) {
                length = prices[i] - min;
            }

        }
        return length;
    }


}
