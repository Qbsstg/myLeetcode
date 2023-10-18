package method;

import java.util.stream.IntStream;

/**
 * @author: Qbss
 * @date: 2023/10/17
 * @desc:
 */
public class Solution2652 {

    public static int sumOfMultiples(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(x -> x % 3 == 0 || x % 5 == 0 || x % 7 == 0)
                .sum();
    }

    public static void main(String[] args) {
        sumOfMultiples(7);
    }
}
