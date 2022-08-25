package method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/8/25
 * @desc
 */
public class Solution658 {

    public static void main(String[] args) {


        System.out.println(findClosestElements1(new int[]{1, 2, 3, 4, 5}, 4, 3));
        //System.out.println(findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9));
        //System.out.println(findClosestElements(new int[]{-2, -1, 1, 2, 3, 4, 5}, 7, 3));
        //System.out.println(findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4));
        System.out.println(findClosestElements1(new int[]{0, 1, 2, 2, 2, 3, 6, 8, 8, 9}, 5, 9));
        //System.out.println(binarySearch1(new int[]{1, 8, 100}, 2));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> res = new ArrayList<>(k);
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        int length = arr.length;
        if (x >= arr[length - 1]) {
            for (int i = length - k; i < length; i++) {
                res.add(arr[i]);
            }
            return res;
        }

        int index = binarySearch1(arr, x);

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        int left = index < 0 ? -index - 1 : index - 1;
        int right = index < 0 ? -index : index + 1;
        boolean[] used = new boolean[length];

        if (index > 0) {
            leftList.add(arr[index]);
            used[index] = true;
        }


        while (leftList.size() + rightList.size() != k) {
            if (left >= 0 && right < length) {
                if (used[left]) {
                    rightList.add(arr[right]);
                    used[right] = true;
                    if (right + 1 < length) {
                        right = right + 1;
                    }
                } else if (used[right]) {
                    leftList.add(arr[left]);
                    used[left] = true;
                    if (left - 1 >= 0) {
                        left = left - 1;
                    }
                } else {
                    if (x - arr[left] <= arr[right] - x) {
                        leftList.add(arr[left]);
                        used[left] = true;
                        if (left - 1 >= 0) {
                            left = left - 1;
                        }
                    } else {
                        rightList.add(arr[right]);
                        used[right] = true;
                        if (right + 1 < length) {
                            right = right + 1;
                        }
                    }
                }
            }
        }


        for (int i = leftList.size() - 1; i >= 0; i--) {
            res.add(leftList.get(i));
        }

        res.addAll(rightList);


        return res;
    }

    private static int binarySearch(int[] arr, int x) {

        int index = x / 2;

        while (true) {
            if (x > arr[index]) {
                index = (arr.length + index) / 2;
            } else if (x < arr[index]) {
                index = (index + 1) / 2;
            } else {
                return index;
            }
        }
    }

    private static int binarySearch1(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) >> 1;
            int midVal = arr[mid];

            if (x > midVal) {
                start = mid + 1;
            } else {
                if (midVal == x) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -(start);
    }

    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {

        List<Integer> collect = new ArrayList<>(arr.length);
        for (int j : arr) {
            collect.add(j);
        }
        collect.sort((o1, o2) -> {
            if (Math.abs(o1 - x) != Math.abs(o2 - x)) {
                return Math.abs(o1 - x) - Math.abs(o2 - x);
            } else {
                return o1 - o2;
            }
        });
        List<Integer> list = collect.subList(0, k);
        Collections.reverse(list);
        return list;
    }


}
