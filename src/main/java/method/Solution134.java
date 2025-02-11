package method;

/**
 *@author Qbss
 *@date 2025/2/11 10:40
 *@desc 134. 加油站
 **/
public class Solution134 {

    /*
     *
     * 3 5 8 2 1 3 5 8 2
     * 0 1 2 3 4
     * */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gLen = gas.length;
        int slow = 0;
        while (slow < gLen) {
            int cnt = 0;
            int total = 0;
            while (cnt < gLen) {
                int index = (slow + cnt) % gLen;
                total += (gas[index] - cost[index]);
                if (total < 0) {
                    break;
                }
                cnt++;
            }
            if (cnt == gLen) {
                return slow;
            } else {
                slow = slow + cnt + 1;
            }
        }
        return -1;
    }

}
