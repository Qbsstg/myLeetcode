package method;

/**
 * @author Qbss
 * @date 2021/4/25
 * @desc
 */
public class Solution13 {

    public static void main(String[] args) {
        String str = "III";
        System.out.println(romanToInt(str));
    }

    public static int romanToInt(String s) {

        int result = 0;

        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (i + 1 < split.length) {
                String last = split[i + 1];
                String m = str + last;
                int a = dealMaths(m);
                if (a == 0) {
                    a = dealMaths(str);
                    result += a;
                } else {
                    result += a;
                    i++;
                }
            }else {
                result += dealMaths(str);
            }

        }
        return result;
    }

    private static int dealMaths(String str) {
        return switch (str) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            case "IV" -> 4;
            case "IX" -> 9;
            case "XL" -> 40;
            case "XC" -> 90;
            case "CD" -> 400;
            case "CM" -> 900;
            default -> 0;
        };
    }

}
