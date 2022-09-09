package method;

/**
 * @author Qbss
 * @date 2022/9/9
 * @desc
 */
public class Solution667 {

    public int[] constructArray(int n, int k) {

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = i + 1;
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = 1;
            } else if (i > k) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i - 1] + ans[i - 1];
            }
        }
        return res;

    }

}
