package method;

import java.util.HashSet;
import java.util.Set;

public class Solution565 {

    public static void main(String[] args) {
        int[] nums ={5,4,0,3,1,6,2};
        Set<Integer> set = new HashSet<>();
        deal(nums,0,set);
        System.out.println(set);
    }

    public static int arrayNesting(int[] nums) {
        int count = 0;
        Set<Integer> countSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (countSet.add(nums[i])){
                Set<Integer> set = new HashSet<>();
                deal(nums,i,set);
                count = Math.max(set.size(),count);
                countSet.addAll(set);
            }
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
