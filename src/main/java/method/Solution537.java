package method;

/**
 * @author Qbss
 * @date 2022/2/25
 * @desc
 */
public class Solution537 {


    public static void main(String[] args) {

        String num1 = "1+-1i";
        String num2 = "0+0i";
        System.out.println(complexNumberMultiply(num1, num2));

    }

    public static String complexNumberMultiply(String num1, String num2) {

        String[] split1 = num1.split("\\+");

        String num1_1 = split1[0]; //1
        String num1_2 = split1[1];

        String num1_2_1 = num1_2.split("i")[0];//2

        String[] split2 = num2.split("\\+");

        String num2_1 = split2[0]; //1
        String num2_2 = split2[1];

        String num2_2_1 = num2_2.split("i")[0];//2

        int a = Integer.parseInt(num1_1) * Integer.parseInt(num2_1);

        int b = Integer.parseInt(num1_2_1) * Integer.parseInt(num2_1);

        int c = Integer.parseInt(num1_1) * Integer.parseInt(num2_2_1);

        int d = Integer.parseInt(num1_2_1) * Integer.parseInt(num2_2_1);

        int A = a + (-1) * d;

        int B = b + c;

        return A + "+" + B + "i";
    }

}
