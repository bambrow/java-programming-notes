package basics;

public class BitManipulationBasics {
	
	public boolean getBit(int x, int i) {
		// true if the bit i is 1, false otherwise
		return ((x & (1 << i)) != 0);
	}
	
	public int setBit(int x, int i) {
		// set bit i to 1
		return x | (1 << i);
	}
	
	public int clearBit(int x, int i) {
		// clear bit i to 0
		int mask = ~(1 << i);
		return x & mask;
	}
	
	public int clearBitsFromHighestToI(int x, int i) {
		// clear bits from highest bit to i all to 0
		int mask = (1 << i) - 1;
		return x & mask;
	}
	
	public int clearBitsFromLowestToI(int x, int i) {
		// clear bits from lowest bit to i all to 0
		int mask = (-1 << (i + 1));
		return x & mask;
	}
	
	public int updateBit(int x, int i, boolean setToOne) {
		// update bit i to either 0 or 1, depending on the boolean
		int value = setToOne ? 1 : 0;
		int mask = ~(1 << i);
		return (x & mask) | (value << i);
	}

	public static void main(String[] args) {
		int x = 7;
		System.out.println(Integer.toBinaryString(x)); // 111
		System.out.println(Integer.bitCount(x)); // 3
		System.out.println(Integer.highestOneBit(x)); // 4 = 100
		System.out.println(Integer.lowestOneBit(x)); // 1 = 1
		
		int y = 8;
		System.out.println(Integer.toBinaryString(y)); // 1000
		System.out.println(Integer.bitCount(y)); // 1
		System.out.println(Integer.highestOneBit(y)); // 8 = 1000
		System.out.println(Integer.lowestOneBit(y)); // 8 = 1000
		
		System.out.println(~x); // -8
		System.out.println(x ^ 0); // 7 = x
		System.out.println(x ^ -1); // -8 = ~x
		System.out.println(x ^ x); // 0 = 0
		
		System.out.println(x & 0); // 0 = 0
		System.out.println(x & -1); // 7 = x
		System.out.println(x & x); // 7 = x
		
		System.out.println(x | 0); // 7 = x
		System.out.println(x | -1); // -1 = 1s
		System.out.println(x | x); // 7 = x
		
		int z = -15;
		System.out.println(z >> 1); // -8
		System.out.println(z >>> 1); // 2147483640
		System.out.println(repeatedArithmeticShift(z, 32)); // -1 = 1s
		System.out.println(repeatedLogicalShift(z, 32)); // 0 = 0s
	}
	
	private static int repeatedArithmeticShift(int x, int cnt) {
		for (int i = 0; i < cnt; i++) {
			x >>= 1;
		}
		return x;
	}
	private static int repeatedLogicalShift(int x, int cnt) {
		for (int i = 0; i < cnt; i++) {
			x >>>= 1;
		}
		return x;
	}

}
