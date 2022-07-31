package method;

import java.util.Set;
import java.util.TreeSet;

public class Solution6132 {


    public int minimumOperations(int[] nums) {

        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num != 0){
                set.add(num);
            }
        }
        return set.size();


    }

}
