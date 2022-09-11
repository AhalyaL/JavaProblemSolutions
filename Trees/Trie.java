package Trees;

public class Trie {

	public Trie() {

	}

	public static void insert(String word, Node node) {

		if (word == null || word.isBlank())
			return;
		Node head = node;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (head.children[index] == null) {
				head.children[index] = new Node();

			}
			head = head.children[index];

		}
		head.isLeaf = true;
	}

	public static boolean search(String word, Node node) {

		if (word == null || word.isBlank())
			return false;
		Node head = node;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
//			if (i == word.length() - 1 && head.isLeaf)
//				return true;
			if (head.children[index] == null) {
				return false;

			}
			head = head.children[index];

		}
		return head.isLeaf;

	}

	public boolean startsWith(String word, Node node) {

		if (word == null || word.isBlank())
			return false;
		Node head = node;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (head.children[index] == null) {
				return false;

			}
			head = head.children[index];

		}
		return true;

	}

	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };

		Node node = new Node();

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i], node);

		// Search for different keys
		if (search("the", node) == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (search("these", node) == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (search("their", node) == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (search("thaw", node) == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);

	}
}

class Node {

	boolean isLeaf;
	Node[] children;
    String word;
    
	Node() {
		isLeaf = false;
		children = new Node[26];
	}

}
