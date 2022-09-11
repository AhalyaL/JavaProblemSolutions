package Trees;

import java.util.ArrayList;

public class WordSearchUsingTrie {

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
			head.word = word;
		}
		head.isLeaf = true;
	}

	public static ArrayList<String> search(String[][] board, Node node) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			for (int k = 0; k < board[0].length; k++) {

				searchWord(board, node, i, k, new boolean[board.length][board[0].length], result);

			}
		}
		return result;
	}

	private static boolean searchWord(String[][] board, Node node, int i, int k, boolean[][] visited,
			ArrayList<String> resultL) {

		if (i < 0 || i > board.length - 1 || k < 0 || k > board[0].length - 1 || visited[i][k])
			return false;
		int index = board[i][k].toCharArray()[0] - 'a';

		if (node.children[index] != null) {
			visited[i][k] = true;
			node = node.children[index];
			if (node.isLeaf) {
				resultL.add(node.word);
				return true;

			} else {

				boolean result = searchWord(board, node, i - 1, k, visited, resultL)
						|| searchWord(board, node, i, k - 1, visited, resultL)
						|| searchWord(board, node, i + 1, k, visited, resultL)
						|| searchWord(board, node, i, k + 1, visited, resultL);
				visited[i][k] = false;
				return result;
			}

		}

		return false;
	}

	public static void main(String args[]) {

		String[][] board = { { "o", "a", "a", "n" }, { "e", "t", "a", "e" }, { "i", "h", "k", "r" },
				{ "i", "f", "l", "v" } };
		String words[] = { "oath", "pea", "eat", "rain" };

		Node node = new Node();

		int i;
		for (i = 0; i < words.length; i++)
			insert(words[i], node);
		ArrayList<String> l = search(board, node);
		System.out.println(l.toString());

	}
}
