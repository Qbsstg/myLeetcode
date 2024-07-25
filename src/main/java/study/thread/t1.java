package study.thread;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Qbss
 * @date: 2024/7/24
 * @desc:
 */
public class t1 {

    private static final Object lock = new Object();

    private static int count = 0;

    private static final int n = 3;

    class outThread1 extends Thread {

        private int id;

        public outThread1(int id) {
            this.id = id;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (count <= 20) {
                synchronized (lock) {
                    if (count % n == id) {
                        System.out.println("当前执行线程：" + id + "，数值:" + count);
                        count++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }
    }

    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    class outThread2 extends Thread {

        private int id;

        private final Condition cdn = REENTRANT_LOCK.newCondition();

        public outThread2(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (count <= 20) {
                REENTRANT_LOCK.lock();
                try {
                 if (count % n == id){
                     System.out.println("当前执行线程：" + id + "，数值:" + count);
                     count++;
                     cdn.signalAll();
                 }else {
                    cdn.await();
                 }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    REENTRANT_LOCK.unlock();
                }
            }
        }
    }

    public void test1() {
        for (int i = 0; i < 3; i++) {
            new outThread1(i).start();
        }
    }

    public void test2() {
        for (int i = 0; i < 3; i++) {
            new outThread2(i).start();
        }
    }

    public static void main(String[] args) {
        t1 t1 = new t1();
        t1.test2();
    }


}
