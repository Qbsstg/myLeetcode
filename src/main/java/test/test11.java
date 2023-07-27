package test;

public class test11 implements Runnable {

    static  test11 instance1 = new test11();
    static  test11 instance2 = new test11();
    @Override
    public void run() {
        synchronized (test11.class){
            System.out.println("我是线程" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");
        }
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);

        t1.start();
        t2.start();
    }
}
