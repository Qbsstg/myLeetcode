package acWing;

import java.util.Scanner;

public class Solution3391 {

   int[] nums = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            boolean temp = (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
            int total = c;
            for (int i = 1; i < b; i++) {
                total += getDay(i, temp);
            }
            System.out.println(total);

        }
    }


    private static int getDay(int month, boolean temp) {
        switch (month) {
            case 4, 6, 9, 11:
                return 30;
            case 2:
                if (temp) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }

    }


}
