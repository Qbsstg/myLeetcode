package method;

public class Solution1184 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(distanceBetweenBusStops(nums, 0, 1));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {

        if (start == destination) {
            return 0;
        }

        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int sum = 0;
        for (int i = start; i < destination; i++) {
            sum += distance[i];
        }

        int sum1 = 0;
        for (int i = 0; i < start; i++) {
            sum1 += distance[i];
        }

        if (sum1 >= sum) {
            return sum;
        }

        for (int i = destination; i < distance.length; i++) {
            sum1 += distance[i];
            if (sum1 >= sum) {
                return sum;
            }
        }

        return sum1;
    }

}
