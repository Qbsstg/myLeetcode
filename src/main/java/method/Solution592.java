package method;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Qbss
 * @date 2022/7/27
 * @desc
 */
public class Solution592 {

    public static void main(String[] args) {
        String expression = "-1/2+1/2";
        String expression1 = "-1/2+1/2+1/3";
        String expression2 = "1/3-1/2";
        String expression3 = "2/5-1/1-2/1";
        String expression4 = "1/3-5/4+3/10";
        //System.out.println(fractionAddition(expression));
        //System.out.println(fractionAddition(expression1));
        System.out.println(fractionAddition(expression4));
        //System.out.println(gcd(0, 2));

    }

    public static String fractionAddition(String expression) {

        if (!expression.startsWith("-")) {
            expression = "+" + expression;
        }
        int length = expression.length();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; ) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+') {
                int j = i + 1;
                for (; j < length; j++) {
                    char c1 = expression.charAt(j);
                    if (c1 == '-' || c1 == '+') {
                        break;
                    }
                }
                String[] substring = expression.substring(i, j).split("/");
                String s = substring[0];
                String s1 = substring[1];

                int fenzi = Integer.parseInt(s);
                int fenmu = Integer.parseInt(s1);

                Integer orDefault = map.getOrDefault(fenmu, 0);
                fenzi = fenzi + orDefault;
                map.put(fenmu, fenzi);
                i = j;
            }


        }

        final String[] sum = {"0"};
        map.forEach((k, v) -> {
            if (sum[0].equals("0")) {
                sum[0] = v + "/" + k;
            } else {
                sum[0] = add(sum[0], v + "/" + k);
            }
        });

        String[] split = sum[0].split("/");
        int gcd = gcd(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        if (gcd < 0) gcd = -gcd;
        return Integer.parseInt(split[0]) / gcd + "/" + Integer.parseInt(split[1]) / gcd;

    }

    private static String add(String a, String b) {

        if (a.equals("0")) {
            return b;
        }

        String[] split = a.split("/");
        String[] split1 = b.split("/");

        if (split[0].equals("0")) {
            return b;
        }

        if (Objects.equals(split1[1], split[1])) {
            return Integer.valueOf(split[0]) + Integer.valueOf(split1[0]) + "/" + split1[1];
        } else {

            Integer in1 = Integer.valueOf(split1[1]);
            Integer in0 = Integer.valueOf(split[1]);


            int k = 0;
            if (in1 > in0 && in1 % in0 == 0) {
                k = in1;
            } else if (in0 > in1 && in0 % in1 == 0) {
                k = in0;
            }

            if (k == 0) {
                return Integer.parseInt(split[0]) * in1 + Integer.parseInt(split1[0]) * in0 + "/" + in0 * in1;
            } else {
                int i = k / in0;
                int i1 = k / in1;
                return Integer.parseInt(split[0]) * i + Integer.parseInt(split1[0]) * i1 + "/" + k;
            }
        }
    }

    private static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


}
