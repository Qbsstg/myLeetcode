package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2023/10/27
 * @desc:
 */
public class Solution1465 {

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        int hMax = Integer.MIN_VALUE;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        hMax = getvMax(h, horizontalCuts, hMax);
        int vMax = Integer.MIN_VALUE;
        vMax = getvMax(w, verticalCuts, vMax);
        return (hMax) % 1000000007 * (vMax) % 1000000007;

    }

    private static int getvMax(int w, int[] verticalCuts, int vMax) {
        for (int i = 0; i < verticalCuts.length; i++) {
            if (i == 0) {
                vMax = verticalCuts[i];
            } else {
                vMax = Math.max(verticalCuts[i] - verticalCuts[i - 1], vMax);
            }
            if (i == verticalCuts.length - 1) {
                vMax = Math.max(w - verticalCuts[verticalCuts.length - 1], vMax);
            }
        }
        return vMax;
    }

    public static void main(String[] args) {
        int h = 1000000000;
        int w = 1000000000;
        int[] nums1 = {2};
        int[] nums2 = {2};
        System.out.println(maxArea(h, w, nums1, nums2));
    }

}
