package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;

/**
 * WordGraph is a specific implementation of an AbstractGraph
 *
 * It will read in wordlists of the form <code>dictX.dat</code> where X is the
 * number of letters in each word (one word per line)
 *
 * @author Tom Leaman (thl5@aber.ac.uk)
 */
public class WordGraph extends AbstractGraph<String> {

  /**
   * Construct a WordGraph using <code>numLetters</code> length words
   *
   * @param numLetters the size of words used to populate the graph
   */
  public WordGraph(int numLetters) {
    try {
      String fileName = "dict" + numLetters + ".dat";
      List<String> wordList = getWordList(fileName);

      for (String word : wordList) {
        addNode(word);
        for (String comparison : nodeSet()) { // for each previously found word
          if (oneDifference(word, comparison)) // if it's one letter different
            addEdge(word, comparison); // add edge (both directions)
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Cannot find dictionary for " + numLetters + " size words.");
      System.out.println("Files should be named dictX.dat where X is the number of letters.");
      System.exit(1);
    }
  }

  /**
   * Pulls in data from a dictionary file
   *
   * @param fileName the name of the file
   * @return         the list of words in the file
   * @throws FileNotFoundException
   */
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

  /**
   * Compares two Strings, returns true if they differ by only one letter
   *
   * @param a
   * @param b
   */
  private boolean oneDifference(String a, String b) {
    int diffs = 0;
    for (int i = 0; (diffs <= 1) && (i < a.length()); i++) {
      if (a.charAt(i) != b.charAt(i))
        diffs++;
    }
    return (diffs == 1);
  }

}
