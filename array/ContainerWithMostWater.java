package array;

public class ContainerWithMostWater {
	public static void main(String[] args) {

		int[] height = { 1, 1 };
		System.out.println(maxArea(height));

	}

	public static int maxArea(int[] height) {
		int i = 0, j = height.length - 1, max = 0;

		max = Math.min(height[j], height[i]) * (j - i);
		while (i < j) {
			max = Math.max(max, Math.min(height[j], height[i]) * (j - i));
			if (height[i] > height[j])
				j--;
			else
				i++;

		}

		return max;
	}
}
