package method;

import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2023/10/9
 * @desc:
 */
public class Solution2578 {

    public static int splitNum(int num) {

        int[] array = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);

        int length = array.length;

        int[] nums1 = new int[(int) Math.ceil(length / 2.0)];
        int[] nums2 = new int[(int) Math.floor(length / 2.0)];

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                nums1[i / 2] = array[i];
            } else {
                nums2[i / 2] = array[i];
            }
        }

        //将nums1数组转为整数int
        int num1 = Arrays.stream(nums1).reduce(0, (a, b) -> a * 10 + b);
        int num2 = Arrays.stream(nums2).reduce(0, (a, b) -> a * 10 + b);

        return num1 + num2;

    }

    public static void main(String[] args) {
        System.out.println(splitNum(4325));
        System.out.println(splitNum(687));
    }

}
