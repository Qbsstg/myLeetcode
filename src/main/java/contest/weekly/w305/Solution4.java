package contest.weekly.w305;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (set.contains(next + diff) && set.contains(next + diff + diff)) {
                count++;
            }
        }
        return count;
    }

}
