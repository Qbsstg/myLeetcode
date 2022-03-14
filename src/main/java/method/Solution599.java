package method;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Qbss
 * @date 2022/3/14
 * @desc
 */
public class Solution599 {

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {

        List<String> collect = Arrays.stream(list1).collect(Collectors.toList());

        Map<Integer, List<String>> result = new TreeMap<>();

        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            int indexOf = collect.indexOf(s);
            if (indexOf != -1) {
                int info = indexOf + i;
                if (result.containsKey(info)) {
                    result.get(info).add(s);
                } else {
                    result.put(info,  new ArrayList<>(Arrays.asList(s)));
                }
            }
        }

        List<String> list = result.values().stream().findFirst().get();

        return list.toArray(new String[list.size()]);
    }


}
