package method;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Qbss
 * @date 2021/3/29
 * @desc
 */
public class Solution414 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,4,1,3,6,0};
        System.out.println(thirdMax(nums));
    }


    public static int thirdMax(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for (int num : nums) {
            if (set.size() < 4) {
                if (set.size() ==3){
                    if (!set.contains(num)){
                        set.add(num);
                        set.remove(set.last());
                    }
                }else {
                    set.add(num);
                }
            }
        }
        return set.size() < 3?set.first():set.last();
    }


}
