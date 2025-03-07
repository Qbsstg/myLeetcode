package method;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *@author Qbss
 *@date 2025/2/28 11:39
 *@desc TODO
 **/
public class Solution2353 {

    class FoodRatings {

        Map<String, TreeSet<foodInfo>> foodInfoMap;
        Map<String, foodInfo> foodName;

        static class foodInfo {
            String name;
            String cuisine;
            int rating;
            int index;
        }


        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

            this.foodInfoMap = new HashMap<>();
            this.foodName = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                foodInfo foodInfo = new foodInfo();
                String food = foods[i];
                foodInfo.name = food;
                String cuisine = cuisines[i];
                foodInfo.cuisine = cuisine;
                foodInfo.rating = ratings[i];
                foodInfo.index = i;
                TreeSet<FoodRatings.foodInfo> orDefault = foodInfoMap.getOrDefault(cuisine, new TreeSet<>((o1, o2) -> {
                    if (o1.rating == o2.rating) {
                        return o1.name.compareTo(o2.name);
                    }
                    return Integer.compare(o1.rating, o2.rating) * -1;
                }));
                orDefault.add(foodInfo);
                this.foodInfoMap.put(cuisine, orDefault);
                this.foodName.put(food, foodInfo);
            }
        }

        public void changeRating(String food, int newRating) {
            foodInfo foodInfo = this.foodName.get(food);
            String cuisine = foodInfo.cuisine;
            this.foodInfoMap.get(cuisine).remove(foodInfo);
            foodInfo.rating = newRating;
            this.foodInfoMap.get(cuisine).add(foodInfo);

        }

        public String highestRated(String cuisine) {

            return this.foodInfoMap.get(cuisine).stream().findFirst().get().name;
        }
    }

}
