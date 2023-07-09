package test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Qbss
 * @date 2022/8/24
 * @desc
 */
public class test2 {


    class myQueue {


        //<元素,数量>
        private Map<Integer, Integer> map = new HashMap<>();

        private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));

        public void add(int a) {
            Integer orDefault = map.getOrDefault(a, 0);
            map.put(a, orDefault + 1);
            if (orDefault == 0) {
                priorityQueue.add(a);
            } else {
                priorityQueue.remove(a);
                priorityQueue.add(a);
            }
        }

        public void delete(int a) {

            Integer orDefault = map.getOrDefault(a, 0);

            if (orDefault == 0) {
                return;
            } else {
                map.put(a, orDefault - 1);
            }
            priorityQueue.remove(a);
            priorityQueue.add(a);
        }

        public int get() {
            return priorityQueue.peek();
        }


    }


}
