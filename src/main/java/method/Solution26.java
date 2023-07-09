package method;

import java.util.Arrays;

public class Solution26 {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }

    public static int[] remove(int[] nums) {

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        //return Arrays.stream(nums).limit(i + 1).toArray();
        int[] result = new int[i + 1];
        //System.arraycopy(nums, 0, result, 0, i + 1);

        System.arraycopy(nums, 0, result, 0, i + 1);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.toString(remove(nums)));
    }

}
