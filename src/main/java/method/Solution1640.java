package method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qbss
 * @date 2022/9/22
 * @desc
 */
public class Solution1640 {

    public static void main(String[] args) {
        System.out.println(canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, int[]> map = new HashMap<>(100);

        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {

                int index = i;
                int[] ints = map.get(arr[i]);
                for (int anInt : ints) {
                    if (arr[index] == anInt) {
                        index++;
                    } else {
                        return false;
                    }
                }
                i = index - 1;
            } else {
                return false;
            }
        }
        return true;
    }

}
