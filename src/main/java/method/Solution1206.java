package method;

/**
 * @author Qbss
 * @date 2022/7/26
 * @desc
 */
public class Solution1206 {


    class Skiplist {

        private skipListNode root;

        public Skiplist() {
            this.root = new skipListNode();
        }

        public boolean search(int target) {

            skipListNode next = root.next;
            if (next == null) {
                return target == root.val;
            } else {
                skipListNode index = root;
                while (next != null) {
                    if (next.val == target) {
                        return true;
                    } else if (next.val < target) {
                        index = index.next;
                        next = next.next;
                    } else {
                        break;
                    }
                }

                index = index.index;
                next = index.next;

                while (index != null) {
                    while (next != null) {
                        if (next.val == target) {
                            return true;
                        } else if (next.val < target) {
                            index = index.next;
                            next = next.next;
                        } else {
                            break;
                        }
                    }
                    index = index.index;
                    next = index.next;
                }
                if (index == null) {
                    return false;
                }
            }
            return false;
        }

        public void add(int num) {

        }

        public boolean erase(int num) {
            return false;
        }
    }


    class skipListNode {

        public skipListNode next;

        public int val;

        public skipListNode index;

        public skipListNode() {

        }
    }


}
