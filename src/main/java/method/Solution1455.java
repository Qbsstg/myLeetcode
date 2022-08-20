package method;

public class Solution1455 {

    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("i love eating burge", "burg"));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }
}
