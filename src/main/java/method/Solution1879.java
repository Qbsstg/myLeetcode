package method;

/**
 * @author: Qbss
 * @date: 2024/6/26
 * @desc: 1879. 两个数组最小的异或值之和
 */
public class Solution1879 {

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int length = nums2.length;
        int size = 1 << length;
        int[] dp = new int[size];
        dp[0] = 0;

        for (int s = 1; s < size; s++) {
            int count = Integer.bitCount(s);
            dp[s] = Integer.MAX_VALUE;
            for (int l = 0; l < length; l++) {
                if (((s >> l) & 1) == 1) {
                    dp[s] = Math.min(dp[s], dp[s ^ (1 << l)] + (nums2[l] ^ nums1[count - 1]));
                }
            }
        }

        return dp[size-1];

    }

}
