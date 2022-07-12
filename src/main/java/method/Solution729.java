package method;

import java.util.ArrayList;
import java.util.List;

public class Solution729 {

    public static void main(String[] args) {
        MyCalendar1 myCalendar1 = new MyCalendar1();
        myCalendar1.book1(47, 50);
        myCalendar1.book1(33, 41);
        myCalendar1.book1(39, 45);
        myCalendar1.book1(33, 42);
        myCalendar1.book1(25, 32);
        myCalendar1.book1(26, 35);
        myCalendar1.book1(19, 25);
        myCalendar1.book1(3, 8);
        myCalendar1.book1(8, 13);
        myCalendar1.book1(18, 27);
    }

    class MyCalendar {

        private int[] nums;

        public MyCalendar() {
            this.nums = new int[1000000000];
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

}
