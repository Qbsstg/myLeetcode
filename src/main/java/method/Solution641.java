package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/15
 * @desc
 */
public class Solution641 {

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertFront(8);
        myCircularDeque.insertLast(8);
        myCircularDeque.insertLast(2);

        myCircularDeque.getFront();
        myCircularDeque.deleteLast();
        myCircularDeque.getRear();
        myCircularDeque.insertFront(9);
        myCircularDeque.deleteFront();
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.isFull());
    }

    static class MyCircularDeque {

        private List<Integer> list;

        private int k;

        public MyCircularDeque(int k) {
            this.k = k;
            this.list = new ArrayList<>(k);
        }

        public boolean insertFront(int value) {
            if (this.list.size() < k) {
                this.list.add(0, value);
                return true;
            }
            return false;
        }

        public boolean insertLast(int value) {
            if (this.list.size() < k) {
                this.list.add(value);
                return true;
            }
            return false;
        }

        public boolean deleteFront() {
            if (!isEmpty()) {
                this.list = this.list.subList(1, this.list.size() - 1);
                return true;
            }
            return false;
        }

        public boolean deleteLast() {
            if (!isEmpty()) {
                this.list.remove(this.list.size() - 1);
                return true;
            }
            return false;
        }

        public int getFront() {
            if (!isEmpty()){
                return this.list.get(0);
            }
            return -1;
        }

        public int getRear() {
            if (!isEmpty()){
                return this.list.get(this.list.size()-1);
            }
            return -1;
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        public boolean isFull() {
            return this.list.size() == this.k;
        }
    }


}
