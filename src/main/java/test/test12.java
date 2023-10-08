package test;

import java.time.LocalDateTime;
import java.util.PriorityQueue;
import java.util.Queue;

public class test12 {


   static class LFCElem {
        int key;
        int value;
        int freq;

        LocalDateTime lastUseTime;

        public LFCElem(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
        public LFCElem(int key, int value, int freq,LocalDateTime lastUseTime) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.lastUseTime = lastUseTime;
        }
    }

    public static void main(String[] args) throws Exception{
        Queue<LFCElem> queue = new PriorityQueue<>((lfc1, lfc2) -> {
            if (lfc1.freq == lfc2.freq) {
                return lfc1.lastUseTime.compareTo(lfc2.lastUseTime);
            }
            return lfc1.freq - lfc2.freq;
        });


        LocalDateTime now3 = LocalDateTime.now();
        LFCElem lfcElem5 = new LFCElem(1,2,7, now3);
        LFCElem lfcElem6 = new LFCElem(1,1,8, now3);

        Thread.sleep(1000L);
        LocalDateTime now1 = LocalDateTime.now();
        LFCElem lfcElem1 = new LFCElem(1,6,1, now1);
        LFCElem lfcElem2 = new LFCElem(1,5,2, now1);

        Thread.sleep(1000L);
        LocalDateTime now2 = LocalDateTime.now();
        LFCElem lfcElem3 = new LFCElem(1,4,1, now2);
        LFCElem lfcElem4 = new LFCElem(1,3,2, now2);

        queue.add(lfcElem1);
        queue.add(lfcElem2);
        queue.add(lfcElem3);
        queue.add(lfcElem4);
        queue.add(lfcElem5);
        queue.add(lfcElem6);

        System.out.println(queue);

    }

}
