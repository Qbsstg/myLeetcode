package method;

public class Solution2605 {


    public int minNumber(int[] nums1, int[] nums2) {

        int result = Integer.MAX_VALUE;

        for (int a : nums1) {
            for (int b : nums2) {
                int value = a == b ? a : a > b ? b * 10 + a : a * 10 + b;
                result = Math.min(result, value);
            }
        }
        //Convert.convert(Long.class, "5L".clone()[0]);
        return result;
    }


}
