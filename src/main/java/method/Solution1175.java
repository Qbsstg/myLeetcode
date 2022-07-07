package method;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Qbss
 * @date 2022/6/30
 * @desc
 */
public class Solution1175 {


    public static void main(String[] args) {

        //BigDecimal bigDecimal = factBigDecimal(25);
        //BigDecimal bigDecimal1 = factBigDecimal(75);
        //
        //BigDecimal divide =
        //        bigDecimal1.multiply(bigDecimal).divideAndRemainder(new BigDecimal(10).pow(9).add(new BigDecimal(7)))[1];


        //System.out.println(divide);
        //factBigDecimal(3);
        //factBigDecimal(2);
        //System.out.println(numPrimeArrangements(5));

        System.out.println(factBigDecimal(9));

        //System.out.println(list.size());

    }

    public static int numPrimeArrangements(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if ((i % 2 == 0 && i != 2)||(i % 3 == 0 && i != 3)||(i % 5 == 0 && i != 5)||(Math.sqrt(i) % 1 == 0)) {
                continue;
            }
            if (list.size() == 0) {
                list.add(i);
            }
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (i % list.get(i1) == 0) {
                    break;
                }
                if (i1 == list.size() - 1) {
                    list.add(i);
                }
            }
        }
        int count = list.size();

        BigDecimal divide =
                factBigDecimal(count).multiply(factBigDecimal(n - count)).divideAndRemainder(new BigDecimal(10).pow(9).add(new BigDecimal(7)))[1];
        return divide.intValue();
    }

    public static BigDecimal factBigDecimal(int n) {
        BigDecimal result = new BigDecimal(1);
        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }

}
