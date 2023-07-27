package honor;

import java.util.Arrays;
import java.util.Scanner;

public class honor5 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            if (a == 0) {
                int left = i - 1;
                int right = i + 1;

                if (left >= 0 && right < array.length && array[left] == 0 && array[right] == 0) {
                    result++;
                    array[i] = 1;
                }
            }
        }
        System.out.println(result);
    }
}
