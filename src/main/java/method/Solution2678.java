package method;

/**
 * @author: Qbss
 * @date: 2023/10/23
 * @desc:
 */
public class Solution2678 {

    public int countSeniors(String[] details) {


        int count = 0;
        for (String detail : details) {
            count = Integer.parseInt(detail.substring(11, 13)) > 60 ? count + 1 : count;
        }

        return count;
    }

}
