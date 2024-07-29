package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2024/7/29
 * @desc:
 */
public class Solution684 {

    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            switch (operation) {
                case "+" -> list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                case "D" -> list.add(list.get(list.size() - 1) * 2);
                case "C" -> list.remove(list.size() - 1);
                default -> list.add(Integer.parseInt(operation));
            }
        }
        return list.stream().reduce(0, Integer::sum);
    }

}
