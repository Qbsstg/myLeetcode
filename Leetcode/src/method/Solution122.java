package method;

/**
 * @author: Qbss
 * @date: 2021/3/26
 * @desc:
 */
public class Solution122 {

    public static void main(String[] args) {
        int[] ints = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(ints));
    }


    public static int maxProfit(int[] prices) {

        int result = 0;
        int min = prices[0];
        int max = prices[0];

        for (int i = 0; i < prices.length; i++) {

            if (max > prices[i]) {
                result += max - min;
                min = prices[i];
                max = prices[i];
                continue;
            }
            if (min >= prices[i]) {
                min = prices[i];
                max = prices[i];
                continue;
            }
            if (max <= prices[i]) {
                max = prices[i];
                if (i == prices.length - 1) {
                    result += max - min;
                }
            }

        }
        return result;
    }


}
