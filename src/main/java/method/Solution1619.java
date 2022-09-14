package method;

import java.util.Arrays;

/**
 * @author Qbss
 * @date 2022/9/14
 * @desc
 */
public class Solution1619 {

    public static void main(String[] args) {
        System.out.println(trimMean(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
    }

    public static double trimMean(int[] arr) {

        int length = arr.length;

        Arrays.sort(arr);

        int[] res = new int[length - ((length / 20) << 1)];

        System.arraycopy(arr, (length / 20), res, 0, length - ((length / 20) << 1));

        return Arrays.stream(res).average().orElse(0.0D);

    }
}
