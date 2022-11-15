package method;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/11/15
 * @desc
 */
public class Solution1710 {

    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;

        System.out.println(maximumUnits(boxTypes, truckSize));

    }


    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        List<Integer> list = new ArrayList<>();

        for (int[] boxType : boxTypes) {
            for (int j = 0; j < boxType[0]; j++) {
                list.add(boxType[1]);
            }
        }

        int result = 0;
        list.sort(Comparator.comparingInt(o -> o * -1));
        int l = list.size();

        for (int i = 0; i < truckSize; i++) {
            if (i == l){
                break;
            }
            result += list.get(i);
        }

        return result;

    }

}
