package honor;

import java.util.*;

public class honor2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        if (target >= 2) {
            Arrays.sort(nums);

            int left = 1;
            int right = nums[size - 1] - nums[0];

            while (left <= right) {
                int mid = (left + right) / 2;

            }


        }

    }
}
