package method;

/**
 * @author: Qbss
 * @date: 2023/10/20
 * @desc:
 */
public class Solution2525 {

    public String categorizeBox(int length, int width, int height, int mass) {

        long t = (long) length * width * height;
        boolean Bulky = false;
        boolean Heavy;

        if (length >= 10000 || width >= 10000 || height >= 10000 || t >= 1000000000L) {
            Bulky = true;
        }

        Heavy = mass >= 100;

        if (Bulky && Heavy) {
            return "Both";
        }

        if (!Bulky && !Heavy) {
            return "Neither";
        }

        if (Bulky) {
            return "Bulky";
        }
        return "Heavy";
    }

}
