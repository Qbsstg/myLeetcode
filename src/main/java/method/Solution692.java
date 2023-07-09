package method;

import java.util.*;

public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {


        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            Integer a1 = map.get(o1);
            Integer a2 = map.get(o2);
            if (a1.equals(a2)) {
                return (o1.compareTo(o2)) * -1;
            } else {
                return a1 - a2;
            }
        });

        for (String s : map.keySet()) {
            if (pq.size() < k) {
                pq.add(s);
            } else {
                String peek = pq.peek();
                if (peek != null) {
                    Integer num = map.get(peek);
                    if (map.get(s) > num) {
                        pq.remove();
                        pq.add(s);
                    } else if (Objects.equals(map.get(s), num)) {
                        if (s.compareTo(peek) < 0) {
                            pq.remove();
                            pq.add(s);
                        }
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }

    public List<String> topKFrequent1(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> rec = new ArrayList<>(map.keySet());

        rec.sort((o1, o2) -> {

            int i1 = map.get(o1);
            int i2 = map.get(o2);

            if (i1 == i2) {
                return o1.compareTo(o2);
            }
            return i2 - i1;
        });

        return rec.subList(0, k);

    }

    public static void main(String[] args) {

        Solution692 solution692 = new Solution692();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        //int k = 2;
        System.out.println(solution692.topKFrequent(words, 1));

    }


}
