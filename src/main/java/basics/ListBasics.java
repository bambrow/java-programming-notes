package basics;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class ListBasics{

     public static void main(String []args){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        System.out.println(list.toString()); // [1]
        list.add(2);
        System.out.println(list.toString()); // [1, 2]
        list.add(0,3);
        System.out.println(list.toString()); // [3, 1, 2]
        list.add(1,4);
        System.out.println(list.toString()); // [3, 4, 1, 2]
        System.out.println(list.contains(3)); // true
        System.out.println(list.contains(5)); // false
        list.clear();
        System.out.println(list.toString()); // []
        
        List<Integer> list2 = new ArrayList<>(10);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        System.out.println(list2.toString()); // [7, 8, 9]
        list.addAll(list2);
        System.out.println(list.toString()); // [7, 8, 9]
        System.out.println(list.containsAll(list2)); // true
        System.out.println(list.isEmpty()); // false
        System.out.println(list.equals(list2)); // true
        list.addAll(list2);
        System.out.println(list.toString()); // [7, 8, 9, 7, 8, 9]
        System.out.println(list.get(3)); // 7
        System.out.println(list.indexOf(8)); // 1
        System.out.println(list.indexOf(3)); // -1
        System.out.println(list.lastIndexOf(8)); // 4
        System.out.println(list.remove(3)); // 7
        System.out.println(list.toString()); // [7, 8, 9, 8, 9]
        System.out.println(list.remove((Integer) 8)); // true
        System.out.println(list.toString()); // [7, 9, 8, 9]
        System.out.println(list.set(0,5)); // 7
        System.out.println(list.toString()); // [5, 9, 8, 9]
        System.out.println(list.size()); // 4
        
        list2.clear();
        list2.add(9);
        System.out.println(list.toString()); // [5, 9, 8, 9]
        System.out.println(list.removeAll(list2)); // true
        System.out.println(list.toString()); // [5, 8]
        System.out.println(list.removeAll(list2)); // false
        list.add(3);
        list.add(0,8);
        System.out.println(list.toString()); // [8, 5, 8, 3]
        list.replaceAll(x -> x+1);
        System.out.println(list.toString()); // [9, 6, 9, 4]
        list.sort((x,y) -> x-y);
        System.out.println(list.toString()); // [4, 6, 9, 9]
        list.add(7);
        list.add(4);
        list2.add(7);
        list2.add(6);
        System.out.println(list.toString()); // [4, 6, 9, 9, 7, 4]
        System.out.println(list2.toString()); // [9, 7, 6]
        System.out.println(list.retainAll(list2)); // true
        System.out.println(list.toString()); // [6, 9, 9, 7]
        
        List<Integer> list3 = new LinkedList<>(list);
        System.out.println(list3.toString()); // [6, 9, 9, 7]
        List<Integer> list4 = new ArrayList<>(list);
        System.out.println(list4.toString()); // [6, 9, 9, 7]
        
        List<Integer> sub = list.subList(0,3); // [6, 9, 9]
        System.out.println(sub.toString());
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(arr);
        for (int num : arr) System.out.print(num + " "); // 6 9 9 7
     }
}

/*
java.lang.Object
    java.util.AbstractCollection<E>
        java.util.AbstractList<E>
            java.util.ArrayList<E>

public class ArrayList<E>
extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable
*/

/*
java.lang.Object
    java.util.AbstractCollection<E>
        java.util.AbstractList<E>
            java.util.AbstractSequentialList<E>
                java.util.LinkedList<E>

public class LinkedList<E>
extends AbstractSequentialList<E>
implements List<E>, Deque<E>, Cloneable, Serializable
*/