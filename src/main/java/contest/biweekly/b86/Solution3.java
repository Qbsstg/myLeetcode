package contest.biweekly.b86;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(maximumRows(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}}, 2));
        System.out.println(maximumRows(new int[][]{{1}, {0}}, 1));
    }


    public static int maximumRows(int[][] mat, int cols) {


        int n = mat[0].length;
        int m = mat.length;
        List<List<Integer>> combine = combine(n, cols);

        int res = 0;

        for (int i = 0; i < combine.size(); i++) {
            int[][] ints = new int[m][n];
            for (int a = 0; a < m; a++) {
                System.arraycopy(mat[a], 0, ints[a], 0, n);
            }
            for (int j = 0; j < combine.get(i).size(); j++) {
                fill(ints, combine.get(i).get(j));
            }
            res = Math.max(res, cal(ints));
        }

        return res;


    }

    private static int cal(int[][] mat) {
        int[] sum = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                sum[i] = sum[i] + mat[i][j];
            }
        }
        int count = 0;
        for (int s : sum) {
            if (s == 0) {
                count++;
            }
        }
        return count;
    }

    private static void fill(int[][] mat, int index) {

        for (int i = 0; i < mat.length; i++) {
            mat[i][index] = 0;
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

         List<Integer> temp = new ArrayList<>();
         List<List<Integer>> ans = new ArrayList<>();

        deal(0, n - 1, k,temp,ans);
        return ans;
    }

    private static void deal(int cur, int n, int k,List<Integer> temp,List<List<Integer>> ans) {

        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        deal(cur + 1, n, k,temp,ans);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        deal(cur + 1, n, k,temp,ans);


    }

}
