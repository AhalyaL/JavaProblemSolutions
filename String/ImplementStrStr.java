package String;

public class ImplementStrStr {
	public static void main(String[] args) {
		String s1 = "lllhlello", s2 = "ll";

		System.out.println(implementStrStr(s1, s2));
	}

	private static int implementStrStr(String s1, String s2) {
		int j = 0, in = -1;

		if ("".equals(s2))
			return 0;

		for (int i = 0; i < s1.length(); i++) {

			if (s1.charAt(i) == s2.charAt(0)) {
                 in = i;
				for (int k = i; k < s1.length() && j < s2.length()
						&& s1.charAt(k) == s2.charAt(j); 
						k++, j++);
				if(j==s2.length())return in;
				else j=0;
			}

		}
		return -1;
	}

}
