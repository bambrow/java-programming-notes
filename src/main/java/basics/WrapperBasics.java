package basics;

public class WrapperBasics{

     public static void main(String []args){
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648
        
        Integer i = 15;
        System.out.println(Integer.decode("123")); // 123
        System.out.println(i.intValue()); // 15
        System.out.println(i.doubleValue()); // 15.0
        System.out.println(Integer.parseInt("-123")); // -123
        System.out.println(Integer.parseUnsignedInt("123")); // 123
        System.out.println(Integer.valueOf("-123")); // -123
        System.out.println(i.toString()); // 15
        
        System.out.println(Integer.reverse(1)); // -2147483648
        System.out.println(Integer.reverseBytes(1)); // 16777216
        System.out.println(Integer.bitCount(65535)); // 16
        System.out.println(Integer.bitCount(65536)); // 1
        System.out.println(Integer.highestOneBit(65535)); // 32768
        System.out.println(Integer.highestOneBit(65536)); // 65536
        System.out.println(Integer.lowestOneBit(65535)); // 1
        System.out.println(Integer.lowestOneBit(65536)); // 65536
        System.out.println(Integer.numberOfLeadingZeros(65536)); // 15
        System.out.println(Integer.numberOfTrailingZeros(65536)); // 16
        System.out.println(Integer.rotateLeft(65536,2)); // 262144
        System.out.println(Integer.rotateRight(65536,2)); // 16384
        System.out.println(Integer.toBinaryString(65536)); // 10000000000000000
        System.out.println(Integer.toHexString(65536)); // 10000
        System.out.println(Integer.toOctalString(65536)); // 200000
        System.out.println(Integer.toString(65535, 2)); // 1111111111111111
        System.out.println(Integer.toString(65535, 4)); // 33333333
        System.out.println(Integer.toString(65535, 7)); // 362031
        System.out.println(Integer.toString(65535, 16)); // ffff
        System.out.println(Integer.toString(65535, 32)); // 1vvv
        System.out.println(Integer.toString(65535, 36)); // 1ekf
        
        Double d = Double.POSITIVE_INFINITY;
        System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308
        System.out.println(Double.MIN_VALUE); // 4.9E-324
        System.out.println(Double.NaN); // NaN
        System.out.println(Double.NEGATIVE_INFINITY); // -Infinity
        System.out.println(Double.POSITIVE_INFINITY); // Infinity
        System.out.println(Double.parseDouble("12.34")); // 12.34
        System.out.println(d.toString()); // Infinity
        System.out.println(Double.valueOf("-12.34")); // -12.34
        System.out.println(Double.isFinite(d)); // false
        System.out.println(Double.isInfinite(-d)); // true
        System.out.println(Double.isNaN(d)); // false
        
        Boolean b = Boolean.TRUE;
        System.out.println(Boolean.parseBoolean("TrUE")); // true
        System.out.println(Boolean.valueOf("tRuE")); // true
        System.out.println(b.toString()); // true
        
        Character c = Character.MAX_VALUE;
        System.out.println(Character.getNumericValue('7')); // 7
        System.out.println(Character.valueOf('c')); // c
        System.out.println(c.toString()); // ￿
        System.out.println(Character.MIN_RADIX); // 2
        System.out.println(Character.MAX_RADIX); // 36
     }
}