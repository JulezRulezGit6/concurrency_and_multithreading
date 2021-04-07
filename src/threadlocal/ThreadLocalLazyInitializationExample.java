package threadlocal;

public class ThreadLocalLazyInitializationExample {
    public static void main(String[] args) {
        ThreadLocal <String> threadLocal = new ThreadLocal<>();
        String value = threadLocal.get();
        if (value == null){
            threadLocal.set("Default Lazy Value");
            value = threadLocal.get();
        }
        System.out.println(value);
    }
}
