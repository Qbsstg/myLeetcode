package method;

import java.util.ArrayDeque;

/**
 * @author: Qbss
 * @date: 2023/10/7
 * @desc:
 */
public class Solution901 {


    static class StockSpanner {

        private ArrayDeque<stock> stocks;

        static class stock {
            int num;

            int value;

            public stock(int num, int value) {
                this.num = num;
                this.value = value;
            }
        }

        public StockSpanner() {
            this.stocks = new ArrayDeque<>();
        }

        public int next(int price) {
            stock stock = new stock(1, price);
            if (this.stocks.isEmpty()) {
                this.stocks.add(stock);
                return 1;
            } else {
                //维护一个单调栈
                while (!this.stocks.isEmpty()) {
                    //队尾的元素
                    stock peekLast = this.stocks.peekLast();
                    if (peekLast.value > price) {
                        this.stocks.addLast(stock);
                        break;
                    } else if (peekLast.value == price) {
                        this.stocks.pollLast();
                        stock.num += peekLast.num;
                        this.stocks.addLast(stock);
                        break;
                    } else {
                        this.stocks.pollLast();
                        stock.num += peekLast.num;
                        if (this.stocks.isEmpty()) {
                            this.stocks.addLast(stock);
                            break;
                        }
                    }
                }
            }
            return stock.num;
        }
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        //System.out.println(stockSpanner.next(100));//1
        //System.out.println(stockSpanner.next(80));//1
        //System.out.println(stockSpanner.next(60));//1
        //System.out.println(stockSpanner.next(70));//2
        //System.out.println(stockSpanner.next(60));//1 = 2
        //System.out.println(stockSpanner.next(75));//4
        //System.out.println(stockSpanner.next(85));//6

        //System.out.println(stockSpanner.next(31));
        //System.out.println(stockSpanner.next(41));
        //System.out.println(stockSpanner.next(48));
        //System.out.println(stockSpanner.next(59));
        //System.out.println(stockSpanner.next(79));

        //[[],[28],[14],[28],[35],[46],[53],[66],[80],[87],[88]]
        //System.out.println(stockSpanner.next(28));
        //System.out.println(stockSpanner.next(14));
        //System.out.println(stockSpanner.next(28));
        //System.out.println(stockSpanner.next(35));
        //System.out.println(stockSpanner.next(46));
        //System.out.println(stockSpanner.next(53));
        //System.out.println(stockSpanner.next(66));
        //System.out.println(stockSpanner.next(80));
        //System.out.println(stockSpanner.next(87));
        //System.out.println(stockSpanner.next(88));

        //[[],[1],[79],[34],[21],[34],[16],[59],[63],[72],[5]]
        System.out.println(stockSpanner.next(1));
        System.out.println(stockSpanner.next(79));
        System.out.println(stockSpanner.next(34));
        System.out.println(stockSpanner.next(21));
        System.out.println(stockSpanner.next(34));
        System.out.println(stockSpanner.next(16));
        System.out.println(stockSpanner.next(59));
        System.out.println(stockSpanner.next(63));
        System.out.println(stockSpanner.next(72));
        System.out.println(stockSpanner.next(5));
    }

}
