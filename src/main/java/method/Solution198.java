package method;

import common.ListNode;

/**
 * @author Qbss
 * @date 2022/3/7
 * @desc
 */
public class Solution198 {

    public static void main(String[] args) {

        //int[] nums1 = new int[]{1, 2, 3, 5};
        //int[] nums2 = new int[]{2, 7, 9, 3, 1};
        //int[] nums3 = new int[]{2, 1, 1, 2};
        //
        //
        //System.out.println(rob(nums1));
        //System.out.println(rob(nums2));
        //System.out.println(rob(nums3));

        /*
        * 将 链表：1->2 反转为 2->1
        * */
        //初始化链表
        ListNode node2 = new ListNode(2, null);
        ListNode node1 = new ListNode(1, node2);

        //反转
        node2.next = node1;

        System.out.println(node1);

    }


    public static int rob(int[] nums) {

        int length = nums.length;
        int[] a = new int[length + 1];

        a[0] = nums[0];
        if (length > 1) {
            a[1] = nums[1];
        }

        if (length <= 2) {
            return Math.max(a[0], a[1]);
        }

        int i = 2;
        for (; i < length; i++) {
            a[i] = Math.max(a[i - 1], a[i - 2] + nums[i]);
            if (i >= 3) {
                a[i] = Math.max(a[i], a[i - 3] + nums[i]);
            }
        }
        return a[length - 1];

    }

}
