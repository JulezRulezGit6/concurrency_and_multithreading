package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample2 {
    public static void main(String[] args) {
//        lockBasics();
        lockInterruptibly();
    }

    private static void lockInterruptibly() {

        Lock lock = new ReentrantLock();
        Thread.currentThread().interrupt();
        try {
            lock.lockInterruptibly();
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }


    }

    private static void tryLock() {
        Lock lock = new ReentrantLock();
        try {
            boolean lockSuccessful = lock.tryLock();
            System.out.println("Lock successfull: " + lockSuccessful);
        } finally {
            lock.unlock();
        }
    }


    private static void lockBasics() {
        Lock lock = new ReentrantLock(false);

        Runnable runnable = () -> {
            lockSleepUnlock(lock, 1000);
        };

        Thread thread3 = new Thread(runnable, "Thread 3");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread1 = new Thread(runnable, "Thread 1");

        thread1.start();
        thread2.start();
        thread3.start();

    }

    private static void lockSleepUnlock(Lock lock, long millis) {
        try {
            lock.lock();
            printThreadMessage(" holds the lock");
            sleep(millis);
        } finally {
            lock.unlock();
        }
    }

    private static void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printThreadMessage(String message) {
        System.out.println(Thread.currentThread().getName() + message);
    }
}
