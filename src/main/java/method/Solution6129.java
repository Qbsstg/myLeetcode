package method;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Solution6129 {

    public static void main(String[] args) {

        //int[] num = {1, 3, 0, 0, 2, 0, 0, 4};
        int[] num = {0, 0, 0, 2, 0, 0};
        //int[] num = {0, 12, 0, 12, 0, -8, 0, -18, 0, -11, 0};
        System.out.println(zeroFilledSubarray(num));
        ;
    }

    public static long zeroFilledSubarray(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();

        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 1;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                int count = 1;
                if (j < nums.length && nums[j] == 0) {
                    for (; j < nums.length; j++) {
                        if (nums[j] == 0) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    i = j;
                    map.put(count, map.getOrDefault(count, 0) + 1);
                } else {
                    map.put(count, map.getOrDefault(count, 0) + 1);
                }
            }

        }


        final Long[] sum = {0L};

        map.forEach((k, v) -> {
            long i = add(k) * v;
            sum[0] += i;
        });

        return sum[0];

    }

    private static Long add(int a) {
        long sum = 0L;
        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        return sum;
    }


}
