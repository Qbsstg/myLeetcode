package method;

import java.util.*;

public class Solution347 {


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(list.size() - i - 1).getKey();
        }

        return result;
    }

    public int[] topKFrequent1(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        map.keySet().forEach(x -> {
            if (priorityQueue.size() < k) {
                priorityQueue.add(x);
            } else {
                if (map.get(x) > map.get(priorityQueue.peek())) {
                    priorityQueue.remove();
                    priorityQueue.add(x);
                }
            }
        });



        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2, 2,3};
        int k = 2;
        Solution347 solution347 = new Solution347();
        solution347.topKFrequent1(nums, 2);
    }

}
