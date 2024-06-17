package method;

/**
 * @author: Qbss
 * @date: 2024/6/13
 * @desc:
 */
public class Solution2813 {

    // 先考虑固定窗口大小求值试试
    public long findMaximumElegance(int[][] items, int k) {
        int length = items.length;
        if (k > length) {
            return 0;
        }

        for (int i = 0; i + k - 1 < length; i++) {
            int fast = i + k - 1;
            int slow = i;

            


        }
        return 1;
    }


}
