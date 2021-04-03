package creating_starting_stopping_threads;

public class ThreadExample4 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("MyThread Running\n" +
                        "MyThread Finished");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
