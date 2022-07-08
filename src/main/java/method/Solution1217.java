package method;

/**
 * @author Qbss
 * @date 2022/7/8
 * @desc
 */
public class Solution1217 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(minCostToMoveChips(nums));
    }

    public static int minCostToMoveChips(int[] position) {

        int odd = 0;
        int even = 0;
        for (int j : position) {
            if (j % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);

    }
}
