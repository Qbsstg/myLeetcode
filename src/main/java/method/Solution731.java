package method;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Qbss
 * @date 2022/7/19
 * @desc
 */
public class Solution731 {

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(10, 20);
        myCalendarTwo.book(50, 60);
        myCalendarTwo.book(10, 40);
        myCalendarTwo.book(5, 15);
        myCalendarTwo.book(5, 10);
        myCalendarTwo.book(25, 55);


        //myCalendarTwo.book(47, 50);
        //myCalendarTwo.book(1, 10);
        //myCalendarTwo.book(27, 36);
        //myCalendarTwo.book(40, 47);
        //myCalendarTwo.book(20, 27);
        //myCalendarTwo.book(15, 23);
        //myCalendarTwo.book(10, 18);
        //myCalendarTwo.book(27, 36);
        //myCalendarTwo.book(17, 25);
        //myCalendarTwo.book(8, 17);
        //myCalendarTwo.book(24, 33);
        //myCalendarTwo.book(23, 28);
        //myCalendarTwo.book(21, 27);
        //myCalendarTwo.book(47, 50);
        //myCalendarTwo.book(14, 21);
        //myCalendarTwo.book(26, 32);
        //myCalendarTwo.book(16, 21);
        //myCalendarTwo.book(2, 7);
        //myCalendarTwo.book(24, 33);
        //myCalendarTwo.book(6, 13);
        //
        //System.out.println(myCalendarTwo.book(44, 50));
        //myCalendarTwo.book(33, 39);
        //myCalendarTwo.book(30, 36);
        //myCalendarTwo.book(6, 15);
        //myCalendarTwo.book(21, 27);
        //
        //myCalendarTwo.book(49, 50);
        //myCalendarTwo.book(38, 45);
        //myCalendarTwo.book(4, 12);
        //myCalendarTwo.book(46, 50);
        //myCalendarTwo.book(13, 21);

        //myCalendarTwo.book(26, 35);
        //myCalendarTwo.book(26, 32);
        //myCalendarTwo.book(25, 32);
        //myCalendarTwo.book(18, 26);
        //myCalendarTwo.book(40, 45);
        //myCalendarTwo.book(19, 26);
        //myCalendarTwo.book(48, 50);
        //myCalendarTwo.book(1, 6);
        //myCalendarTwo.book(46, 50);
        //myCalendarTwo.book(11, 18);

    }


    static class MyCalendarTwo {


        private TreeSet<int[]> treeSetFirst;

        private TreeSet<int[]> treeSetSecond;


        public MyCalendarTwo() {
            this.treeSetFirst = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
            this.treeSetSecond = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        }

        public boolean book(int start, int end) {


            if (treeSetFirst.isEmpty()) {
                treeSetFirst.add(new int[]{start, end});
                return true;
            }

            int[] ceiling = treeSetFirst.ceiling(new int[]{end, 0});
            int[] arr = ceiling == null ? treeSetFirst.last() : treeSetFirst.lower(new int[]{end, 0});

            if (ceiling == this.treeSetFirst.first() || arr[1] <= start) {
                treeSetFirst.add(new int[]{start, end});
                return true;
            } else {
                if (treeSetSecond.isEmpty()) {
                    treeSetSecond.add(new int[]{start, end});
                    return true;
                }

                int[] ints = treeSetSecond.ceiling(new int[]{end, 0});
                int[] arr1 = ints == null ? treeSetSecond.last() : treeSetSecond.lower(new int[]{end, 0});
                if (ints == treeSetSecond.first() || arr1[1] <= start) {
                    treeSetSecond.add(new int[]{start, end});
                    return true;
                }
                return false;
            }
        }

        //public boolean book1(int start, int end) {
        //
        //    int[] ceiling = this.treeSetSecond.ceiling(new int[]{end, 0});
        //    int[] arr = ceiling == null ? this.treeSetSecond.last() :
        //            this.treeSetSecond.lower(new int[]{end, 0});
        //    if (!(ceiling == this.treeSetSecond.first() || arr[1] <= start)) {
        //        return false;
        //    }
        //
        //    if (treeSetFirst.isEmpty()) {
        //        treeSetFirst.add(new int[]{start, end});
        //        return true;
        //    }
        //    int[] ints = treeSetFirst.ceiling(new int[]{end, 0});
        //    int[] arr1 = ints == null ? this.treeSetFirst.last() : this.treeSetFirst.lower(new int[]{end, 0});
        //    if (ints == this.treeSetFirst.first() || arr1[1] <= start) {
        //        this.treeSetSecond.add(new int[]{Math.max()})
        //    }
        //
        //}
    }


}
