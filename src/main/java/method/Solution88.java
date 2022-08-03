package method;

/**
 * @author Qbss
 * @date 2022/8/2
 * @desc
 */
public class Solution88 {

    public static void main(String[] args) {

        String  s = "@664321";


    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m + n];
        int[] maxNums;
        int[] minNums;

        if (m >= n) {
            maxNums = nums1;
            minNums = nums2;
        } else {
            maxNums = nums2;
            minNums = nums1;
            int temp = n;
            n = m;
            m = temp;
        }

        for (int i = 0, j = 0, k = 0; i < m && k < m + n; i++, k++) {
            int i1 = maxNums[i];
            for (; j < n; j++, k++) {
                if (i1 >= minNums[j]) {
                    res[k] = minNums[j];
                } else {
                    break;
                }
            }
            res[k] = i1;
            if (i == m - 1) {
                k = k + 1;
                for (; j < n; j++, k++) {
                    res[k] = minNums[j];
                }
            }
        }

        System.arraycopy(res, 0, nums1, 0, m + n);
    }


}
