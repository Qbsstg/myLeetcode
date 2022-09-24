package method;

import java.util.Arrays;

public class Solution1608 {

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{1, 0, 0, 6, 4, 9}));
    }

    public static int specialArray(int[] nums) {

        Integer[] ans = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }

        Arrays.sort(ans, (o1, o2) -> o2 - o1);
        for (int i = 1; i <= ans.length; ++i) {
            if (ans[i - 1] >= i && (i == ans.length || ans[i] < i)) {
                return i;
            }
        }


        return -1;
    }

}
