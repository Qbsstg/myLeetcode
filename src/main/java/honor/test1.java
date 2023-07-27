package honor;

import java.util.Scanner;

public class test1 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(deal(n));


    }

    public static int deal(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        int result = nums[n];
        for (int i = 1; i < n; i++) {
            result = result + (nums[i] * nums[n - i + 1]);
        }
        return result;
    }
}
