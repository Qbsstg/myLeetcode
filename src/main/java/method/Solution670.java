package method;

import java.util.*;

/**
 * @author Qbss
 * @date 2022/9/13
 * @desc
 */
public class Solution670 {


    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
    }

    public static int maximumSwap(int num) {

        List<Integer> list = deal(num);

        if (list.size() <= 1) {
            return num;
        }

        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            Integer a = list.get(i);
            Integer max = list.subList(i, list.size()).stream().reduce(Integer::max).get();
            if (!a.equals(max)) {
                int lastIndexOf = list.lastIndexOf(max);
                list.set(lastIndexOf, a);
                list.set(i, max);
                int res = 0;
                for (int j = list.size() - 1; j >= 0; j--) {
                    res = (int) (res + list.get(j) * (Math.pow(10, list.size() - 1 - j)));
                }
                return res;
            }
        }


        return num;
    }

    private static List<Integer> deal(int num) {
        List<Integer> list = new ArrayList<>();
        if (num == 0) {
            list.add(num);
        } else {
            while (num != 0) {
                int i = num % 10;
                list.add(i);
                num = num / 10;
            }
        }
        return list;
    }



}
