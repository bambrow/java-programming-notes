package problems.p1;


public class NextClosestTime {
	
	public String nextClosestTime(String time) {
		int[] digits = new int[4];
		digits[0] = time.charAt(0) - '0';
		digits[1] = time.charAt(1) - '0';
		digits[2] = time.charAt(3) - '0';
		digits[3] = time.charAt(4) - '0';
		
		int cur = computeMinutes(digits);
		int[] buffer = new int[4];
		int[] next = new int[2]; // next[0] saves the next closest time, next[1] saves the time difference
		next[1] = Integer.MAX_VALUE;
		
		DFS(digits, buffer, 0, cur, next);
		if (next[0] >= 24*60) next[0] -= 24*60;
		String h = String.valueOf(next[0] / 60);
		String m = String.valueOf(next[0] % 60);
		return (h.length() == 2 ? h : "0"+h) + ":" + (m.length() == 2 ? m : "0"+m);
	}
	
	private int computeMinutes(int[] buffer) {
		int h = buffer[0] * 10 + buffer[1];
		int m = buffer[2] * 10 + buffer[3];
		if (h <= 23 && m <= 59) return h * 60 + m;
		else return -1;
	}
	
	private void DFS(int[] digits, int[] buffer, int index, int cur, int[] next) {
		for (int d : digits) {
			buffer[index] = d;
			if (index < 3) {
				DFS(digits, buffer, index+1, cur, next);
			} else {
				int now = computeMinutes(buffer);
				if (now != -1) {
					if (now <= cur) now += 24*60;
					if (now - cur < next[1]) {
						next[1] = now - cur;
						next[0] = now;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		NextClosestTime n = new NextClosestTime();
		System.out.println(n.nextClosestTime("19:34"));
		System.out.println(n.nextClosestTime("23:59"));
		System.out.println(n.nextClosestTime("21:47"));
		System.out.println(n.nextClosestTime("19:49"));
		System.out.println(n.nextClosestTime("22:39"));
		System.out.println(n.nextClosestTime("22:22"));
	}

}
