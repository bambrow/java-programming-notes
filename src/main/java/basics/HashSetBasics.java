package basics;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetBasics{

     public static void main(String []args){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set); // [1, 2, 3]
        System.out.println(set.add(4)); // true
        System.out.println(set.add(1)); // false
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(5);
        System.out.println(set.addAll(set2)); // true
        System.out.println(set); // [1, 2, 3, 4, 5]
        System.out.println(set.contains(1)); // true
        System.out.println(set.contains(9)); // false
        System.out.println(set.containsAll(set2)); // true
        System.out.println(set.isEmpty()); // false 
        System.out.println(set.size()); // 5
        
        System.out.println(set.remove(3)); // true
        System.out.println(set); // [1, 2, 4, 5]
        System.out.println(set.removeAll(set2)); // true
        System.out.println(set); // [1, 2, 4]
        set.add(5);
        System.out.println(set.retainAll(set2)); // true
        System.out.println(set); // [5]
        
        set.add(3);
        set.add(2);
        set.add(1);
        Iterator<Integer> iter = set.iterator();
        // Returns an iterator over the elements in this set. 
        // The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
        while (iter.hasNext()) {
        	System.out.println(iter.next());
        }
     }
}

/*
java.lang.Object
    java.util.AbstractCollection<E>
        java.util.AbstractSet<E>
            java.util.HashSet<E>

public class HashSet<E>
extends AbstractSet<E>
implements Set<E>, Cloneable, Serializable
*/