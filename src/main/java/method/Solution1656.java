package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/16
 * @desc
 */
public class Solution1656 {


    static class OrderedStream {

        private String[] nums;

        private int ptr;

        public OrderedStream(int n) {
            this.nums = new String[n + 1];
            this.ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            this.nums[idKey] = value;
            List<String> res = new ArrayList<>();
            for (int i = ptr; i < this.nums.length; i++) {
                if (this.nums[i] == null) {
                    this.ptr = i;
                    break;
                }
                res.add(this.nums[i]);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String[] nums = new String[10];
        for (String num : nums) {
            System.out.println(num);
        }
    }

}
