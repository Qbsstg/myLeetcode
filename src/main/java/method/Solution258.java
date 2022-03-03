package method;

/**
 * @author Qbss
 * @date 2022/3/3
 * @desc
 */
public class Solution258 {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addF(38));
    }

    //数字根,存在公式
    public static int addDigits(int num) {


        return (num - 1) % 9 + 1;



    }

    private static int addF(int num) {

        if (num / 10 == 0) {
            return num;
        }

        int total = num % 10;

        while (num / 10 > 0) {
            num = num / 10;
            total = total + num % 10;
        }

        return addF(total);

    }

}
