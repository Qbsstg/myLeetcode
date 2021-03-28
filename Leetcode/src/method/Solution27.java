package method;

public class Solution27 {


    private static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val){
                removeTarget(nums,i);
                len--;
                i--;
            }
        }
        return len;
    }

    private static int[] removeTarget(int[] nums,int target){
        if (target<0||target>nums.length){
            return nums;
        }
        for (int i = target; i < nums.length-1; i++) {
            nums[i] = nums[i+1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums,val));
    }
}
