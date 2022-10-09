package contest.weekly.s;

public class Solution2 {

    public static void main(String[] args) {

        System.out.println(2 ^ 1);

    }


    public int[] findArray(int[] pref) {

        int[] result = new int[pref.length];

        result[0] = pref[0];

        for (int i = 1; i < result.length; i++) {
            result[i] = pref[i] ^ pref[i - 1];
        }

        return result;

    }

}
