package problems.p1;


// import java.util.Arrays;

public class LongestLineOnMatrix {
	
	public int longestLineOnMatrix (int[][] matrix) {
		int n = matrix.length;
		int max = 0;
		int[] up = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				up[j] = matrix[i][j] == 0 ? 0 : up[j] + 1;
				max = Math.max(max, up[j]);
			}
			// System.out.println(Arrays.toString(up));
		}
		// System.out.println();
		int[] left = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				left[i] = matrix[i][j] == 0 ? 0 : left[i] + 1;
				max = Math.max(max, left[i]);
			}
			// System.out.println(Arrays.toString(left));
		}
		// System.out.println();
		int[] upLeft = new int[n];
		for (int i = 0; i < n; i++) {
			// for (int j = 0; j < n; j++) {
			// we must compute backward in this case!
			// otherwise we are not using the old result!
			for (int j = n-1; j >= 0; j--) {
				if (j == 0) upLeft[j] = matrix[i][j];
				else upLeft[j] = matrix[i][j] == 0 ? 0 : upLeft[j-1] + 1;
				max = Math.max(max, upLeft[j]);
			}
			// System.out.println(Arrays.toString(upLeft));
		}
		// System.out.println();
		int[] upRight = new int[n];
		for (int i = 0; i < n; i++) {
			// for (int j = n-1; j >= 0; j--) {
			// we must compute forward in this case!
			// otherwise we are not using the old result!
			for (int j = 0; j < n; j++) {
				if (j == n-1) upRight[j] = matrix[i][j];
				else upRight[j] = matrix[i][j] == 0 ? 0 : upRight[j+1] + 1;
				max = Math.max(max, upRight[j]);
			}
			// System.out.println(Arrays.toString(upRight));
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0,1,0,0,0,0,0 },
						   { 0,0,1,0,0,1,0 },
						   { 0,1,1,1,1,1,0 },
						   { 0,0,1,1,1,1,1 },
						   { 0,0,1,0,0,1,0 },
						   { 0,1,0,0,1,0,0 }, 
						   { 1,0,0,1,0,0,0 }};
		LongestLineOnMatrix ll = new LongestLineOnMatrix();
		System.out.println(ll.longestLineOnMatrix(matrix));
	}

}
