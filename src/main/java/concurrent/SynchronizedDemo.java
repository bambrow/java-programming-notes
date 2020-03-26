package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizedDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // IntStream.range(0, 10000).forEach(i -> executor.submit(SynchronizedDemo::badIncrement));
        IntStream.range(0, 10000).forEach(i -> executor.submit(SynchronizedDemo::increment));
        Utils.stop(executor);
        System.out.println(count);
    }

    private static int count = 0;
    private static void badIncrement() {
        count = count + 1;
    }
    private synchronized static void increment()  {
        count = count + 1;
    }
}
