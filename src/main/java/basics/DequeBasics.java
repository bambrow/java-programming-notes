package basics;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeBasics{

     public static void main(String []args){
        Deque<Integer> deque = new LinkedList<>();
        // we will not actually write the methods that can throw exceptions in this code
        // but they will still be mentioned
        
        deque.offerFirst(5);
        deque.offerLast(7);
        deque.offerFirst(6);
        // throw exception version: addFirst and addLast
        System.out.println(deque); // [6, 5, 7]
        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.offerFirst(3);
        deque2.offerLast(8);
        System.out.println(deque2); // [3, 8]
        
        System.out.println(deque2.peekFirst()); // 3
        System.out.println(deque2.peekLast()); // 8
        // throw exception version: getFirst and getLast
        System.out.println(deque2.pollFirst()); // 3
        System.out.println(deque2); // [8]
        System.out.println(deque2.pollLast()); // 8
        // throe exception version: removeFirst and removeLast
        System.out.println(deque2); // []
        
        System.out.println(deque.isEmpty()); // false
        System.out.println(deque.size()); // 3
        System.out.println(deque.contains(7)); // true
        System.out.println(deque.contains(8)); // false
        System.out.println(deque.remove(7)); // true
        System.out.println(deque.remove(8)); // false
        // remove with no parameters works like poll, and will throw exception
        // remove with parameters will not throw exception
        System.out.println(deque); // [6, 5]
        deque.offerFirst(6);
        deque.offerLast(6);
        System.out.println(deque); // [6, 6, 5, 6]
        System.out.println(deque.removeFirstOccurrence(6)); // true
        System.out.println(deque); // [6, 5, 6]
        System.out.println(deque.removeLastOccurrence(6)); // true
        System.out.println(deque); // [6, 5]
        deque.clear();
        
        // use deque as queue
        deque.offer(3);
        System.out.println(deque.offer(6)); // true
        System.out.println(deque); // [3, 6]
        System.out.println(deque.peek()); // 3
        System.out.println(deque.poll()); // 3
        // offer = offerLast
        // peek = peekFirst
        // poll = pollFirst
        // there are also corresponding methods that can throw exception:
        // add, element and remove
        // add = addLast
        // remove = removeFirst
        // element = getFirst
        System.out.println(deque); // [6]
        deque.clear();
        
        // use deque as stack
        deque.push(3);
        // push is a void method
        deque.push(6);
        System.out.println(deque); // [6, 3]
        System.out.println(deque.peek()); // 6
        System.out.println(deque.pop()); // 6
        // push = addFirst
        // pop = removeFirst
        // peek = peekFirst
        System.out.println(deque); // [3]
        deque.clear();
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