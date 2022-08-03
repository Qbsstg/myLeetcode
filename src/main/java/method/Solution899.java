package method;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Qbss
 * @date 2022/8/3
 * @desc
 */
public class Solution899 {

    public static void main(String[] args) {
        String s = "cba";
        int k = 1;
        //System.out.println(orderlyQueue("xmvzi", 2));
        System.out.println(orderlyQueue("dbcea", 1));
        //System.out.println((int) 'x');
        //System.out.println((int) 'm');
        //System.out.println((int) 'v');
        //System.out.println((int) 'z');
        //System.out.println((int) 'i');
    }


    public static String orderlyQueue(String s, int k) {

        char[] chars = s.toCharArray();

        if (k == 1) {
            TreeSet<String> res = new TreeSet<>();
            for (int i = 0; i < chars.length; i++) {
                res.add(new String(Arrays.copyOfRange(chars,i,chars.length))+new String(Arrays.copyOfRange(chars,0,i)));
            }
            return res.stream().findFirst().get();
        }
        if (k == 2) {
            Arrays.sort(chars);
        }
        return new String(chars);

    }


}
