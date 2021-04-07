package race_conditions;

import java.util.HashMap;
import java.util.Map;

public class RaceConditionExample5 {
    public static void main(String[] args) {
        Map<String, String> sharedMap = new HashMap<>();

        Thread thread1 = new Thread(getRunnable(sharedMap));
        Thread thread2 = new Thread(getRunnable(sharedMap));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Map<String, String> sharedMap) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                if (sharedMap.containsKey("key")) {
                    String val = sharedMap.remove("key");
                    if (val == null) {
                        System.out.println("Iteration: " + i + ": Value for 'key' is null");
                    }
                } else {
                    sharedMap.put("key", "value");
                }
            }

        };
    }

}

