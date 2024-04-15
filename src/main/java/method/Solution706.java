package method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Qbss
 * @date: 2024/4/15
 * @desc:
 */
public class Solution706 {


    class MyHashMap {

        private Map<Integer,Integer> map;

        public MyHashMap() {
            map = new HashMap<>();
        }

        public void put(int key, int value) {
            map.put(key,value);
        }

        public int get(int key) {
            return map.get(key);
        }

        public void remove(int key) {
            map.remove(key);
        }
    }
}
