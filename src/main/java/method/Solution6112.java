package method;

public class Solution6112 {

    public static void main(String[] args) {
        int[] amount = {5, 4, 4};
        System.out.println(fillCups(amount));
    }

    public static int fillCups(int[] amount) {
        int count = 0;
        while (amount[0] + amount[1] + amount[2] > 0) {
            int maxIndex = maxIndex(amount[0], amount[1], amount[2]);
            int minIndex = minIndex(amount, maxIndex);
            if (amount[maxIndex] > 0) {
                amount[maxIndex]--;
                count++;
            }
            if (minIndex > 0 && amount[minIndex] > 0) {
                amount[minIndex]--;
            }
        }
        return count;
    }

    public static int maxIndex(int a, int b, int c) {
        if (a >= b && a >= c) {
            return 0;
        }
        if (b >= a && b >= c) {
            return 1;
        }
        return 2;
    }

    public static int minIndex(int[] amount, int maxIndex) {
        int a = maxIndex;
        for (int i = 0; i < amount.length; i++) {
            if (maxIndex != i) {
                if (amount[i] != 0) {
                    a = i;
                }
            }
        }
        return maxIndex == a ? -1 : a;
    }
}
