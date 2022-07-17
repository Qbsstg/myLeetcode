package method;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution6121 {

    public static void main(String[] args) {
        //String[] nums = {"102", "473", "251", "814"};
        //int[][] queries = {{1, 1}, {2, 3}, {4, 2}, {1, 2}};

        String[] nums = {"24", "37", "96", "04"};
        int[][] queries = {{2, 1}, {2, 2}};

        System.out.println(Arrays.toString(smallestTrimmedNumbers(nums, queries)));
        ;
        System.out.println(Integer.valueOf("5953866768"));
    }


    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        int[] result = new int[queries.length];
        int length = nums[0].length();

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            String[] ans = new String[nums.length];


            for (int j = 0; j < nums.length; j++) {
                ans[j] = nums[j].substring(length - query[1]) + "_" + j;
            }
            List<String> collect = Arrays.stream(ans).sorted((o1, o2) -> {

                String[] split1 = o1.split("_");
                String[] split2 = o2.split("_");


                if (split1[0].equals(split2[0])) {
                    Integer index1 = Integer.valueOf(split1[1]);
                    Integer index2 = Integer.valueOf(split2[1]);
                    if (index1.equals(index2)) {
                        return 0;
                    } else if (index1 < index2) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    BigInteger i1 = new BigInteger(split1[0]);
                    BigInteger i2 = new BigInteger(split2[0]);
                    return i1.compareTo(i2);
                }
            }).collect(Collectors.toList());
            result[i] = Integer.parseInt(collect.get(query[0] - 1).split("_")[1]);
        }
        return result;
    }
}
