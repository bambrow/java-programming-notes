package java8.basics;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo {
    public static void main(String[] args) {
        Stream.of("a", "c", null, "d").filter(Objects::nonNull).forEach(System.out::println);
        System.out.println(getPersonName(null)); // null
        System.out.println(getPersonName(new PersonDemo("David", 99))); // David

        try {
            Optional<PersonDemo> name = Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("null pointer exception!"); // this will run
        }

        Optional<PersonDemo> name = Optional.ofNullable(null);
        System.out.println(name); // Optional.empty

        try {
            System.out.println(name.get());
        } catch (NoSuchElementException e) {
            System.out.println("no such element exception!"); // this will run
        }

        System.out.println(name.isPresent()); // false
        System.out.println(name.orElse(new PersonDemo("David", 99))); // PersonDemo(name=David, age=99)
        name.ifPresent(System.out::println);
        System.out.println(name.filter(x -> x.getName().length() > 0)); // Optional.empty
        System.out.println(name.map(PersonDemo::getName)); // Optional.empty
        System.out.println(name.flatMap(x -> Optional.of(x.getName()))); // Optional.empty
    }

    private static String getPersonName(PersonDemo p) {
        Optional<String> name = Optional.ofNullable(p).map(PersonDemo::getName);
        return name.orElse(null);
    }
}
