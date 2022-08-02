package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/2
 * @desc
 */
public class Solution622 {


    public static void main(String[] args) {


        MyCircularQueue myCircularQueue = new MyCircularQueue(8);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(9);
        myCircularQueue.enQueue(5);
        myCircularQueue.enQueue(0);
        myCircularQueue.deQueue();
        myCircularQueue.deQueue();
        myCircularQueue.isEmpty();
        myCircularQueue.isEmpty();
        myCircularQueue.Rear();
        myCircularQueue.Rear();
        myCircularQueue.deQueue();

    }


    static class MyCircularQueue {

        private List<Integer> list;

        private int k;

        public MyCircularQueue(int k) {
            this.list = new ArrayList<>(k);
            this.k = k;
        }

        public boolean enQueue(int value) {
            if (this.list.size() >= this.k) {
                return false;
            } else {
                this.list.add(value);
                return true;
            }
        }

        public boolean deQueue() {
            if (this.list.isEmpty()) {
                return false;
            } else {
                this.list = this.list.subList(1, this.list.size());
                return true;
            }

        }

        public int Front() {
            if (this.list.isEmpty()) {
                return -1;
            } else {
                return this.list.get(0);
            }
        }

        public int Rear() {
            if (this.list.isEmpty()) {
                return -1;
            } else {
                return this.list.get(this.list.size() - 1);
            }
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        public boolean isFull() {
            return this.list.size() == k;
        }
    }

}
