package method;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Qbss
 * @date 2022/8/19
 * @desc
 */
public class Solution1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;


    }

    public int busyStudent1(int[] startTime, int[] endTime, int queryTime) {

        int count = 0;
        TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < startTime.length; i++) {
            set.add(new int[]{startTime[i], endTime[i]});
        }

        for (int[] next : set) {
            if (next[0] > queryTime) {
                break;
            }
            if (next[1] >= queryTime) {
                count++;
            }
        }
        return count;
    }

}
