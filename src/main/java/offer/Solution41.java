package offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

public class Solution41 {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        //movingAverage.next(1);
    }

    static class MovingAverage {

        private LinkedList<Integer> queues;

        private int size;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            this.queues = new LinkedList<>();
        }

        public void insert(int val) {
            if (this.queues.size() == size) {
                this.queues.pollFirst();
            }
            this.queues.add(val);
        }

        public double next(int val) {
            insert(val);
            return this.queues.stream().reduce(Integer::sum).get() / (double) this.queues.size();
        }
    }

}
