package method;

/**
 * @author: Qbss
 * @date: 2024/4/23
 * @desc: 1052. 爱生气的书店老板
 */
public class Solution1052 {


    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int slow = 0;
        int fast = slow + minutes - 1;

        int sum = 0;
        for (int i = slow; i <= fast && i < customers.length; i++) {
            sum += customers[i];
        }
        for (int i = fast + 1; i < customers.length; i++) {
            sum += customers[i] * (grumpy[i] ^ 1);
        }
        slow++;
        fast++;

        int maxSum = sum;

        if (fast < customers.length) {
            for (; fast < customers.length; slow++, fast++) {
                sum -= customers[slow - 1] * grumpy[slow - 1];
                sum += customers[fast] * grumpy[fast];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] customers = {3};
        // int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {1};
        // int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 1;
        // int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

}
