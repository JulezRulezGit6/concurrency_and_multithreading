package creating_starting_stopping_threads;

public class ThreadExample3 {

    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("MyThread Running\n" +
                    "MyThread Finished");
        }
    }
}
