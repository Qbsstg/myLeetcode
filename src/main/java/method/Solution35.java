package method;

public class Solution35 {

    private static int searchInsert(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == target) {
                res = i;
                break;
            } else if (temp < target) {
                if (i == nums.length-1){
                    res = nums.length;
                }else {
                    continue;
                }
            } else if (temp > target) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

}
