package method;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Qbss
 * @date: 2024/6/24
 * @desc:
 */
public class Solution502 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        int[] nums2 = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums1)));
        System.out.println(Arrays.toString(nextGreaterElements(nums2)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        while (index < nums.length * 2) {
            int count = index % nums.length;
            if (deque.isEmpty()) {
                deque.add(count);
            } else {
                if (nums[count] > nums[deque.peek()]) {
                    Integer poll = deque.poll();
                    map.put(poll, nums[count]);
                } else {
                    deque.addFirst(count);
                    index++;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.getOrDefault(i, -1);
        }
        return nums;
    }

}
