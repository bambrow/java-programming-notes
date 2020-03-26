package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> System.out.println("Thread " + Thread.currentThread().getName() + " is running."));

        // executor shutdown convention
        try {
            System.out.println("shutting down executor...");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("task interrupted...");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("terminate non-finished tasks...");
            }
            executor.shutdownNow();
            System.out.println("executor has been shutdown...");
        }
    }
}
