package method;

/**
 * @author: Qbss
 * @date: 2023/12/27
 * @desc: 2660. 保龄球游戏的获胜者
 */
public class Solution2660 {


    public static int isWinner(int[] player1, int[] player2) {
        int i = sumScore(player1) - sumScore(player2);
        return i > 0 ? 1 : i == 0 ? 0 : 2;
    }

    private static int sumScore(int[] nums) {
        int temp = 0;
        int sum = 0;
        for (int num : nums) {
            sum = sum + (temp > 0 ? 2 * num : num);
            temp--;
            if (num == 10) {
                temp = 2;
            }
        }
        return sum;
    }
}
