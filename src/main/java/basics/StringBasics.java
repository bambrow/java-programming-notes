package basics;

import java.util.Arrays;

public class StringBasics{

     public static void main(String []args){
        // Important: String concatenation is implemented through the StringBuilder(or StringBuffer) class and its append method.
        
        String str = "Hello World!";
        String str2 = new String(new char[] { 'a', 'b', 'c', 'd', 'e' });
        System.out.println(str); // Hello World!
        System.out.println(str2); // abcde
        str2 = new String(new char[] { 'a', 'b', 'c', 'd', 'e' }, 2, 2);
        System.out.println(str2); // cd
        
        System.out.println(str.charAt(1)); // e
        System.out.println(str.charAt(str.length()-1)); // !
        
        System.out.println(str.codePointAt(1)); // 101
        System.out.println((int) str.charAt(1)); // 101
        System.out.println(str.codePointBefore(1)); // 72
        System.out.println((int) str.charAt(0)); // 72

        System.out.println("abc".compareTo("abc")); // 0
        System.out.println("abq".compareTo("cbp")); // -2
        System.out.println("cqq".compareTo("app")); // 2
        System.out.println("a??".compareTo("A!!")); // 32
        System.out.println("abc".compareToIgnoreCase("AbC")); // 0
        
        System.out.println(str.contains("Hello")); // true
        System.out.println("abc".equals("abc")); // true
        System.out.println("abc".equalsIgnoreCase("aBC")); // true
        
        System.out.println(str.indexOf('o')); // 4
        System.out.println(str.indexOf('o',5)); // 7
        System.out.println(str.indexOf('o',str.indexOf('o')+1)); // 7
        System.out.println(str.lastIndexOf('o')); // 7
        System.out.println(str.lastIndexOf('o',6)); // 4
        System.out.println(str.lastIndexOf('o',str.lastIndexOf('o')-1)); // 4
        System.out.println("abcdabcd".indexOf("bcd")); // 1
        System.out.println("abcdabcd".indexOf("bcd",2)); // 5
        System.out.println("abcdabcd".indexOf("cde")); // -1
        System.out.println("abcdabcd".lastIndexOf("bcd")); // 5
        System.out.println("abcdabcd".lastIndexOf("bcd",4)); // 1
        System.out.println("abcdabcd".lastIndexOf("bce")); // -1
        
        String[] arr = { "java", "python", "c++", "scala" };
        System.out.println(String.join("@", "java", "python", "c++", "scala")); // java@python@c++@scala
        System.out.println(String.join("$", arr)); // java$python$c++$scala
        System.out.println(String.join("|-|-|", arr)); // java|-|-|python|-|-|c++|-|-|scala
        
        System.out.println(str.matches("\\D+")); // true
        // for regex, see regex.java
        
        System.out.println("abcdabcdabcd".replace('a','!')); // !bcd!bcd!bcd
        System.out.println("abcdabcdabcd".replace("ab","!")); // !cd!cd!cd
        System.out.println("a00b00c00d00".replaceAll("\\d+","!")); // a!b!c!d!
        System.out.println("a00b00c00d00".replaceFirst("\\d+","!")); // a!b00c00d00
        
        // When there is a positive-width match at the beginning of this string then an empty leading substring is included at the beginning of the resulting array. A zero-width match at the beginning however never produces such empty leading substring.
        // The limit parameter controls the number of times the pattern is applied and therefore affects the length of the resulting array. If the limit n is greater than zero then the pattern will be applied at most n - 1 times, the array's length will be no greater than n, and the array's last entry will contain all input beyond the last matched delimiter. If n is non-positive then the pattern will be applied as many times as possible and the array can have any length. If n is zero then the pattern will be applied as many times as possible, the array can have any length, and trailing empty strings will be discarded.
        System.out.println(Arrays.toString("00a00b00c00d00".split("\\d+"))); // [, a, b, c, d]
        System.out.println(Arrays.toString("00a00b00c00d00".split("\\d"))); // [, , a, , b, , c, , d]
        System.out.println(Arrays.toString("00a00b00c00d00".split("\\d",4))); // [, , a, 0b00c00d00]
        System.out.println(Arrays.toString("00a00b00c00d00".split("\\d",100))); // [, , a, , b, , c, , d, , ]
        System.out.println(Arrays.toString("00a00b00c00d00".split("\\d",-2))); // [, , a, , b, , c, , d, , ]
        System.out.println(Arrays.toString("00a00b00c00d00".split("\\d",0))); // [, , a, , b, , c, , d]
        
        System.out.println(str.startsWith("Hello")); // true
        System.out.println(str.startsWith("Hello",2)); // false
        System.out.println(str.endsWith("World!")); // true
        
        System.out.println(str.substring(6)); // World!
        System.out.println(str.substring(6,11)); // World
        
        System.out.println(Arrays.toString(str.toCharArray())); // [H, e, l, l, o,  , W, o, r, l, d, !]
        System.out.println(str.toUpperCase()); // HELLO WORLD!
        System.out.println(str.toLowerCase()); // hello world!
        System.out.println("   hello hello   ".trim()); // hello hello
        
        System.out.println(String.valueOf(65535)); // 65535
        System.out.println(String.valueOf(58.76)); // 58.76
        System.out.println(String.valueOf('?')); // ?
        System.out.println(String.valueOf(false)); // false
        System.out.println(String.valueOf(new char[] { 'a','b','c','d','e' })); // abcde
        System.out.println(String.valueOf(new char[] { 'a','b','c','d','e' }, 2, 2)); // cd
     }
}

/*
java.lang.Object
    java.lang.String


public final class String
extends Object
implements Serializable, Comparable<String>, CharSequence
*/