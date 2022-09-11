package dynamicPrograaming.recursion;

public class EditDist {
	public static void main(String[] args) {
		String s1 = "die";
		String s2 = "int";

		int val = findDista(s1, s2, s1.length() - 1, s2.length() - 1);
		System.out.println(val);

	}

	private static int findDista(String s1, String s2, int ind1, int ind2) {
		if (ind1 == -1)
			return ind2+1;
		if (ind2 == -1)
			return ind1+1;

		if (s2.charAt(ind2) == s1.charAt(ind1))
			return findDista(s1, s2, ind1 - 1, ind2 - 1);
		
		return 1 + Math.min(Math.min(
				// replace
				findDista(s1, s2, ind1 - 1, ind2 - 1),

				// delete
				findDista(s1, s2, ind1 - 1, ind2)),
				// insert
				findDista(s1, s2, ind1, ind2 - 1));

	}

}
