package problems.p1;


import java.util.Arrays;

public class UniquePathsMore {
	
	public int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0) return 0;
        int[] look = m >= n ? new int[n] : new int[m];
        Arrays.fill(look, 1);
        for (int k = 1; k < Math.max(m, n); k++) {
            for (int i = 1; i < look.length; i++) {
                look[i] = look[i] + look[i-1];
            }
        }
        return look[look.length-1];
    }
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] look = new int[n];
        look[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    look[j] = 0;
                } else if (j > 0) {
                    look[j] = look[j] + look[j-1];
                }
            }
        }
        return look[look.length-1];
    }
	
	public int uniquePathsMore(int m, int n) {
		if (m <= 0 || n <= 0) return 0;
        int[] look = m >= n ? new int[n] : new int[m];
        Arrays.fill(look, 1);
        for (int k = 1; k < Math.max(m, n); k++) {
        	int diagonal = look[0];
            for (int i = 1; i < look.length; i++) {
            	int temp = look[i];
                look[i] = look[i] + look[i-1] + diagonal;
                diagonal = temp;
            }
        }
        return look[look.length-1];
    }

	public static void main(String[] args) {
		UniquePathsMore u = new UniquePathsMore();
		System.out.println(u.uniquePathsMore(0, 0));
		System.out.println(u.uniquePathsMore(1, 1));
		System.out.println(u.uniquePathsMore(2, 2));
		System.out.println(u.uniquePathsMore(2, 3));
		System.out.println(u.uniquePathsMore(3, 2));
		System.out.println(u.uniquePathsMore(3, 3));
		System.out.println(u.uniquePathsMore(3, 4));
	}

}
