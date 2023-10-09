package method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Qbss
 * @date: 2023/10/8
 * @desc:
 */
public class Solution2034 {


    /**
     * Your StockPrice object will be instantiated and called as such:
     * StockPrice obj = new StockPrice();
     * obj.update(timestamp,price);
     * int param_2 = obj.current();
     * int param_3 = obj.maximum();
     * int param_4 = obj.minimum();
     */
    static class StockPrice {

        int now_time;

        int now_value;

        int max;

        int min;

        Map<Integer, Integer> map;

        public StockPrice() {
            this.map = new HashMap<>();
            now_time = 0;
            now_value = 0;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }

        public void update(int timestamp, int price) {
            //如果时间大于系统中当前时间，代表数据是最新的，更新时间
            if (timestamp > now_time) {
                now_time = timestamp;
                //更新当前最新的值
                this.now_value = price;
            }
            this.map.put(timestamp, price);

        }

        public int current() {
            return 1;
        }

        public int maximum() {
            return this.map.values().stream().max(Integer::compareTo).orElse(0);
        }

        public int minimum() {
            return this.map.values().stream().min(Integer::compareTo).orElse(0);
        }
    }


    public static void main(String[] args) {

        //[[],[1,10],[2,5],[],[],[1,3],[],[4,2],[]]
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());

    }


}
