package java8.stream;

import java8.basics.PersonDemo;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        // a1
        // a2
        // a3
        System.out.println();

        Stream.of("b1", "b2", "a1", "a2", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                });
        // empty (lazy evaluation)
        System.out.println();

        Stream.of("b1", "b2", "a1", "a2", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> {});
        // filter: b1
        // filter: b2
        // filter: a1
        // map: a1
        // filter: a2
        // map: a2
        // filter: c
        System.out.println();

        Stream.of("b1", "b2", "a1", "a2", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
        // map: b1
        // anyMatch: B1
        // map: b2
        // anyMatch: B2
        // map: a1
        // anyMatch: A1
        System.out.println();

        Stream<String> s1 = Stream.of("b1", "b2", "a1", "a2", "c");
        s1.filter(s -> s.startsWith("a")).anyMatch(s -> true);
        try {
            s1.filter(s -> s.startsWith("a")).noneMatch(s -> true);
        } catch (IllegalStateException e) {
            System.out.println("illegal state exception!"); // this will run
        }

        // to reuse stream
        Supplier<Stream<String>> s2 = () -> Stream.of("b1", "b2", "a1", "a2", "c");
        s2.get().filter(s -> s.startsWith("a")).anyMatch(s -> true);
        s2.get().filter(s -> s.startsWith("a")).noneMatch(s -> true);

        List<PersonDemo> l1 = new ArrayList<>();
        l1.add(new PersonDemo("Amy", 22));
        l1.add(new PersonDemo("Bob", 27));
        l1.add(new PersonDemo("Cathy", 27));
        l1.add(new PersonDemo("David", 99));

        Map<Integer, List<PersonDemo>> personByAge = l1.stream().collect(Collectors.groupingBy(PersonDemo::getAge));
        System.out.println(personByAge);
        // {99=[PersonDemo(name=David, age=99)], 22=[PersonDemo(name=Amy, age=22)], 27=[PersonDemo(name=Bob, age=27), PersonDemo(name=Cathy, age=27)]}

        System.out.println(l1.stream().collect(Collectors.averagingInt(PersonDemo::getAge)));
        // 43.75

        IntSummaryStatistics ageSummaryStatistics = l1.stream().collect(Collectors.summarizingInt(PersonDemo::getAge));
        System.out.println(ageSummaryStatistics);
        // IntSummaryStatistics{count=4, sum=175, min=22, average=43.750000, max=99}

        // creating collector
        Collector<PersonDemo, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(", "), // supplier
                        (j, p) -> j.add(p.getName().toUpperCase()), // accumulator
                        StringJoiner::merge, // combiner
                        StringJoiner::toString // finisher
                );
        System.out.println(l1.stream().collect(personNameCollector));
        // AMY, BOB, CATHY, DAVID
    }
}
