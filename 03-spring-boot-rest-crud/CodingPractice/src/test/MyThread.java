package test;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
       for(int i=0; i<5; i++){

           System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority() + " count: " +i);
       }
    }

    public static void main(String[] args) {

        MyThread t1 = new MyThread("Aditya");

        t1.start();
    }
}
