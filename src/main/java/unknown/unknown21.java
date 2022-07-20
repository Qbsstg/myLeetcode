package unknown;

public class unknown21 {


    public static int removeDuplicates(int[] nums){
        if (nums.length <= 0){
            return 0;
        }
        int e = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (e == nums[i]){
                removeTarget(nums,i);
                len --;
                i--;
            }else {
                e = nums[i];
            }

        }
        return len;
    }

    /**
     * 删除数组中下标为i的元素
     * @param nums
     * @param i
     * @return
     */
    static int[] removeTarget(int[] nums,int i){
        if(i<1||i>nums.length){
            return nums;
        }
        if (nums.length - 1 - i >= 0) System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(removeDuplicates(nums));
    }

}
