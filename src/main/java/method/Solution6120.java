package method;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution6120 {

    public static void main(String[] args) {
        int[] nums = {5,12,53,22,7,59,41,54,71,24,91,74,62,47,20,14,73,11,82,2,15,38,38,20,57,70,
                86,93,38,75,94,19,36,40,28,6,35,86,38,94,4,90,18,87,24,22};
        numberOfPairs(nums);
    }

    public static int[] numberOfPairs(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        int count2 = 0;
        for (Map.Entry<Integer, Integer> next : map.entrySet()) {
            if (next.getValue() % 2 == 0) {
                int i = next.getValue() / 2;
                count = count+i;
            } else {
                int i = next.getValue() / 2;
                count = count+i;
                count2++;
            }
        }
        return new int[]{count,count2};
    }
}
