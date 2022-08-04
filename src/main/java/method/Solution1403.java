package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Qbss
 * @date 2022/8/4
 * @desc
 */
public class Solution1403 {

    public List<Integer> minSubsequence(int[] nums) {

        List<Integer> collect = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int sum = collect.stream().reduce(Integer::sum).get();

        List<Integer> res = new ArrayList<>();

        int total = 0;
        int i = collect.size() - 1;
        for (; i >= 0; i--) {
            total += collect.get(i);
            res.add(collect.get(i));
            if (total > sum - total) {
                break;
            }
        }
        return res;

    }

}
