package problems.p1;


import java.util.Arrays;

public class SquareSorted {
	
	public int[] squareSorted(int[] nums) {
		int[] arr = new int[nums.length];
		int i = 0, j = nums.length-1;
		int k = j;
		while (i <= j) {
			if (Math.abs(nums[i]) > Math.abs(nums[j])) {
				arr[k] = nums[i] * nums[i];
				i++;
			} else {
				arr[k] = nums[j] * nums[j];
				j--;
			}
			k--;
		}
		return arr;
	}

	public static void main(String[] args) {
		SquareSorted s = new SquareSorted();
		System.out.println(Arrays.toString(s.squareSorted(new int[] { -2, -1, 0, 1 })));
		System.out.println(Arrays.toString(s.squareSorted(new int[] { -3, -2, -1, 1, 3, 4 })));
	}

}
