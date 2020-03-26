package concurrent;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo3 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("local time = " + LocalTime.now());
            } catch (InterruptedException e) {
                System.err.println("task interrupted...");
            }
        };
        int initialDelay = 0;
        int period = 1;
        executor.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.SECONDS);

        Thread.sleep(10000);

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
