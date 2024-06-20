package method;

/**
 * @author: Qbss
 * @date: 2024/6/20
 * @desc:
 */
public class Solution2748 {

    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = Character.getNumericValue(String.valueOf(nums[i]).charAt(0)) ;
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j] % 10;
                if (gcd(a, b) == 1) {
                    count++;
                }
            }
        }
        return count;

    }

    private static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(2, 4));
    }
}
