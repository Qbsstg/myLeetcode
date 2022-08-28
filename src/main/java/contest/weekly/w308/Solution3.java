package contest.weekly.w308;

public class Solution3 {

    public static void main(String[] args) {
        //System.out.println(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        System.out.println(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {

        int GIndex = -1;
        int PIndex = -1;
        int MIndex = -1;

        int GTime = 0;
        int PTime = 0;
        int MTime = 0;

        int tL = travel.length;
        int[] sums = new int[tL];
        int sum = 0;

        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == 'M') {
                    MIndex = i;
                    MTime++;
                } else if (aChar == 'P') {
                    PIndex = i;
                    PTime++;
                } else if (aChar == 'G') {
                    GIndex = i;
                    GTime++;
                }
            }
            if (i < garbage.length - 1) {
                GTime += travel[i];
                PTime += travel[i];
                MTime += travel[i];
                sum = sum + travel[tL - 1 - i];
                sums[i] = sum;
            }
        }

        int res = 0;
        if (GIndex != -1) {
            if (GIndex == garbage.length - 1) {
                res += GTime;
            }else {
                res = res + (GTime - sums[garbage.length - 1 - GIndex - 1]);
            }
        }
        if (PIndex != -1) {
            if (PIndex == garbage.length - 1) {
                res += PTime;
            } else {
                res = res + (PTime - sums[garbage.length - 1 - PIndex - 1]);
            }
        }
        if (MIndex != -1) {
            if (MIndex == garbage.length - 1) {
                res += MTime;
            } else {
                res = res + (MTime - sums[garbage.length - 1 - MIndex - 1]);
            }
        }

        return res;
    }

}
