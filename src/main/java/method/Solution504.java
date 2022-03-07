package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/3/7
 * @desc
 */
public class Solution504 {

    public static void main(String[] args) {
        int num1 = 100;
        int num2 = -7;
        System.out.println(convertToBase7(num2));
    }


    public static String convertToBase7(int num) {

        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 7);
            num = num / 7;
            i++;
        }

        int total = 0;
        for (int j = 0; j < i; j++) {
            total = (int) (total + list.get(j) * (Math.pow(10, j)));
        }

        return String.valueOf(total);

    }


}
