package method;

/**
 * @author: Qbss
 * @date: 2024/6/18
 * @desc:
 */
public class Solution2288 {

    public static void main(String[] args) {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        System.out.println(discountPrices(sentence, discount));
    }

    public static String discountPrices(String sentence, int discount) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (check(s[i])) {
                long value = Long.parseLong(s[i].substring(1));
                double v = value * (100 - discount) * 0.01;
                s[i] = "$" + String.format("%.2f", v);
            }
        }

        return String.join(" ", s);
    }

    // 判断一个字符是否为金额
    private static boolean check(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.startsWith("$")) {
            return checkMath(s.substring(1));
        }
        return false;
    }

    private static boolean checkMath(String s) {
        try {
            Long.parseLong(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
