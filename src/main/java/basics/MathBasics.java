package basics;

public class MathBasics{

     public static void main(String []args){
        System.out.println(Math.E); // 2.718281828459045
        System.out.println(Math.PI); // 3.141592653589793
        
        System.out.println(Math.abs(-1.999)); // 1.999
        System.out.println(Math.ceil(-1.999)); // -1.0
        System.out.println(Math.exp(0.5)); // 1.6487212707001282
        System.out.println(Math.floor(-1.999)); // -2.0
        System.out.println(Math.hypot(4,3));  // 5.0
        System.out.println(Math.log(Math.E)); // 1.0
        System.out.println(Math.log10(10)); // 1.0
        System.out.println(Math.max(2,3.2)); // 3.2
        System.out.println(Math.min(2,3.2)); // 2.0
        System.out.println(Math.pow(2,3)); // 8.0
        System.out.println(Math.random()); // 0.17547478408460682
        System.out.println(Math.round(-1.999)); // -2
        System.out.println(Math.sqrt(9)); // 3.0
     }
}

/*
java.lang.Object
    java.lang.Math

public final class Math
extends Object
*/