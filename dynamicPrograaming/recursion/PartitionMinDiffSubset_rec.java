package dynamicPrograaming.recursion;

public class PartitionMinDiffSubset_rec {
	public static void main(String[] args) {
		int set[] = { 3, -4, 5, 3 };

		System.out.println(partitionMinDiff(set, 0, 0, 0));
	}

	private static int partitionMinDiff(int[] set, int ind, int set1, int set2) {

		if (ind == set.length)
			return Math.abs(set2 - set1);

		int inc = partitionMinDiff(set, ind + 1, set1 + set[ind], set2);

		int exc = partitionMinDiff(set, ind + 1, set1, set2 + set[ind]);

		return Math.min(inc, exc);
	}

}
