package method;

import java.util.StringTokenizer;

/**
 * @author Qbss
 * @date 2022/8/10
 * @desc
 */
public class Solution640 {


    public static void main(String[] args) {
        //System.out.println(solveEquation("x+5-3+x=6+x-2"));
        //System.out.println(solveEquation("2x=x"));
        System.out.println(solveEquation("x=x+2"));
    }

    public static String solveEquation(String equation) {


        String[] split = equation.split("=");
        if (split[0].equals(split[1])) {
            return "Infinite solutions";
        }

        int[] nums1 = new int[2];
        int[] nums2 = new int[2];

        String action = "+";

        StringTokenizer stringTokenizer1 = new StringTokenizer(split[0], "+-", true);

        while (stringTokenizer1.hasMoreTokens()) {
            String s = stringTokenizer1.nextToken();
            if ("+-".contains(s)) {
                action = s;
            } else {
                int anInt = 1;
                if (s.contains("x")) {
                    if (s.length() > 1) {
                        anInt = Integer.parseInt(s.substring(0, s.length() - 1));
                    }
                    if (action.equals("+")) {
                        nums1[0] += anInt;
                    } else {
                        nums1[0] -= anInt;
                    }

                } else {
                    anInt = Integer.parseInt(s);
                    if (action.equals("+")) {
                        nums1[1] += anInt;
                    } else {
                        nums1[1] -= anInt;
                    }
                }
            }
        }

        action = "+";
        StringTokenizer stringTokenizer2 = new StringTokenizer(split[1], "+-", true);
        while (stringTokenizer2.hasMoreTokens()) {
            String s = stringTokenizer2.nextToken();
            if ("+-".contains(s)) {
                action = s;
            } else {
                int anInt = 1;
                if (s.contains("x")) {
                    if (s.length() > 1) {
                        anInt = Integer.parseInt(s.substring(0, s.length() - 1));
                    }
                    if (action.equals("+")) {
                        nums2[0] += anInt;
                    } else {
                        nums2[0] -= anInt;
                    }

                } else {
                    anInt = Integer.parseInt(s);
                    if (action.equals("+")) {
                        nums2[1] += anInt;
                    } else {
                        nums2[1] -= anInt;
                    }
                }
            }
        }

        int i = nums1[0] - nums2[0];
        if (i == 0) {
            if (nums2[1] - nums1[1] != 0) {
                return "No solutions";
            }
            return "Infinite solutions";
        } else {
            return "x=" + (nums2[1] - nums1[1]) / i;
        }
    }


}
