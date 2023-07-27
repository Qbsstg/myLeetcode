package honor;

import java.util.Arrays;
import java.util.Scanner;

public class honor3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        int total = Arrays.stream(array).sum();
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (2 * sum + array[i] == total) {
                System.out.println(i);
            }
            sum += array[i];
        }

        System.out.println(-1);


    }
}
