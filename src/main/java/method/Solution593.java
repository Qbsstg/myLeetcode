package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Qbss
 * @date 2022/7/29
 * @desc
 */
public class Solution593 {


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] p1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] p2 = stringToIntegerArray(line);
            line = in.readLine();
            int[] p3 = stringToIntegerArray(line);
            line = in.readLine();
            int[] p4 = stringToIntegerArray(line);

            boolean ret = new Solution593().validSquare(p1, p2, p3, p4);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }


    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        Map<Integer, List<int[]>> map = new HashMap<>();

        int p1_p2 = (int) (Math.pow((p2[1] - p1[1]), 2) + Math.pow(p2[0] - p1[0], 2));
        if (p1_p2 == 0){
            return false;
        }
        List<int[]> orDefault1 = map.getOrDefault(p1_p2, new ArrayList<>());
        orDefault1.add(p2);
        map.put(p1_p2, orDefault1);

        int p1_p3 = (int) (Math.pow(p3[1] - p1[1], 2) + Math.pow(p3[0] - p1[0], 2));
        if (p1_p3 == 0){
            return false;
        }
        List<int[]> orDefault2 = map.getOrDefault(p1_p3, new ArrayList<>());
        orDefault2.add(p3);
        map.put(p1_p3, orDefault2);

        int p1_p4 = (int) (Math.pow(p4[1] - p1[1], 2) + Math.pow(p4[0] - p1[0], 2));
        if (p1_p4 == 0){
            return false;
        }
        List<int[]> orDefault3 = map.getOrDefault(p1_p4, new ArrayList<>());
        orDefault3.add(p4);
        map.put(p1_p4, orDefault3);

        int p2_p3 = (int) (Math.pow(p3[1] - p2[1], 2) + Math.pow(p3[0] - p2[0], 2));
        if (p2_p3 == 0){
            return false;
        }
        int p2_p4 = (int) (Math.pow(p4[1] - p2[1], 2) + Math.pow(p4[0] - p2[0], 2));
        if (p2_p4 == 0){
            return false;
        }
        int p3_p4 = (int) (Math.pow(p4[1] - p3[1], 2) + Math.pow(p4[0] - p3[0], 2));
        if (p3_p4 == 0){
            return false;
        }
        int[] ans = new int[3];
        ans[0] = p1_p2;
        ans[1] = p1_p3;
        ans[2] = p1_p4;

        Arrays.sort(ans);

        if (ans[0] == ans[1] && ans[2] / 2 == ans[0]) {
            if (map.size() == 2) {
                List<int[]> ints = map.get(ans[2]);
                if (ints.size() == 1) {
                    int[] maxArr = ints.get(0);
                    List<int[]> minArr = map.get(ans[0]);
                    if (minArr.size() == 2) {
                        int a =
                                (int) (Math.pow(minArr.get(0)[1] - maxArr[1], 2) + Math.pow(minArr.get(0)[0] - maxArr[0], 2));
                        int b =
                                (int) (Math.pow(minArr.get(1)[1] - maxArr[1], 2) + Math.pow(minArr.get(1)[0] - maxArr[0], 2));
                        if (a == b) {
                            return a == ans[0];
                        }

                    }
                }
            }
        }

        return false;
    }

}
