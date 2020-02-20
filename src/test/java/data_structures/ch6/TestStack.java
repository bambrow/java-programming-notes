package data_structures.ch6;

public class TestStack {

	public static void main(String[] args) {
		
		Stack<Integer> s1 = new ArrayStack<>();
		System.out.println(s1);
		s1.push(5).push(3);
		System.out.println(s1);
		System.out.println("size: " + s1.size());
		System.out.println("removed: " + s1.pop());
		System.out.println(s1);
		s1.push(7).push(9);
		System.out.println(s1);
		System.out.println("top: " + s1.top());
		System.out.println("size: " + s1.size());
		s1.push(6).push(8);
		System.out.println("removed: " + s1.pop());
		System.out.println(s1);
		
		System.out.println("-----------------------------------");
		
		Stack<Integer> s2 = new LinkedStack<>();
		System.out.println(s2);
		s2.push(5).push(3);
		System.out.println(s2);
		System.out.println("size: " + s2.size());
		System.out.println("removed: " + s2.pop());
		System.out.println(s2);
		s2.push(7).push(9);
		System.out.println(s2);
		System.out.println("top: " + s2.top());
		System.out.println("size: " + s2.size());
		s2.push(6).push(8);
		System.out.println("removed: " + s2.pop());
		System.out.println(s2);
		
	}
	
}
