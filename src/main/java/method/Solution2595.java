package method;

/**
 *@author Qbss
 *@date 2025/2/20 10:00
 *@desc 2595. 奇偶位数
 **/
public class Solution2595 {

    public int[] evenOddBit(int n) {
        int even = 0;
        int odd = 0;
        String binaryString = Integer.toBinaryString(n);
        char[] charArray = binaryString.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            int a = charArray.length - 1 - i;
            if (a % 2 == 0) {
                if (charArray[i] == '1') {
                    even++;
                }
            } else {
                if (charArray[i] == '1') {
                    odd++;
                }
            }
        }
        return new int[]{even, odd};
    }

    public int[] evenOddBit1(int n) {
        int even = 0;
        int odd = 0;

        while (n > 0) {
            even += (n & 1);
            n = n >> 1;
            odd += (n & 1);
            n = n >> 1;
        }
        return new int[]{even, odd};
    }

}
