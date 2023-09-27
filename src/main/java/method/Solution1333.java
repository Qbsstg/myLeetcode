package method;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Qbss
 * @date: 2023/9/27
 * @desc:
 */
public class Solution1333 {

    static class restaurant {
        int id;

        int rating;

        int veganFriendly;

        int price;

        int distance;

        public restaurant(int id, int rating, int veganFriendly, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.veganFriendly = veganFriendly;
            this.price = price;
            this.distance = distance;
        }
    }

    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(x -> (veganFriendly == 0 || veganFriendly == x[2]) && x[3] <= maxPrice && x[4] <= maxDistance)
                .sorted(Comparator.comparingInt((int[] r) -> -r[1]).thenComparingInt(r -> -r[0]))
                .map(x -> x[0]).toList();
    }

    public static List<Integer> filterRestaurants1(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays
                .stream(restaurants)
                .map(x -> new restaurant(x[0], x[1], x[2], x[3], x[4]))
                .filter(x -> (veganFriendly == 0 || veganFriendly == x.veganFriendly) && x.price <= maxPrice && x.distance <= maxDistance)
                .sorted((r1, r2) -> {
                    if (r1.rating == r2.rating) {
                        return r2.id - r1.id;
                    }
                    return r2.rating - r1.rating;
                })
                .map(x -> x.id).toList();


    }


    public static void main(String[] args) {

        int[][] restaurants = {{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        filterRestaurants(restaurants, 1, 50, 10);
    }


}
