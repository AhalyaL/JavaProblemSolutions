package String;

import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		String s = "";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {

		Stack<Character> st = new Stack();
		char[] ch = s.toCharArray();
        if(s.isEmpty())return false;
		for (char c : ch) {

			if (c == '{' || c == '(' || c == '[')
				st.push(c);
			else if (c == '}') {
				if (st.isEmpty() || st.pop() != '{')
					return false;
			} else if ( c == ']') {
				if (st.isEmpty() || st.pop() != '[')
					return false;
			} else if (c == ')') {
				if (st.isEmpty() || st.pop() != '(')
					return false;
			}
			
		}
       if(!st.isEmpty()) return false;
		return true;
	}
}
