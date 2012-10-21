package graph;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WordGraph extends UndirectedGraph<String> {
	
	public WordGraph(int numLetters) {
		try {
		    String fileName = "dict" + numLetters + ".dat";
	    	List<String> wordList = getWordList(fileName);
			
			for (String word : wordList) {
				addNode(word);
				for (String comparison : nodeSet()) {
					if (oneDifference(word, comparison))
						addEdge(word, comparison);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find dictionary for " + numLetters + " size words.");
			System.out.println("Files should be named dictX.dat where X is the number of letters.");
			System.exit(1);
		}
	}
	
	private List<String> getWordList(String fileName) throws FileNotFoundException {
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
			throw e;
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
	
}
