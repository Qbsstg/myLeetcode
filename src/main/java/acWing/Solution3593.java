package acWing;

import java.util.Scanner;

public class Solution3593 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.substring(0, s.length() - 1);
        String[] split = s.split(" ");
        for (String value : split) {
            if (value.length() > 0){
                System.out.print(value.length()+" ");
            }
        }
    }
}
