package method;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution6134 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, -1};
        int[] nums2 = {1, 2, -1};
        int[] nums1 = {5, -1, 3, 4, 5, 6, -1, -1, 4, 3};
        int[] nums3 = {4, 4, 4, 5, 1, 2, 2};
        int[] nums4 = {9, 8, 7, 0, 5, 6, 1, 3, 2, 2};
        int[] nums5 = {5, 3, 1, 0, 2, 4, 5};


        //System.out.println(closestMeetingNode(nums, 0, 1));
        //System.out.println(closestMeetingNode(nums2, 0, 2));
        //System.out.println(closestMeetingNode(nums1, 0, 0));
        //System.out.println(closestMeetingNode(nums3, 1, 1));
        //System.out.println(closestMeetingNode(nums2, 0, 2));
        //System.out.println(closestMeetingNode(nums4, 1, 6));
        System.out.println(closestMeetingNode(nums5, 3, 2));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {

        if (node1 == node2) {
            return node1;
        }

        int length = edges.length;
        boolean[] used = new boolean[length];

        int node = node1;
        used[node] = true;
        do {
            node = edges[node];
            if (used[node]) {
                break;
            }
            used[node] = true;
        } while (edges[node] != -1);

        if (used[node2] && edges[node2] == -1) {
            return node2;
        }

        int targetNode = node2;
        while (edges[targetNode] != -1) {
            if (used[targetNode]) {
                return targetNode;
            }
            targetNode = edges[targetNode];
        }
        return -1;
    }

}
