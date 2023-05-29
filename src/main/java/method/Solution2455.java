package method;

import java.util.Arrays;

public class Solution2455 {


    public int averageValue(int[] nums) {
        //return (int) Arrays.stream(nums).boxed().filter(x->x%6 == 0).mapToInt(Integer::intValue).average().orElse(0);
        return (int) Arrays.stream(nums).filter(x -> x % 6 == 0).average().orElse(0);
    }

}
