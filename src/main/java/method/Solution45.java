package method;

/**
 * @author Qbss
 * @date 2022/3/10
 * @desc
 */
public class Solution45 {


    public static int jump(int[] nums) {

        int max = 0;
        int count = 0;
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(i + nums[i], max);
            if (end == i) {
                //if (i != nums.length - 1) {
                count++;
                end = max;
                //}
            }


        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{1, 2}));
    }

}
