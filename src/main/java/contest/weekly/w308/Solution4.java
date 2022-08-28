package contest.weekly.w308;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution4 {

    public static void main(String[] args) {
        buildMatrix(1, new int[][]{{1, 2}, {2, 3}, {2, 3}}, null);
    }


    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        TreeSet<int[]> treeSetRow = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
        treeSetRow.addAll(Arrays.asList(rowConditions));

        if (treeSetRow.size() != rowConditions.length) {
            return new int[][]{};
        }
        TreeSet<int[]> treeSetCol = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
        treeSetCol.addAll(Arrays.asList(rowConditions));
        if (treeSetCol.size() != colConditions.length) {
            return new int[][]{};
        }

        int[][] res = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                res[i][j] = 0;
            }
        }




        return null;
    }

}
