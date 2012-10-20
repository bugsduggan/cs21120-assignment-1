import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	private HashMap<String, Node> wordMap;
	
	public Graph(String fileName) {
		wordMap = new HashMap<String, Node>();
		List<String> wordList = getWordList(fileName);
		
		for (String word : wordList) {
			Node newNode = new Node(word);
			for (String comparison : wordMap.keySet()) {
				if (oneDifference(word, comparison)) {
					newNode.addLink(wordMap.get(comparison));
					wordMap.get(comparison).addLink(newNode);
				}
			}
			wordMap.put(word, newNode);
		}
	}
	
	public List<String> getAdjacentWords(String word) {
		List<String> result = new LinkedList<String>();
		for (Node n : wordMap.get(word).getNodes()) {
			result.add(n.getWord());
		}
		return result;
	}
	
	private List<String> getWordList(String fileName) {
		List<String> wordList = new LinkedList<String>();
		File f = new File(fileName);
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			String word = in.readLine();
			while(word != null) {
				wordList.add(word);
				word = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " not found. Please check that it is readable and in the right place.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordList;
	}
	
	private boolean oneDifference(String a, String b) {
		int diffs = 0;
		for (int i = 0; (diffs <= 1) && (i < a.length()); i++) {
			if (a.charAt(i) != b.charAt(i))
				diffs++;
		}
		return (diffs == 1);
	}
	
	private class Node {
		
		private String word;
		private List<Node> nodes;
		
		public Node(String word) {
			this.word = word;
			nodes = new LinkedList<Node>();
		}
		
		public void addLink(Node n) {
			nodes.add(n);
		}
		
		public String getWord() {
			return word;
		}
		
		public List<Node> getNodes() {
			return nodes;
		}
		
	}
	
}
