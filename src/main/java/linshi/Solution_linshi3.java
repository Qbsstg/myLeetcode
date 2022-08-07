package linshi;

import javax.naming.spi.ObjectFactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_linshi3 {

    public static void main(String[] args) {
        System.out.println(taskSchedulerII(new int[]{1, 2, 1, 2, 3, 1}, 3));
        System.out.println(taskSchedulerII(new int[]{5,8,8,5}, 2));
        System.out.println(taskSchedulerII(new int[]{1,1}, 1000));
    }

    public static long taskSchedulerII(int[] tasks, int space) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Long> map = new HashMap<>();
        Long day = 0L;
        for (int i = 0; i < tasks.length; i++) {
            int task = tasks[i];
            day++;
            if (map.containsKey(task)){
                Long index = map.get(task);
                if (day-index>space){
                    map.put(task,day);

                }else {
                    day = day+(space-(day-index));
                    i--;
                }
            }else {
                map.put(task,day);
            }
        }
        return day;
    }

}
