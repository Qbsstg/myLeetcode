package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/7/21
 * @desc
 */
public class Solution77 {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        deal(1, n, k);
        return ans;
    }

    private void deal(int cur, int n, int k) {

        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (temp.size() + 1 + (n - (cur + 1) + 1) >= k) {
            temp.add(cur);
            deal(cur + 1, n, k);
        } else {
            temp.remove(temp.size() - 1);
            deal(cur + 1, n, k);
        }

    }


    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4, 2));
    }

}
