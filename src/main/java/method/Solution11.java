package method;

/**
 * @author: Qbss
 * @date: 2021/3/26
 * @desc:
 */
public class Solution11 {

    public static void main(String[] args) {

    }


    public static int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int result = 0;

        while (i < j) {
            int num = height[i] >= height[j] ? height[j] * (j - i) : height[i] * (j - i);
            if (result < num) {
                result = num;
            }

        }
        return 0;
    }


}
