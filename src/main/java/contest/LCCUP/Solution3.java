package contest.LCCUP;

import java.util.*;

public class Solution3 {


    public static void main(String[] args) {
        ballGame(4, new String[]{"..E.", ".EOW", "..W."});
    }

    private static int[] dx = {1, 0, 0, -1};
    private static int[] dy = {0, 1, -1, 0};

    public static int[][] ballGame(int num, String[] plate) {

        int m = plate.length;
        int n = plate[0].length();
        char[][] chars = new char[m][n];

        for (int i = 0; i < plate.length; i++) {
            char[] charArray = plate[i].toCharArray();
            chars[i] = charArray;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                char aChar = chars[i][j];
                if (aChar == 'O') {
                    //开始bfs
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.offer(new int[]{i, j});
                    int count = 0;

                    while (!deque.isEmpty()) {
                        int size = deque.size();
                        count++;
                        if (count > num) {
                            break;
                        }
                        for (int l = 0; l < size; l++) {
                            int[] poll = deque.poll();
                            if (poll != null) {
                                char c = chars[poll[0]][poll[1]];
                                if (c == '.') {
                                    for (int s = 0; s < 4; s++) {
                                        int mx = poll[0] + dx[s];
                                        int my = poll[1] + dy[s];
                                        if (mx >= 0 && my >= 0 && mx < n && my < m) {
                                            char ac = chars[mx][my];
                                            if (ac == '.') {
                                                if (mx == 0 || mx == n - 1 || my == 0 || my == m - 1) {
                                                    Set<Integer> orDefault = map.getOrDefault(mx, new HashSet<>());
                                                    orDefault.add(my);
                                                    map.put(mx, orDefault);
                                                } else {
                                                    deque.offer(new int[]{mx, my});
                                                }
                                            } else if (ac == 'E' && s == 3) {

                                            } else if (ac == 'W' && s == ) {

                                            }

                                        }
                                    }
                                } else if (c == 'E') {

                                } else if (c == 'W') {

                                }

                            }

                        }
                    }
                }
            }
        }


        return null;

    }


}
