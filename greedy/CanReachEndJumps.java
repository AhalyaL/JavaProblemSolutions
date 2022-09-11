package greedy;

public class CanReachEndJumps {
	public static void main(String[] args) {
		int[] jumps = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(canReachEnd(jumps));

	}

	private static int canReachEnd(int[] jumps) {

		int maxJump = jumps[0];
		int count = 1;
		int steps = jumps[0];
		for (int i = 1; i < jumps.length; i++) {
			if (i == jumps.length - 1)
				return count;
			maxJump = Math.max(maxJump, i + jumps[i]);

			steps--;
			if (steps == 0) {
				count++;

				steps = maxJump - i;
			}

		}
		return -1;

	}
}
