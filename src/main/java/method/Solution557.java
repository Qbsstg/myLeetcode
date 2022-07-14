package method;

public class Solution557 {

    public String reverseWords(String s) {

        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String[] split = strings[i].split("");
            reverse(split);
            strings[i] = String.join("", split);
        }
        return String.join(" ",strings);
    }

    private void reverse(String[] strings) {
        int i = 0;
        int j = strings.length - 1;
        if (i == j) {
            return;
        }
        while (true) {
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
            if (i + 1 == j) {
                break;
            }
            i++;
            j++;
            if (i == j) {
                break;
            }
        }
    }

}
