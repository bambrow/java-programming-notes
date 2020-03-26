package java8.stream;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamTest {
    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism()); // 11

        Arrays.asList("a1", "a2", "b1", "c2", "c1", "c2")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));
        /*
        filter: c2 [main]
        filter: a1 [ForkJoinPool.commonPool-worker-9]
        filter: a2 [ForkJoinPool.commonPool-worker-19]
        filter: b1 [ForkJoinPool.commonPool-worker-27]
        map: b1 [ForkJoinPool.commonPool-worker-27]
        filter: c2 [ForkJoinPool.commonPool-worker-5]
        map: c2 [ForkJoinPool.commonPool-worker-5]
        filter: c1 [ForkJoinPool.commonPool-worker-23]
        map: c1 [ForkJoinPool.commonPool-worker-23]
        forEach: C2 [ForkJoinPool.commonPool-worker-5]
        forEach: B1 [ForkJoinPool.commonPool-worker-27]
        map: a2 [ForkJoinPool.commonPool-worker-19]
        forEach: A2 [ForkJoinPool.commonPool-worker-19]
        map: a1 [ForkJoinPool.commonPool-worker-9]
        map: c2 [main]
        forEach: C2 [main]
        forEach: A1 [ForkJoinPool.commonPool-worker-9]
        forEach: C1 [ForkJoinPool.commonPool-worker-23]
         */
    }
}
