package contest.biweekly.b85;

import java.util.Objects;

public class Solution1 {
    public static int minimumRecolors(String blocks, int k) {


        int start = 0;
        int count = 10000;
        while (start + k <= blocks.length()) {

            String substring = blocks.substring(start, start + k);
            String[] split = substring.split("");
            int newCount = 0;
            for (String s : split) {
                if (Objects.equals(s, "W")) {
                    newCount++;
                }
            }
            count = Math.min(newCount,count);

            start = start + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "WBBWWWWBBWWBBBBWWBBWWBBBWWBBBWWWBWBWW";
        System.out.println(minimumRecolors(s, 15));


    }


}
