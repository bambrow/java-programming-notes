package basics;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Iterator;

public class QueueBasics{

     public static void main(String []args){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.offer(3);
        queue.offer(7);
        System.out.println(queue); // [5, 3, 7]
        // add works, but can throw exception
        queue.add(5);
        System.out.println(queue); // [5, 3, 7, 5]
        System.out.println(queue.offer(6)); // true
        System.out.println(queue); // [5, 3, 7, 5, 6]
        System.out.println(queue.peek()); // 5
        // element works, but can throw exception
        System.out.println(queue.element()); // 5
        System.out.println(queue.poll()); // 5
        System.out.println(queue); // [3, 7, 5, 6]
        // remove works, but can throw exception
        System.out.println(queue.remove()); // 3
        System.out.println(queue); // [7, 5, 6]
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.size()); // 3
        
        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.offer(2);
        queue2.offer(1);
        queue.addAll(queue2);
        System.out.println(queue); // [7, 5, 6, 2, 1]
        
        Iterator<Integer> iter = queue.iterator();
        // Returns an iterator over the elements in this queue. 
        // The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
        while (iter.hasNext()) {
        	System.out.println(iter.next());
        }
     }
}

/*
java.lang.Object
    java.util.AbstractCollection<E>
        java.util.ArrayDeque<E>


public class ArrayDeque<E>
extends AbstractCollection<E>
implements Deque<E>, Cloneable, Serializable
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
