package method;

/**
 * @author Qbss
 * @date 2021/4/9
 * @desc
 */
public class Solution605 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0, 0};
        System.out.println(canPlaceFlowers(nums, 4));
    }


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int a = 0;
        int b = 0;

        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            n = n - 1;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (a + b == 0 && flowerbed[i] == 1) {
                if (i == 0) {
                    break;
                }
                a = i;
                b = i;
                int s = i / 2;
                n = n - s;
                break;
            } else if (i == flowerbed.length - 1) {
                int s = flowerbed.length % 2 == 0 ? flowerbed.length / 2 : (flowerbed.length + 1) / 2;
                n = n - s;
                if (n <= 0) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        if (n <= 0) {
            return true;
        }
        for (int i = a + 1; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                int l = i - b - 1;
                int s = l % 2 == 0 ? (l / 2) - 1 : (l + 1) / 2 - 1;
                n = n - s;
                if (n <= 0) {
                    return true;
                } else {
                    b = i;
                }
            }
            if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0) {
                    int l = i - b;
                    int s = l / 2;
                    n = n - s;
                }
                if (n <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
