package creating_starting_stopping_threads;

public class ThreadExample7 {
    public static void main(String[] args) {
        Runnable runnable = () -> {

            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " running");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " finished");

        };
        Thread thread1 = new Thread(runnable,"Thread 1");
        Thread thread2 = new Thread(runnable,"Thread 2");

        thread1.start();
        thread2.start();

    }
}
