package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> list = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            list.add(uuid.toString());
        }

        // use stream first
        long start0 = System.nanoTime();
        long count0 = list.stream().map(s -> new StringBuilder(s).reverse().toString()).count();
        System.out.println(count0);
        long end0 = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toNanos(end0 - start0));
        // 827625

        // use parallel stream next
        long start1 = System.nanoTime();
        long count1 = list.stream().map(s -> new StringBuilder(s).reverse().toString()).count();
        System.out.println(count1);
        long end1 = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toNanos(end1 - start1));
        // 301890
    }
}
