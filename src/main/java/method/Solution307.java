package method;

/**
 * @author: Qbss
 * @date: 2023/11/13
 * @desc: 区域和检索 - 数组可修改
 */
public class Solution307 {


    static class NumArray {

        private int[] ans;

        public NumArray(int[] nums) {
            ans = nums;
        }

        public void update(int index, int val) {
            if (ans != null) {
                if (ans.length > 0) {
                    if (index < ans.length){
                        ans[index] = val;
                    }
                }
            }
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            if (ans != null) {
                if (ans.length > 0) {
                    for (int i = left; i <= right; i++) {
                        sum += ans[i];
                    }
                }
            }
            return sum;
        }
    }
}
