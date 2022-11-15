package method;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Qbss
 * @date 2022/11/15
 * @desc
 */
public class Solution380 {


    static class RandomizedSet {

        Set<Integer> set;

        public RandomizedSet() {
            this.set = new HashSet<>();
        }

        public boolean insert(int val) {
            return this.set.add(val);
        }

        public boolean remove(int val) {
            return this.set.remove(val);
        }

        public int getRandom() {
            return new ArrayList<>(this.set).get(new Random().nextInt(this.set.size()));
        }
    }

}
