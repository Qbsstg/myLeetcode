package method;

import java.util.*;
import java.util.stream.Collectors;

public class Solution6164 {

    public static void main(String[] args) {
        int[] nums = {279, 169, 463, 252, 94, 455, 423, 315, 288, 64, 494, 337, 409, 283, 283, 477, 248, 8, 89, 166,
                188, 186, 128};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int sum = getSum(num);
            List<Integer> list;
            if (map.containsKey(sum)) {
                list = map.get(sum);
            } else {
                list = new ArrayList<>();
            }
            list.add(num);
            map.put(sum, list);
        }

        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        int sum = -1;
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            if (next.getValue().size() > 1) {
                List<Integer> collect = next.getValue().stream().sorted().collect(Collectors.toList());
                int size = collect.size();
                sum = Math.max(collect.get(size - 2) + collect.get(size - 1), sum);
            }
        }
        return sum;

    }

    private static int getSum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
            i = i / 10;
        } while (i != 0);
        return sum;
    }
}
