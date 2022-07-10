package method;

public class Solution6114 {

    public static void main(String[] args) {
        String start = "_L__R__R_";
        String targe = "L______RR";
        System.out.println(canChange(start, targe));
    }

    public static boolean canChange(String start, String target) {
        String[] startSplit = start.split("");
        String[] targetSplit = target.split("");

        int j = 0;
        for (int i = 0; i < startSplit.length; i++) {
            String s = startSplit[i];
            if (s.equals("R")) {
                while (j < targetSplit.length) {
                    String t = targetSplit[j];
                    if (t.equals(s)) {
                        if (!moveRight(startSplit, i, j)) {
                            return false;
                        }else {
                            j++;
                            break;
                        }
                    } else if (t.equals("_")) {
                        j++;
                    } else {
                        return false;
                    }
                }
            } else if (s.equals("L")) {
                while (j < targetSplit.length) {
                    String t = targetSplit[j];
                    if (t.equals(s)) {
                        if (!moveLeft(startSplit, i, j)) {
                            return false;
                        }else {
                            j++;
                            break;
                        }
                    } else if (t.equals("_")) {
                        j++;
                    } else {
                        return false;
                    }
                }
                if (j == targetSplit.length){
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean moveLeft(String[] startSplit, int start, int end) {
        if (start + end < 0) {
            return true;
        }
        if (end > start) {
            return false;
        }
        for (int i = start - 1; i >= end; i--) {
            if (!(startSplit[i].equals("_") || startSplit[i].equals("L"))) {
                return false;
            }
        }
        return true;
    }

    public static boolean moveRight(String[] startSplit, int start, int end) {
        if (start + end < 0) {
            return true;
        }
        if (end < start) {
            return false;
        }
        for (int i = start + 1; i <= end; i++) {
            if (!(startSplit[i].equals("_") || startSplit[i].equals("R"))) {
                return false;
            }
        }
        return true;
    }
}
