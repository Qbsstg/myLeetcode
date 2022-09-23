package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/9/23
 * @desc
 */
public class Solution707 {


    class MyLinkedList {

        private List<Integer> list;

        public MyLinkedList() {
            this.list = new ArrayList<>();
        }

        public int get(int index) {
            if (index < 0 || index >= this.list.size()) {
                return -1;
            }
            return this.list.get(index);
        }

        public void addAtHead(int val) {
            if (this.list.size() == 0) {
                this.list.add(val);
            } else {
                this.list.add(0, val);
            }
        }

        public void addAtTail(int val) {
            this.list.add(val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) {
                this.list.add(0, val);
            } else if (index == this.list.size()) {
                this.list.add(val);
            } else if (index < this.list.size()) {
                this.list.add(index, val);
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < this.list.size()) {
                this.list.remove(index);
            }
        }
    }

}
