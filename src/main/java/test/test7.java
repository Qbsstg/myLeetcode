package test;

public class test7 {


    /*
     * 当查询不到目标值时返回-1
     * */
    public int search(int target, int[] nums) {

        if (nums == null) {
            return -1;
        }
        return searchR(target, 0, nums.length - 1, nums);
    }
    public int searchR(int target, int start, int end, int[] nums) {
        if (start > end) {
            return -1;
        }
        //取中位值
        int mid = start + (end - start) / 2;
        //如果值相等，返回当前的下标，即为目标值
        if (nums[mid] == target) {
            return mid;
        }
        //如果目标值小于当前中间值，即目标值在左边
        else if (target < nums[mid]) {
            return searchR(target, start, mid - 1, nums);
        }
        //如果目标值大于当前中间值，即目标值在左边
        else if (target > nums[mid]) {
            return searchR(target, mid + 1, end, nums);
        }

        return -1;
    }


}
