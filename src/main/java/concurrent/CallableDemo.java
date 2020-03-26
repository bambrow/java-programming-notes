package concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class CallableDemo {
    @SneakyThrows
    public static void main(String[] args) {
        Callable<String> task = () -> {
            try {
                Thread.sleep(3000);
                return "hello world";
            } catch (InterruptedException e) {
                System.err.println("task interrupted...");
                return null;
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> f1 = executor.submit(task);
        System.out.println("f1 is " + (f1.isDone() ? "done" : "not done yet") + "...");
        String result = f1.get(); // wait for completion
        System.out.println("f1 is " + (f1.isDone() ? "done" : "not done yet") + "...");
        System.out.println("result = " + result);

        Future<String> f2 = executor.submit(task);
        try {
            System.out.println(f2.get(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            System.err.println("task interrupted...");
        } catch (TimeoutException e) {
            System.err.println("future timeout..."); // this will run
        }

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
