package method;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Qbss
 * @date: 2023/10/11
 * @desc:
 */
public class Solution2512 {

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveFeedback = Arrays.stream(positive_feedback).collect(Collectors.toSet());
        Set<String> negativeFeedback = Arrays.stream(negative_feedback).collect(Collectors.toSet());

        int length = report.length;
        List<int[]> list = new ArrayList<>();

         for (int i = 0; i < length; i++) {
            int score = 0;
            String s = report[i];
            String[] split = s.split(" ");
            for (String key : split) {
                if (positiveFeedback.contains(key)) {
                    score+=3;
                    continue;
                }
                if (negativeFeedback.contains(key)) {
                    score--;
                }

            }
            list.add(new int[]{student_id[i], score});
        }

        list.sort(Comparator.comparingInt((int[] r) -> -r[1]).thenComparingInt(r -> r[0]));

        return list.subList(0, k).stream().map(x -> x[0]).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        String[] positive_feedback = {"yewmhbgnq", "vqhhuaejqw"};
        String[] negative_feedback = {"zjeyq", "oyuetqe", "ks", "vuvannpwa", "qfd", "xv", "aauvtxrdt", "gml", "eaky", "mwip"};
        String[] report = {"lqiuderzod mwip vqhhuaejqw xrn aqjzkqjsi riuood yewmhbgnq xv nmcvqm onhkkmy",
                "uccz yewmhbgnq rcxdaqicbe vqhhuaejqw yewmhbgnq e vqhhuaejqw b yewmhbgnq vqhhuaejqw",
                "eaky yewmhbgnq eaky dwdzl yewmhbgnq yewmhbgnq ntqpnqtmnb qfd ks gvumi",
                "ecutvv vqhhuaejqw vqhhuaejqw inu vqhhuaejqw vqhhuaejqw uu eodzum zjeyq fxebx",
                "vqhhuaejqw m vuvannpwa mwip atvjp vqhhuaejqw eaky yewmhbgnq vqhhuaejqw yewmhbgnq"};
        int[] student_id = {581094748, 245764367, 905556075, 127263030, 415068015};
        int k = 4;


        System.out.println(topStudents(positive_feedback, negative_feedback, report, student_id, k));
    }
}
