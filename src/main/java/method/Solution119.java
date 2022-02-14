package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2021/3/24
 * @desc:
 */
public class Solution119 {


    public static void main(String[] args) {

        System.out.println(dealResult(3));

    }


    private static List<Integer> dealResult(int a) {
        a = a +1;
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (a == 1) {
            result.add(1);
        }
        if (a > 1) {
            list.add(1);
            deal(a, list, result);
        }
        return result;
    }


    private static List<Integer> dealList(List<Integer> list) {
        int row = list.size() + 1;
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < list.size() / 2; i++) {
            result.add(list.get(i) + list.get(i + 1));
        }
        for (int i = (row / 2) - 1; i >= 0; i--) {
            result.add(result.get(i));
        }
        return result;
    }

    private static void deal(int a, List<Integer> list, List<Integer> result) {

        if (a == list.size()) {
            result.addAll(list);
            return;
        }
        if (a > list.size()) {
            list = dealList(list);
            deal(a, list, result);
        }

    }


}
