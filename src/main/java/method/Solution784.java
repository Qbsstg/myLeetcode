package method;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/7/21
 * @desc
 */
public class Solution784 {

    public List<String> letterCasePermutation(String s) {

        List<String> res = new ArrayList<>();

        String[] split = s.split("");
        int length = split.length;
        if (length == 0) {
            return res;
        }

        Deque<String> deque = new ArrayDeque<>();
        int[] used = new int[length];

        dfs(split, length, deque, 0, used, res, 0);
        return res;

    }

    private void dfs(String[] split, int length, Deque<String> deque, int depth, int[] used,
                     List<String> res, int cur) {

        if (depth == length) {
            res.add(String.join("", new ArrayList<>(deque)));
            return;
        }

        //for (int i = 0; i < length; i++) {
        //    if (used[i]) {
        //        continue;
        //    }
        //    deque.addLast(split[i]);
        //    used[i] = true;
        //    dfs(split, length, deque, depth + 1, used, res);
        //
        //}

        if (used[cur] == 2) {
            return;
        } else if (used[cur] == 0){
            deque.addLast(split[cur]);
            used[cur]++;
            dfs(split,length,deque,depth+1,used,res,cur);
            deque.removeLast();
            deque.addLast(split[cur].toLowerCase(Locale.ROOT));
            used[cur]++;
            dfs(split,length,deque,depth+1,used,res,cur);
        }else if (used[cur] == 1){

        }

    }

}
