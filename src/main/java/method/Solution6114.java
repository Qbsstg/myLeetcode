package method;

public class Solution6114 {

    public static void main(String[] args) {
        String start = "_LL__R__R_";
        String targe = "L___L___RR";
        System.out.println(canChange(start, targe));
    }

    public static boolean canChange(String start, String target) {
        String[] startSplit = start.split("");

        int startL = start.lastIndexOf("L");
        int startR = start.indexOf("R");

        int targetL = target.lastIndexOf("L");
        int targetR = target.indexOf("R");

        String startReplace = start.replace("_", "");
        String targetReplace = target.replace("_", "");

        if (!startReplace.equals(targetReplace)) {
            return false;
        }

        return moveLeft(startSplit, startL, targetL) && moveRight(startSplit, startR, targetR);

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
