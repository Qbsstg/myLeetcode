package contest.weekly.w309;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        //numberOfWays(1,2,3);
        numberOfWays(1, 1000, 999);
    }

    public static int numberOfWays(int startPos, int endPos, int k) {


        Map<Integer, Integer> map = new HashMap<>();

        map.put(startPos, 0);
        for (int i = 0; i < k; i++) {

        }

        return 1;

    }


}
