package method;

import java.util.*;

public class Solution973 {


    public int[][] kClosest(int[][] points, int k) {


        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] point : points) {
            int dis = point[0] * point[0] + point[1] * point[1];
            List<int[]> orDefault = map.getOrDefault(dis, new ArrayList<>());
            orDefault.add(point);
            map.put(dis, orDefault);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Integer::compareTo);

        List<int[]> result = new ArrayList<>();

        for (Integer num : list) {
            List<int[]> ints = map.get(num);
            result.addAll(ints);
            if (result.size() == k) {
                break;
            }
        }


        return result.toArray(new int[0][]);
    }

    public int[][] kClosest1(int[][] points, int k) {
        //Arrays.sort(points, Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));
        //return Arrays.copyOfRange(points, 0, k);

        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOfRange(points,0,k);
    }

    public static void main(String[] args) {
        Solution973 solution973 = new Solution973();
        int[][] points = {{1, 3}, {-2, 2}};
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println(Arrays.deepToString(solution973.kClosest(points2, 2)));
        System.out.println(Arrays.deepToString(solution973.kClosest1(points2, 2)));
    }

}
