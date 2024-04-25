package method;

/**
 * @author: Qbss
 * @date: 2024/4/25
 * @desc: 2739. 总行驶距离
 */
public class Solution2379 {

    public static int distanceTraveled(int mainTank, int additionalTank) {

        int distance = 0;

        while (mainTank >= 5) {
            mainTank -= 5;
            distance += 5;
            if (additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }

        return (distance + mainTank) * 10;

    }

}
