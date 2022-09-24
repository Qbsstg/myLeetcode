package contest.LCCUP;

public class Solution1 {

    public static void main(String[] args) {
        temperatureTrend(new int[]{21, 18, 18, 18, 31}, new int[]{34, 32, 16, 16, 17});
    }

    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {

        int[] qA = new int[temperatureA.length - 1];
        int[] qB = new int[temperatureA.length - 1];

        for (int i = 1; i < temperatureA.length; i++) {
            qA[i - 1] = Integer.compare(temperatureA[i], temperatureA[i - 1]);
            qB[i - 1] = Integer.compare(temperatureB[i], temperatureB[i - 1]);
        }
        int count = 0;
        int s = 0;
        for (int i = 0; i < qA.length; i++) {
            int a = qA[i];
            int b = qB[i];
            if (a == b) {
                s++;
            }
            if (i == qA.length - 1 || a != b) {
                count = Math.max(count, s);
                s = 0;
            }
        }
        return count;

    }

}
