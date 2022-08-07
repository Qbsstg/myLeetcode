package contest.weekly.w305;

public class Solution3 {

    public boolean validPartition(int[] nums) {


        int length = nums.length;
        boolean[] used = new boolean[nums.length];
        for (int i = 3; i < length; i++) {
            if (used[i - 1]) {
                if (nums[i - 1] != nums[i - 2]) {
                    used[i] = false;
                } else {
                    if (nums[i - 2] == nums[i - 3]) {
                        if (nums[i] == nums[i - 1]) {
                            used[i] = true;
                        } else {
                            used[i] = false;
                        }
                    }else {
                        if (nums[i] == nums[i - 1]) {
                            used[i] = true;
                        } else {
                            used[i] = false;
                        }
                    }
                }
            } else {

            }

        }
        return false;
    }

}
