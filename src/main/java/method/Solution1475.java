package method;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Qbss
 * @date 2022/8/31
 * @desc
 */
public class Solution1475 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(finalPrices(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(finalPrices(new int[]{10, 1, 1, 6})));
        System.out.println(Arrays.toString(finalPrices(new int[]{8, 7, 4, 2, 8, 1, 7, 7, 10, 1})));
    }


    public static int[] finalPrices(int[] prices) {
        if (prices.length == 1) {
            return prices;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[prices.length];
        System.arraycopy(prices, 0, res, 0, prices.length);

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (deque.isEmpty()) {
                deque.offer(i);
            } else {
                while (!deque.isEmpty()){
                    Integer peekFirst = deque.peekFirst();
                    Integer peekLast = deque.peekLast();

                    if (price <= prices[peekFirst]) {
                        res[peekFirst] = res[peekFirst] - price;
                        deque.pollFirst();
                    } else {
                        if (price <= prices[peekLast]) {
                            res[peekLast] = res[peekLast] - price;
                            deque.pollLast();
                        }else {
                            break;
                        }
                    }
                }

                deque.offer(i);

            }
        }
        return res;
    }

}
