package basics;

public class StringBuilderBasics{

     public static void main(String []args){
        // StringBuilder: A mutable sequence of characters. This class provides an API compatible with StringBuffer, but with no guarantee of synchronization. This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations.
        
        StringBuilder str = new StringBuilder();
        System.out.println(str.append(true)); // true
        System.out.println(str.append(100)); // true100
        System.out.println(str.append(2.2)); // true1002.2
        System.out.println(str.append('?')); // true1002.2?
        System.out.println(str.append("wow!")); // true1002.2?wow!
        System.out.println(str.append(new StringBuilder("wow!!!"))); // true1002.2?wow!wow!!!
        System.out.println(str.append(new StringBuilder("QWERTYUIOP"), 1, 3)); // true1002.2?wow!wow!!!WE
        // append the CharSequence of index [from, to]
        // notice that the char at "to" index is also appended
        
        System.out.println(str.delete(0,str.length())); // 
        System.out.println(str.append("newyorknewyork")); // newyorknewyork
        System.out.println(str.charAt(10)); // y
        System.out.println(str.reverse()); // kroywenkroywen
        System.out.println(str.indexOf("wen")); // 4
        System.out.println(str.indexOf("wen",7)); // 11
        System.out.println(str.lastIndexOf("wen")); // 11
        System.out.println(str.lastIndexOf("wen",7)); // 4
        
        System.out.println(str.substring(5)); // enkroywen
        System.out.println(str.substring(5,9)); // enkr
        System.out.println(str.replace(0,11,"morning")); // morningwen
        
        System.out.println(str.insert(7,"!")); // morning!wen
        System.out.println(str.insert(7,5)); // morning5!wen
        System.out.println(str.insert(7,0.6)); // morning0.65!wen
        System.out.println(str.insert(7,true)); // morningtrue0.65!wen
        System.out.println(str.insert(7,new StringBuilder("???"))); // morning???true0.65!wen
        System.out.println(str.insert(7,new StringBuilder("QWERTYUIOP"), 1, 3)); // morningWE???true0.65!wen
     }
}

/*
java.lang.Object
    java.lang.StringBuilder

public final class StringBuilder
extends Object
implements Serializable, CharSequence
*/