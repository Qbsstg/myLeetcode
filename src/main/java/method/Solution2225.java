package method;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/7/20
 * @desc
 */
public class Solution2225 {

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> winners = findWinners(matches);
        System.out.println(winners);
    }

    static class total {
        int win;
        int lose;
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, total> map = new HashMap<>();
        for (int[] match : matches) {
            int a = match[0];
            int b = match[1];

            total w = map.get(a);
            if (w == null) {
                w = new total();
                w.win = 1;
            } else {
                w.win = w.win + 1;
            }

            total l = map.get(b);
            if (l == null) {
                l = new total();
                l.lose = 1;
            } else {
                l.lose = l.lose + 1;
            }

            map.put(a, w);
            map.put(b, l);

        }

        List<Integer> winners = new ArrayList<>();
        List<Integer> loseOne = new ArrayList<>();

        map.forEach((k, v) -> {
            if (v.win >= 0 && v.lose == 0) {
                winners.add(k);
            } else if ( v.lose == 1) {
                loseOne.add(k);
            }
        });
        return Arrays.asList(winners.stream().sorted().toList(), loseOne.stream().sorted().toList());
    }

}
