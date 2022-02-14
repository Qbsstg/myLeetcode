package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2021/3/23
 * @desc:
 */
public class Solution118 {


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        if (numRows >= 1) {
            List<Integer> list = Arrays.asList(1);
            result.add(list);
        }
        if (numRows >= 2) {
            List<Integer> list = Arrays.asList(1, 1);
            result.add(list);
        }
        if (numRows > 2) {
            for (int i = 3; i <= numRows; i++) {
                List<Integer> list = result.get(i - 2);
                List<Integer> integers = new ArrayList<>();
                integers.add(1);
                for (int j = 0; j < list.size(); j++) {
                    if (j + 1 < list.size()) {
                        int i1 = list.get(j) + list.get(j + 1);
                        integers.add(i1);
                    }
                }
                integers.add(1);
                result.add(integers);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }


}
