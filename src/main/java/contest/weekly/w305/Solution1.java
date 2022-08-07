package contest.weekly.w305;

public class Solution1 {


    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
    }

    public static int longestIdealString(String s, int k) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 0;
        }
        char aChar = chars[0];
        int count = 0;
        int sum = 0;
        for (int i = 1; i < chars.length; i++) {
            if (Math.abs(chars[i] - aChar) <= k) {
                aChar = chars[i];
                count++;
            } else {
                sum = Math.max(sum,count);
                count = 0;
            }
        }
        return sum;
    }
}
