package java8.basics;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BasicsDemo {
    public static void main(String[] args) {

        // interface with default implementation
        InterfaceDefault formula = new InterfaceDefault() {
            @Override
            public double calculate(int x) {
                return sqrt(x);
            }
        };
        assert(formula.calculate(100) == formula.sqrt(100));

        // functional interface
        PersonDemoFactory<PersonDemo> factory = PersonDemo::new;
        System.out.println(factory.create("David", 25));
        // PersonDemo(name=David, age=25)

        // predicate
        Predicate<String> predicate = s -> s.length() > 0;
        System.out.println(predicate.test("foo")); // true
        System.out.println(predicate.negate().test("bar")); // false

        Predicate<String> nonNull = Objects::nonNull;
        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = isNull.or(String::isEmpty);
        Predicate<String> nonEmpty = nonNull.and(isEmpty.negate());

        // function
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<Integer, String> toString = String::valueOf;
        Function<String, String> reverseString = s -> new StringBuilder(s).reverse().toString();
        Function<Integer, Integer> reverseInteger = toString.andThen(reverseString).andThen(toInteger);
        System.out.println(reverseInteger.apply(1234)); // 4321

        // supplier
        Supplier<PersonDemo> supplier = PersonDemo::new;
        System.out.println(supplier.get());
        // PersonDemo(name=null, age=0)

        // consumer
        Consumer<PersonDemo> consumer = p -> System.out.println("Hello " + p.getName());
        consumer.accept(factory.create("David", 25));
        // Hello David

        // comparator
        Comparator<PersonDemo> comparator = Comparator.comparing(PersonDemo::getName);
        PersonDemo p1 = factory.create("David", 25);
        PersonDemo p2 = factory.create("Zach", 27);
        System.out.println(comparator.compare(p1, p2)); // -22
        System.out.println(comparator.reversed().compare(p1, p2)); // 22

        // optional
        Optional<String> optional = Optional.of("foo");
        System.out.println(optional.isPresent()); // true
        System.out.println(optional.get()); // foo
        System.out.println(optional.orElse("bar")); // foo
        optional.ifPresent(s -> System.out.println(reverseString.apply(s))); // oof

        // stream
        List<String> names = Arrays.asList("David", "Zach", "Amy", "Susan");
        List<String> reversedNames = names.stream().map(reverseString::apply).collect(Collectors.toList());
        System.out.println(reversedNames);
        // [divaD, hcaZ, ymA, nasuS]

        {
            // filter
            List<String> filteredNames = names.stream().filter(s -> s.charAt(0) > 'D').collect(Collectors.toList());
            System.out.println(filteredNames);
            // [Zach, Susan]

            // sorted
            System.out.println(names.stream().sorted().collect(Collectors.toList()));
            // [Amy, David, Susan, Zach]
            System.out.println(names.stream().sorted().findFirst().get());
            // Amy

            // map
            System.out.println(names.stream().map(String::toUpperCase).collect(Collectors.toList()));
            // [DAVID, ZACH, AMY, SUSAN]

            // match
            System.out.println(names.stream().anyMatch(s -> s.startsWith("D"))); // true
            System.out.println(names.stream().allMatch(s -> s.startsWith("D"))); // false
            System.out.println(names.stream().noneMatch(s -> s.startsWith("D"))); // false

            // count
            System.out.println(names.stream().filter(s -> s.charAt(0) > 'D').count()); // 2

            // reduce
            Optional<String> reduced = names.stream().sorted().reduce((s1, s2) -> s1 + "," + s2);
            reduced.ifPresent(System.out::println);
            // Amy,David,Susan,Zach

            // foreach
            names.stream().forEach(System.out::print);
            // DavidZachAmySusan
            System.out.println();

            // flatmap
            List<List<String>> namesFlatMap = Collections.singletonList(names);
            System.out.println(namesFlatMap);
            System.out.println(namesFlatMap.stream().flatMap(Collection::stream).collect(Collectors.toList()));
            // [[David, Zach, Amy, Susan]]
            // [David, Zach, Amy, Susan]

            // max, min
            System.out.println(names.stream().max(Comparator.comparingInt(s -> s.charAt(0))).get());
            System.out.println(names.stream().min(Comparator.comparingInt(s -> s.charAt(0))).get());
            // Zach
            // Amy

            // limit
            System.out.println(names.stream().sorted().limit(2).collect(Collectors.toList()));
            // [Amy, David]

            // collect
            System.out.println(names.stream().collect(Collectors.toMap(String::new, String::length)));
            // {Zach=4, Susan=5, David=5, Amy=3}
            System.out.println(names.stream().collect(Collectors.groupingBy(String::length)));
            // {3=[Amy], 4=[Zach], 5=[David, Susan]}
        }

    }
}
