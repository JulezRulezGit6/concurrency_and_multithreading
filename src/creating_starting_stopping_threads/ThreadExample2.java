package creating_starting_stopping_threads;

public class ThreadExample2 {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread Running");
            System.out.println("MyThread Finished");
        }
    }

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
    }
}
