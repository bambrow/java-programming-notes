package basics;

import java.util.Iterator;
import java.util.Stack;

public class StackBasics{

     public static void main(String []args){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        System.out.println(stack); // [3, 2]
        stack.push(1);
        System.out.println(stack); // [3, 2, 1]
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.peek()); // 1
        System.out.println(stack.pop()); // 1
        System.out.println(stack); // [3, 2]
        System.out.println(stack.push(4)); // 4
        System.out.println(stack); // [3, 2, 4]
        System.out.println(stack.size()); // 3
        System.out.println(stack.search(3)); // 3
        // search returns the 1-based position where an object is on this stack
        System.out.println(stack.contains(3)); // true
        System.out.println(stack.indexOf(3)); // 0
        System.out.println(stack.indexOf(0)); // -1
        stack.push(3);
        System.out.println(stack); // [3, 2, 4, 3]
        System.out.println(stack.lastIndexOf(3)); // 3
        System.out.println(stack.remove(1)); // 2
        System.out.println(stack); // [3, 4, 3]
        System.out.println(stack.remove((Integer) 3)); // true
        System.out.println(stack); // [4, 3]
        System.out.println(stack.set(1,9)); // 3
        System.out.println(stack); // [4, 9]
        stack.push(5);
        stack.push(7);
        Iterator<Integer> iter = stack.iterator(); // iterator is in proper sequence
        while (iter.hasNext()) {
        	System.out.println(iter.next());
        }
     }
}
/*
java.lang.Object
    java.util.AbstractCollection<E>
        java.util.AbstractList<E>
            java.util.Vector<E>
                java.util.Stack<E>

public class Stack<E>
extends Vector<E>

public class Vector<E>
extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, Serializable
*/