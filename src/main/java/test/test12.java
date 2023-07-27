package test;

public class test12 {


    private static test12 instance;

    private test12(){

    }

    public static  test12 get(){
        if (instance == null){
            synchronized (test12.class){
                if (instance == null){
                    instance =  new test12();
                }
            }
        }
        return instance;
    }

}
