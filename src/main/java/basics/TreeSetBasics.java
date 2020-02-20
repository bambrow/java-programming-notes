package basics;

import java.util.TreeSet;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class TreeSetBasics{

     public static void main(String []args){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(3);
        set.add(7);
        System.out.println(set); // [3, 5, 7]
        System.out.println(set.add(1)); // true
        System.out.println(set); // [1, 3, 5, 7]
        System.out.println(set.add(5)); // false
        System.out.println(set); // [1, 3, 5, 7]
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(4);
        set2.add(6);
        System.out.println(set.addAll(set2)); // true 
        System.out.println(set); // [1, 2, 3, 4, 5, 6, 7]
        System.out.println(set.isEmpty()); // false
        System.out.println(set.size()); // 7
        System.out.println(set.first()); // 1
        System.out.println(set.last()); // 7
        System.out.println(set.subSet(1,4)); // [1, 2, 3]
        System.out.println(set.headSet(3)); // [1, 2]
        System.out.println(set.tailSet(3)); // [3, 4, 5, 6, 7]
        set.clear();
        
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(7);
        System.out.println(set); // [1, 3, 5, 7]
        System.out.println(set.ceiling(5)); // 5
        System.out.println(set.ceiling(6)); // 7
        System.out.println(set.higher(5)); // 7
        System.out.println(set.higher(6)); // 7
        System.out.println(set.floor(5)); // 5
        System.out.println(set.floor(4)); // 3
        System.out.println(set.lower(5)); // 3
        System.out.println(set.lower(4)); // 3
        System.out.println(set.ceiling(9)); // null
        System.out.println(set.higher(9)); // null
        System.out.println(set.floor(0)); // null
        System.out.println(set.lower(0)); // null
        
        System.out.println(set.descendingSet()); // [7, 5, 3, 1]
        System.out.println(set.pollFirst()); // 1
        System.out.println(set); // [3, 5, 7]
        System.out.println(set.pollLast()); // 7
        System.out.println(set); // [3, 5]
        System.out.println(set.contains(5)); // true
        System.out.println(set.remove(5)); // true
        System.out.println(set); // [3]
        
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(7);
        Iterator<Integer> iter = set.iterator();
        // Returns an iterator over the elements in this set in ascending order.
        while (iter.hasNext()) {
        	System.out.println(iter.next());
        }
     }
}

/*
java.lang.Object
    java.util.AbstractCollection<E>
        java.util.AbstractSet<E>
            java.util.TreeSet<E>

public class TreeSet<E>
extends AbstractSet<E>
implements NavigableSet<E>, Cloneable, Serializable
*/