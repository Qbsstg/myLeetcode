package contest.weekly.w307;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        //System.out.println(largestPalindromic("444947137"));
        //System.out.println(largestPalindromic("00001105"));
        System.out.println(largestPalindromic("00009"));
    }

    public static String largestPalindromic(String num) {

        int[] nums = new int[10];
        char[] chars = num.toCharArray();

        for (char aChar : chars) {
            nums[aChar - '0'] += 1;
        }

        Map<Integer, Integer> map1 = new TreeMap<>((o1, o2) -> o1.compareTo(o2) * -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map1.put(i, nums[i]);
            }
        }

        List<Integer> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer value = next.getValue();
            if (next.getKey() == 0&&list.isEmpty()){
                continue;
            }
            for (int i = 1; i <= value / 2; i++) {
                list.add(next.getKey());
            }
            if (value - (value / 2) * 2 == 0) {
                nums[next.getKey()] = 0;
            }
        }


        StringBuilder stringBuffer = new StringBuilder();
        for (Integer integer : list) {
            stringBuffer.append(integer);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0){
                stringBuffer.append(i);
                break;
            }
        }

        Collections.reverse(list);

        for (Integer integer : list) {
            stringBuffer.append(integer);
        }

        return stringBuffer.toString();

    }
}
