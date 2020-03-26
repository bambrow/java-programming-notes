package java8.basics;

import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringDemo {
    public static void main(String[] args) {
        String joined = String.join(":", "foo", "bar", "foobar");
        System.out.println(joined);
        // foo:bar:foobar

        String collected = "foo:bar:foobar"
                .chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .sorted()
                .collect(Collectors.joining());
        System.out.println(collected);
        // :abfor

        String compiled = Pattern.compile(":")
                .splitAsStream("foo:bar:foobar")
                .filter(x -> x.contains("bar"))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(":"));
        System.out.println(compiled);
        // foobar:bar

        Stream.of("david@gmail.com", "david@outlook.com", "david@yahoo.com", "david@yandex.com")
                .filter(Pattern.compile(".*@y.*\\.com").asPredicate())
                .forEach(System.out::println);
        // david@yahoo.com
        // david@yandex.com
    }
}
