package threadlocal;

public class ThreadLocalRemoveExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread thread1 = new Thread(() ->
        {
//            threadLocal.set("Thread 1");
            threadLocal.set("ThreadJulez");
            String value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " " + value);

            threadLocal.remove();
            value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " " + value);
        }, "Thread 1");

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Thread 2");

            String value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " " + value);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " " + value);

            threadLocal.remove();
            value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " " + value);

        }, "Thread 2");

        thread1.start();
        thread2.start();
    }
}

