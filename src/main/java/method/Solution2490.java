package method;

public class Solution2490 {


    public boolean isCircularSentence(String sentence) {

        String[] s = sentence.split(" ");

        String substring = s[0].substring(s[0].length() - 1);

        if (s.length == 1) {
            return s[0].startsWith(substring);
        }

        for (int i = 1; i < s.length; i++) {
            String s1 = s[i];
            if (s1.startsWith(substring)) {
                substring = s1.substring(s1.length() - 1);
                if (i == s.length - 1) {
                    return s[0].startsWith(substring);
                }
            } else {
                return false;
            }
        }
        return true;

    }

}
