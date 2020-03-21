package java8.basics;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);
        l1.add(2);
        System.out.println(l1); // [1, 3, 2]

        l1.removeIf(x -> x % 2 == 0);
        System.out.println(l1); // [1, 3]

        l1.forEach(x -> System.out.print(x + " "));
        System.out.println(); // 1 3

        l1.replaceAll(x -> x % 2 == 0 ? x+1 : x-1);
        System.out.println(l1); // [0, 2]

        Iterator<Integer> i1 = l1.iterator();
        i1.forEachRemaining(x -> System.out.print(x + " "));
        System.out.println(); // 0 2

        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1, "a");
        m1.putIfAbsent(2, "b");
        m1.putIfAbsent(3, "c");
        m1.putIfAbsent(1, "d");
        System.out.println(m1); // {1=a, 2=b, 3=c}

        m1.forEach((x, y) -> System.out.print(x + "," + y + " "));
        System.out.println(); // 1,a 2,b 3,c

        m1.replace(1, "d");
        m1.replace(1, "d", "a");
        System.out.println(m1); // {1=a, 2=b, 3=c}

        m1.replaceAll((x, y) -> x % 2 == 0 ? y.toUpperCase() : y);
        System.out.println(m1); // {1=a, 2=B, 3=c}

        m1.remove(2);
        m1.remove(1, "d");
        System.out.println(m1); // {1=a, 3=c}

        m1.compute(1, (x, y) -> x == 1 ? y+y+y : y+y);
        System.out.println(m1); // {1=aaa, 3=c}

        m1.computeIfPresent(1, (x, y) -> x == 1 ? y.toUpperCase() : y.toLowerCase());
        System.out.println(m1); // {1=AAA, 3=c}

        m1.computeIfAbsent(2, x -> ""+x+x);
        System.out.println(m1); // {1=AAA, 2=22, 3=c}

        System.out.println(Collections.emptyList());
        System.out.println(Collections.emptySet());
        System.out.println(Collections.emptyMap());
    }
}
