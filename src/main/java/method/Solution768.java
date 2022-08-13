package method;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution768 {


    public int maxChunksToSorted(int[] arr) {

        int[] clone = arr.clone();
        Arrays.sort(clone);
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer orDefault = map.getOrDefault(arr[i], 0);
            if (orDefault + 1 == 0) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], orDefault + 1);
            }

            Integer aDefault = map.getOrDefault(clone[i], 0);
            if (orDefault - 1 == 0) {
                map.remove(clone[i]);
            } else {
                map.put(clone[i], aDefault - 1);
            }

            if (map.isEmpty()){
                count++;
            }
        }
        return count;
    }


}
