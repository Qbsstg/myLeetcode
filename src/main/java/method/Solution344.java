package method;

public class Solution344 {

    public static void main(String[] args) {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {

        int i = 0;
        int j = s.length - 1;
        if (i == j){
            return;
        }
        while (true) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            if (i + 1 == j) break;
            i++;
            j--;
            if (i == j) break;

        }

    }
}
