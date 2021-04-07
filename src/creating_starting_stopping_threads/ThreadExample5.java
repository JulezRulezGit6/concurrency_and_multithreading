package creating_starting_stopping_threads;

public class ThreadExample5 {
    public static void main(String[] args) {

        Thread thread = new Thread(() ->
                System.out.println("MyThread Running\n" +
                        "MyThread Finished"));
        thread.start();
    }
}
