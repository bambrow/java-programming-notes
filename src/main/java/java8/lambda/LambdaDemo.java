package java8.lambda;

import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {
        // sort with lambda
        List<String> names = Arrays.asList("David", "Zach", "Amy", "Susan");
        names.sort((a, b) -> b.compareTo(a));
        // same effect
        // names.sort(Comparator.reverseOrder());
        System.out.println(names);
        // [Zach, Susan, David, Amy]

        // functional interface used with lambda
        ConverterDemo<List<Integer>, Set<Integer>> converter = from -> new HashSet<>(from);
        // same effect
        // ConverterDemo<List<Integer>, Set<Integer>> converter = HashSet::new;
        System.out.println(converter.convert(Arrays.asList(1,2,2,3,3,3,4,4,4,4)));
        // [1, 2, 3, 4]
    }
}
