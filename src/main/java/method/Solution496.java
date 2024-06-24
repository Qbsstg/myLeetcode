package method;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2024/6/24
 * @desc:
 */
public class Solution496 {

    public static void main(String[] args) {
        // int[] nums1 = {4, 1, 2};
        int[] nums1 = {2, 4};
        // int[] nums2 = {1, 3, 4, 2};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    static class Element {
        int value;
        int index;
        int nextIndex = -1;

        public Element(int value, int index, int nextIndex) {
            this.value = value;
            this.index = index;
            this.nextIndex = nextIndex;
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            list.add(new Element(nums2[i], i, -1));
        }

        ArrayDeque<Element> deque = new ArrayDeque<>();
        int index = 0;

        while (index < list.size()) {
            if (deque.isEmpty()) {
                deque.add(list.get(index));
                index++;
            } else {
                if (list.get(index).value > deque.peek().value) {
                    deque.poll().nextIndex = list.get(index).value;
                } else {
                    deque.addFirst(list.get(index));
                    index++;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];
            nums1[i] = list.stream().filter(x -> x.value == a).findFirst().orElse(new Element(0, 0, -1)).nextIndex;
        }
        return nums1;
    }
}
