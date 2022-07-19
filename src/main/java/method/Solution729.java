package method;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Solution729 {

    public static void main(String[] args) {
        MyCalendar2 myCalendar1 = new MyCalendar2();
        myCalendar1.book2(47, 50);
        myCalendar1.book2(33, 41);
        myCalendar1.book2(39, 45);
        myCalendar1.book2(33, 42);
        myCalendar1.book2(25, 32);
        myCalendar1.book2(26, 35);
        myCalendar1.book2(19, 25);
        myCalendar1.book2(3, 8);
        myCalendar1.book2(8, 13);
        myCalendar1.book2(18, 27);

        //MyCalendar2 myCalendar2 = new MyCalendar2();
        //myCalendar2.book2(10, 20);
        //myCalendar2.book2(15, 25);
        //myCalendar2.book2(20, 30);
    }

    class MyCalendar {

        private byte[] nums;

        public MyCalendar() {
            this.nums = new byte[100000000];
        }

        public boolean book(int start, int end) {
            for (int i = start; i < this.nums.length && i < end; i++) {
                if (this.nums[i] == 1) {
                    return false;
                }
            }
            this.nums[start] = 1;
            this.nums[end - 1] = 1;
            return true;
        }
    }

    static class MyCalendar1 {

        private List<int[]> nums;

        public MyCalendar1() {
            this.nums = new ArrayList<>();
        }

        public boolean book1(int start, int end) {
            for (int[] ints : this.nums) {
                if (!(start >= ints[1] || end <= ints[0])) {
                    return false;
                }
            }
            this.nums.add(new int[]{start, end});
            return true;
        }
    }

    static class MyCalendar2 {

        private TreeSet<int[]> treeSet;

        public MyCalendar2() {
            this.treeSet = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
        }

        public boolean book2(int start, int end) {
            int[] e = {start, end};
            int[] ceiling = this.treeSet.ceiling(e);
            int[] lower = this.treeSet.lower(e);
            if (ceiling == null) {
                if (lower == null) {
                    this.treeSet.add(e);
                    return true;
                } else {
                    if (start >= lower[1]) {
                        this.treeSet.add(e);
                        return true;
                    } else {
                        return false;
                    }
                }

            } else {
                if (ceiling[0] == start) {
                    return false;
                } else {
                    if (lower == null) {
                        if (end <= ceiling[0]) {
                            this.treeSet.add(e);
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if (end <= ceiling[0] && start >= lower[1]) {
                            this.treeSet.add(e);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }

        public boolean book3(int start, int end) {

            if (this.treeSet.isEmpty()) {
                this.treeSet.add(new int[]{start, end});
                return true;
            }
            int[] tmp = {end, 0};
            int[] arr = this.treeSet.ceiling(tmp);
            if (arr == this.treeSet.first() || this.treeSet.lower(tmp)[1] <= start) {
                this.treeSet.add(new int[]{start, end});
                return true;
            }
            return false;
        }

        public boolean book4(int start, int end) {

            if (treeSet.isEmpty()) {
                this.treeSet.add(new int[]{start, end});
                return true;
            }

            int[] ceiling = this.treeSet.ceiling(new int[]{end, 0});
            int[] arr = ceiling == null ? this.treeSet.last() : this.treeSet.lower(ceiling);

            if (ceiling == treeSet.first() || arr[1] <= start) {
                this.treeSet.add(new int[]{start, end});
                return true;
            }
            return false;
        }

    }
}
