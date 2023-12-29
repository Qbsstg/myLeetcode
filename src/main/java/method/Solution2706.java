package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2023/12/29
 * @desc: 购买两块巧克力
 */
public class Solution2706 {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices[0] + prices[1] > money) {
            return money;
        } else {
            return money - prices[0] - prices[1];
        }
    }

    public int buyChoco1(int[] prices, int money) {
        int sum = Arrays.stream(prices).sorted().limit(2).sum();
        return sum > money ? money : sum - money;
    }
}
