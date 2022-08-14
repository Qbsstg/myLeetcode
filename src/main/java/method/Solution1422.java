package method;

public class Solution1422 {

    public static void main(String[] args) {
        System.out.println(maxScore("00"));
    }

    public static int maxScore(String s) {
        char[] chars = s.toCharArray();
        int countOne = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                countOne++;
            }
        }

        int max = 0;
        int zeroCount = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            char aChar = chars[i];
            if (aChar == '0') {
                zeroCount++;
            }
            if (aChar == '1') {
                countOne--;
            }
            max = Math.max(zeroCount + countOne, max);
        }
        return max;
    }

}
