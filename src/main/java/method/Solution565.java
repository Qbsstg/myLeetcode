package method;

import java.util.HashSet;
import java.util.Set;

public class Solution565 {

    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting1(nums));
    }

    public static int arrayNesting(int[] nums) {
        int count = 0;
        Set<Integer> countSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (countSet.add(nums[i])) {
                Set<Integer> set = new HashSet<>();
                deal(nums, i, set);
                count = Math.max(set.size(), count);
                countSet.addAll(set);
            }
        }
        return count;
    }

    public static int arrayNesting1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = i;
            int ans = 0;
            while (nums[cur] != -1) {
                ans++;
                int next = nums[cur];
                nums[cur] = -1;
                cur = next;
            }
            count = Math.max(count, ans);
        }
        return count;
    }

    private static void deal(int[] nums, int i, Set<Integer> set) {
        boolean add = set.add(nums[i]);
        if (add) {
            deal(nums, nums[i], set);
        }
    }

}
