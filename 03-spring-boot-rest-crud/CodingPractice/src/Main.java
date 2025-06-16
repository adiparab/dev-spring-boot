public class Main {

    public static Object sharedObject = new Object();

    public static void main(String[] args) {

        System.out.println("Main thread started");

        Runnable objRunnable1 = () -> {
            System.out.println("Thread 1 started");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread 1 completed");

        };


        Runnable objRunnable2 = () -> {
            System.out.println("Thread 2 started");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread 2 completed");

        };

         Thread objThread1 = new Thread(objRunnable1, "Runnable thread1");

        objThread1.start();

        Thread objThread2 = new Thread(objRunnable2, "Runnable thread2");
        objThread2.start();



        System.out.println("Main thread completed");


    }
}