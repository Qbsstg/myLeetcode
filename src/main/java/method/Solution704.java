package method;

/**
 * @author Qbss
 * @date 2022/7/11
 * @desc
 */
public class Solution704 {

    public static void main(String[] args) {
        int[] nums = {5};
        int target = 5;
        System.out.println(search1(nums, target));
        ;
    }

    public static int search(int[] nums, int target) {

        int endIndex = nums.length - 1;
        int startIndex = 0;

        while (endIndex != startIndex) {
            if (endIndex == startIndex + 1) {
                startIndex = endIndex;
            }
            int index = (endIndex + startIndex) / 2;
            if (target > nums[index]) {
                startIndex = index;
            } else if (target < nums[index]) {
                endIndex = index;
            } else {
                return index;
            }

        }
        return nums[0] == target ? 0 : -1;
    }

    public static int search1(int[] nums, int target) {

        int endIndex = nums.length - 1;
        int startIndex = 0;

        while (endIndex >= startIndex) {
            int mid = (endIndex - startIndex) / 2 + startIndex;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

}
