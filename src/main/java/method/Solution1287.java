package method;

/**
 *@author Qbss
 *@date 2025/2/17 11:44
 *@desc 1287. 有序数组中出现次数超过25%的元素
 **/
public class Solution1287 {

    public static int findSpecialInteger(int[] arr) {

        int length = arr.length;
        if (length == 0) {
            return 0;
        }
        double floor = Math.floor(length * 0.25);
        int value = ((int) floor) + 1;
        int a = arr[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i] == a) {
                count++;
                if (count >= value) {
                    return a;
                }
            } else {
                a = arr[i];
                count = 1;
            }
        }
        return a;
    }

}
