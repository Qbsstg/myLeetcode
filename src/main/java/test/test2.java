package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Qbss
 * @date 2022/8/24
 * @desc
 */
public class test2 {

    public static void main(String[] args) {

        int[] nums = new int[3];
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());

    }
}
