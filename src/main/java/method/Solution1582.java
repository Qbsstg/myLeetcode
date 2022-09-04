package method;

public class Solution1582 {

    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }

    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[][] used = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (!used[i][j]) {
                        boolean aTemp = true;
                        boolean bTemp = true;
                        for (int a = 0; a < m ; a++) {
                            if (mat[a][j] == 1&& a != i) {
                                aTemp = false;
                                break;
                            }
                        }
                        for (int b = 0; b < n ; b++) {
                            if (mat[i][b] == 1&& b != j) {
                                bTemp = false;
                                break;
                            }
                        }
                        if (aTemp && bTemp) {
                            count++;
                        } else {
                            if (aTemp) {
                                for (int a = 0; a < m; a++) {
                                    used[a][j] = true;
                                }
                            }
                            if (bTemp) {
                                for (int b = 0; b < n; b++) {
                                    used[i][b] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;

    }

}
