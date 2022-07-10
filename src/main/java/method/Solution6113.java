package method;

import java.util.HashSet;
import java.util.Set;

public class Solution6113 {

    class SmallestInfiniteSet {

        private Set<Integer> set = new HashSet<>();

        public SmallestInfiniteSet() {
            for (int i = 1; i < 10000; i++) {
                set.add(i);
            }
        }

        public int popSmallest() {
            Integer integer = set.stream().findFirst().orElse(1);
            set.remove(integer);
            return integer;
        }

        public void addBack(int num) {
            set.add(num);
        }
    }

}
