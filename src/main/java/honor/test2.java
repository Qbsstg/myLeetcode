package honor;

import java.util.*;

public class test2 {

    public static class XD {
        private Integer x1;
        private Integer y1;
        private Integer x2;
        private Integer y2;

        public XD() {

        }

        public XD(Integer x1, Integer y1, Integer x2, Integer y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private static class D {
        private Integer x;
        private Integer y;

        public D() {
        }

        public D(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "D{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {

        String s = "L={-6,2,-4,5|-3,6,2,5|3,4,1,-3|-2,-3,-6,-2},Q={-4,7|2,7|4,5|3,-3|1,-5|-5,-4|-7,-1|-8,4},P=-2,2";

        StringTokenizer str1 = new StringTokenizer(s, "{}");
        List<String> list = new ArrayList<>();

        while (str1.hasMoreTokens()) {
            list.add(str1.nextToken());
        }

        String[] L = list.get(1).split("\\|");
        String[] Q = list.get(3).split("\\|");
        int[] P = Arrays.stream(list.get(4).substring(3).split(",")).mapToInt(Integer::parseInt).toArray();

        List<XD> xdList = new ArrayList<>();
        for (String value : L) {
            int[] split = Arrays.stream(value.split(",")).mapToInt(Integer::parseInt).toArray();
            xdList.add(new XD(split[0], split[1], split[2], split[3]));
        }

        List<D> dList = new ArrayList<>();
        for (String value : Q) {
            int[] split = Arrays.stream(value.split(",")).mapToInt(Integer::parseInt).toArray();
            dList.add(new D(split[0], split[1]));
        }

        for (D d : dList) {
            boolean temp = true;
            for (XD xd : xdList) {
                if (!check(xd, d, P)) {
                    temp = false;
                    break;
                }
            }
            if (temp){
                System.out.print("("+d.x+","+d.y+")");
            }
        }


    }

    //true 代表没有交点
    private static boolean check(XD xd, D d, int[] pos) {
        int max_x;
        int min_x;

        int max_y;
        int min_y;

        if (d.x > pos[0]) {
            max_x = d.x;
            min_x = pos[0];
        } else {
            max_x = pos[0];
            min_x = d.x;
        }

        if (d.y > pos[1]) {
            max_y = d.y;
            ;
            min_y = pos[1];
        } else {
            max_y = pos[1];
            min_y = d.y;
        }

        if ((Math.max(xd.x1, xd.x2) < min_x && (Math.max(xd.y1, xd.y2) < min_y || Math.min(xd.y1, xd.y2) > max_y)) ||
                (Math.min(xd.x1, xd.x2) > max_x && (Math.max(xd.x1, xd.y2) < min_y) || Math.min(xd.y1, xd.y2) > max_y)) {
            return true;
        }

//        不代表一定有交点，可能平行

//        d-a
        D D_A = new D(-d.x + xd.x1, -d.y + xd.y1);
//        B-A
        D B_A = new D(pos[0] - d.x, pos[1] - d.y);
//        C-A
        D C_A = new D(xd.x2 - d.x, xd.y2 - d.y);
//           A_C
        D A_C = new D(d.x - xd.x2, d.y - xd.y2);
//        B-C
        D B_C = new D(pos[0] - xd.x2, pos[1] - xd.y2);
//        D-C
        D D_C = new D(xd.x1 - xd.x2, xd.y1 - xd.y2);

//        (D-A)*(B-A)
        int DABA = D_A.x * B_A.y - D_A.y * B_A.x;
//        (C-A)*(B-A)
        int CABA = C_A.x * B_A.y - C_A.y * B_A.x;

//        (A-C)*(D-C)
        int ACDC = A_C.x * D_C.y - A_C.y * D_C.x;
//        (B-C)*(D-C)
        int BCDC = B_C.x * D_C.y - B_C.y * D_C.x;

        return (DABA * CABA > 0) || (ACDC * BCDC > 0);
    }
}
