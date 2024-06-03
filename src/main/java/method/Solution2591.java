package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2024/6/3
 * @desc:
 */
public class Solution2591 {

    public static void main(String[] args) {
        int i = distMoney(17, 2);
        System.out.println(i);
    }


    public static int distMoney(int money, int children) {

        int[] ans = new int[children];
        Arrays.fill(ans, 1);

        int sum = ans.length;

        if (money < sum) {
            return -1;
        }

        money -= sum;

        for (int i = 0; i < ans.length; i++) {
            if (money >= 7) {
                ans[i] += 7;
                money -= 7;
            } else if (money == 3) {
                if (i == ans.length - 1) {
                    ans[i] += 2;
                    ans[i - 1] += 1;
                    money -= 3;
                }
            }
            if (money == 0) {
                break;
            }
            if (i == ans.length - 1) {
                ans[i] += money;
                money -= money;
            }
        }
        int count = 0;
        for (int an : ans) {
            if (an == 8) {
                count++;
            }
        }
        return count;
    }

}
