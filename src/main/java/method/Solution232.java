package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/9
 * @desc
 */
public class Solution232 {


    static class MyQueue {

        private List<Integer> list;

        public MyQueue() {
            this.list = new ArrayList<>();
        }

        public void push(int x) {
            this.list.add(x);
        }

        public int pop() {
            if (this.empty()) {
                throw new NullPointerException();
            } else {
                int res = this.list.get(0);
                this.list = this.list.subList(1, this.list.size());
                return res;
            }
        }

        public int peek() {
            if (this.empty()) {
                throw new NullPointerException();
            } else {
                return this.list.get(0);
            }
        }

        public boolean empty() {
            return this.list.isEmpty();
        }
    }

}
