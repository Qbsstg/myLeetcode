package method;

/**
 * @author: Qbss
 * @date: 2023/10/26
 * @desc:
 */
public class Solution2520 {

    public int countDigits(int num) {

        String[] split = String.valueOf(num).split("");
        int count = 0;
        for (String s : split) {
            if (Integer.parseInt(s) != 0) {
                if (num % Integer.parseInt(s) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countDigits1(int num) {
        String[] split = String.valueOf(num).split("");
        int count = 0;
        for (String s : split) {
            if (Integer.parseInt(s) != 0 && num % Integer.parseInt(s) == 0) {
                count++;
            }
        }
        return count;
    }

    public int countDigits2(int num) {
        return (int) String.valueOf(num).chars()
                .map(Character::getNumericValue)
                .filter(digit -> digit != 0 && num % digit == 0)
                .count();
    }

    public int countDigits3(int num) {
        int originalNum = num;
        int count = 0;

        while (num != 0) {
            int digit = num % 10;
            if (digit != 0 && originalNum % digit == 0) {
                count++;
            }
            num /= 10;
        }

        return count;
    }




}
