package method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2021/5/7
 * @desc
 */
public class Solution9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000000001));
    }

    public static boolean isPalindrome(int x) {
        int result = x;
        List<Integer> list = new ArrayList<>();
        while (x / 10 > 0 || (0 < x && x < 10)) {
            list.add(x % 10);
            x = x / 10;
        }
        int sum = 0;
        if (list.size() == 10 && list.get(0) > 2) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) * (Math.pow(10, (list.size() - i - 1)));
        }
        return sum == result;
    }

}
