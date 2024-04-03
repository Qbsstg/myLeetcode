package method;

import common.TreeNode;

import java.util.Arrays;

public class Solution654 {


    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        return deal(nums);
    }

    private static TreeNode deal(int[] nums) {
        TreeNode node = null;
        if (nums.length > 0) {
            int[] dealMax = dealMax(nums);
            node = new TreeNode(dealMax[1]);
            int[][] ints = splitNums(nums, dealMax);
            if (ints[0].length > 0) {
                node.left = deal(ints[0]);
            }
            if (ints[1].length > 0) {
                node.right = deal(ints[1]);
            }
        }
        return node;
    }

    private static int[] dealMax(int[] nums) {
        int max = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, max};
    }

    private static int[][] splitNums(int[] nums, int[] info) {
        int[] leftNums = new int[info[0]];
        int[] rightNums = new int[nums.length - info[0] - 1];

        System.arraycopy(nums, 0, leftNums, 0, info[0]);
        if (info[0] >= 0) System.arraycopy(nums, info[0] + 1, rightNums, 0,
                nums.length - info[0] - 1);

        return new int[][]{leftNums, rightNums};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] nums1 = {3, 2, 1, 6, 0, 5};
        int[] info = {2, 3};

        int[][] res = splitNums(nums, info);
        System.out.println(Arrays.deepToString(res));
        System.out.println(constructMaximumBinaryTree(nums1));
        System.out.println(constructMaximumBinaryTree(new int[]{1, 4, 2, 3, 5}));
    }

}
