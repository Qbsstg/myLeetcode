package contest.weekly.w306;

public class Solution4 {

    public static void main(String[] args) {
        smallestNumber("DDD");
    }
    public static String smallestNumber(String pattern) {
        int length = pattern.length();
        int[] res = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            res[i] = 1 + i;
        }

        char[] chars = pattern.toCharArray();


        return "";
    }
}
