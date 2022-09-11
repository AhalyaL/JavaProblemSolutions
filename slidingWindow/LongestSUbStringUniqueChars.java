package slidingWindow;

public class LongestSUbStringUniqueChars {
	public static void main(String[] args) {
		String a = "aabacbebebe";
		// System.out.println(longestSubString(a,0));
		System.out.println(kdistinctchars(a, 3));
	}

	private static int longestSubString(String a, int maxcount) {

		int i = 0, j = 0;
		StringBuilder sb = new StringBuilder();
		while (i < a.length()) {
			if (sb.indexOf(a.charAt(i) + "") != -1) {
				maxcount = Math.max(maxcount, sb.length());
				a = a.substring(i);
				i = 0;
				sb = new StringBuilder();
			} else {
				sb.append(a.charAt(i));
				i++;
			}
		}
		maxcount = Math.max(maxcount, sb.length());

		return maxcount;
	}

	private static int kdistinctchars(String ab, int distinct) {

		int i = 0, maxcount = 0, j = 1, distc = 0;
		boolean found = false;
		StringBuilder sb = new StringBuilder();
		String a = ab;
		while (j < ab.length()) {
			while (i < a.length()) {
				
				if (sb.indexOf(a.charAt(i) + "") == -1)
					distc++;
				
				if (sb.indexOf(a.charAt(i) + "") != -1 && distinct <= distc) {
					maxcount = Math.max(maxcount, sb.length());
					System.out.println(sb);
					a = a.substring(j);
					i = 0;
					sb = new StringBuilder();
					found = true;
					distc = 0;
					break;
				} else {
					sb.append(a.charAt(i));
					i++;
				}

			}j++;
		}
		//System.out.println(sb.toString());
		maxcount = Math.max(maxcount, sb.length());
		if (!found)
			maxcount = 0;
		return maxcount;
	}

}
