package contest.biweekly.b85;

public class Solution2 {


    public int secondsToRemoveOccurrences(String s) {

        int i = 0;
        while (s.contains("01")){
            i++;
            s = s.replaceAll("01","10");
        }
        return i;
    }

    public static void main(String[] args) {
        String s = "0110101";
        System.out.println(s.replaceAll("01", "10"));
    }
}
