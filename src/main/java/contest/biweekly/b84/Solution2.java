package contest.biweekly.b84;

public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};
        System.out.println(add(100));
    }

    public static long countBadPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - num != j - i) {
                    count++;
                }
            }
        }
        return count;
    }


    private static int add(int l) {

        return ((1 + l) * l) >> 1;

    }

}
