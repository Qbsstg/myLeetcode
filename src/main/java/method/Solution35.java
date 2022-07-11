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
                if (i == nums.length - 1) {
                    res = nums.length;
                }
            } else {
                res = i;
                break;
            }
        }
        return res;
    }

    private static int searchInsert1(int[] nums, int target) {

        int startIndex = 0;
        int endIndex = nums.length - 1;

        while (endIndex > startIndex) {
            int mid = (endIndex - startIndex) / 2 + startIndex;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return nums[startIndex] >= target ? startIndex : startIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(searchInsert1(nums, target));
    }

}
