package contest.weekly.w307;

import java.util.Arrays;

public class Solution1 {


    public static void main(String[] args) {
        //System.out.println(minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
        System.out.println(minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1,1, 1, 50}));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy,
                                       int[] experience) {

        int n = energy.length;
        int count = 0;
        int sum = Arrays.stream(energy).sum();

        if (sum >= initialEnergy) {
            count = count + sum - initialEnergy + 1;
        }

        for (int i = 0; i < n; i++) {
            if (initialExperience > experience[i]){
                initialExperience += experience[i];
            }else {
                count = count+ experience[i]-initialExperience+1;
                initialExperience = experience[i]+1;
                initialExperience+= experience[i];
            }
        }

    return count;
    }
}
