package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2023/9/26
 * @desc:
 */
public class Solution2582 {

    //n 是数量 time 是时间
    public int passThePillow(int n, int time) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = n - 1; i > 1; i--) {
            list.add(i);
        }
        return list.get(time % list.size());
    }

}
