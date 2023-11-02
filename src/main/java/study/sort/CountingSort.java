package study.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2023/10/30
 * @desc: 计数排序
 */
public class CountingSort {


    //假设arr[i] < 100
    public static void sort(int[] arr) {
        int[] nums = new int[100];
        for (int j : arr) {
            nums[j]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int num = nums[i]; num > 0; num--) {
                    list.add(i);
                }
            }
        }

    }

    public static void main(String[] args) {
        sort(new int[]{1,4,3,7,2,8,0,5,10,23,2,4});
    }

}
