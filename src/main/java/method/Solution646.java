package method;

import java.util.*;

public class Solution646 {


    public static void main(String[] args) {
        //System.out.println(findLongestChain(new int[][]{{1, 2}, {3, 4}, {2, 3}}));
        System.out.println(findLongestChain(new int[][]{{7, 9}, {4, 5}, {7, 9}, {-7, -1}, {0, 10}, {3, 10}, {3, 6}, {2, 3}}));
    }

    public static int findLongestChain(int[][] pairs) {

        int cur = Integer.MIN_VALUE;
        int res = 0;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        for (int[] pair : pairs) {
            if (cur < pair[0]){
                cur = pair[1];
                res++;
            }
        }
        return res;
    }
}
