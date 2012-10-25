package ladder;

import graph.WordGraph;

import java.util.LinkedList;
import java.util.List;

/**
 * Generator find a 'random' ladder of a given depth (if available) by
 * performing a recursive depth-first search
 *
 * @author Tom Leaman (thl5@aber.ac.uk)
 */
public class Generator {

  private WordGraph graph;
  private int depth;
  private List<String> visited;

  private Generator() {} // Do nothing

  /**
   * Returns a ladder of the specified depth starting with <code>word</code> if
   * one is available, otherwise it returns an empty list
   *
   * @param start the first word of the ladder
   * @param depth the depth of the ladder
   * @return      a collection of Strings contained in the ladder
   */
  public Iterable<String> generateLadder(String start, int depth) {
    List<String> ladder = new LinkedList<String>();
    graph = new WordGraph(start.length());
    if (depth <= 0 || !graph.hasNode(start)) // Are you asking for something silly / non-existant?
      return ladder;

    // init some useful things
    ladder.add(start);
    this.depth = depth;
    visited = new LinkedList<String>();
    visited.add(start);

    // go forth and find me a ladder!
    ladder = findLadder(ladder, depth - 1);
    if (ladder.size() == 1 && depth != 1) { // fail conditions, o noes!
      return new LinkedList<String>();
    }
    return ladder;
  }

  /**
   * This is the recursive function call that tries to build a ladder
   *
   * @param ladder the ladder so far
   * @param toFind how many more words are needed to satisfy the depth
   * @return       the ladder
   */
  private List<String> findLadder(List<String> ladder, int toFind) {
    if (toFind <= 0)
      return ladder; // mission accomplished

    String current = ladder.get(ladder.size() - 1);
    List<String> search = graph.getConnected(current);
    search.removeAll(ladder);
    search.removeAll(visited);

    for (String s : search) {
      ladder.add(s);
      visited.add(s);
      // we found this word, let's find the rest of them
      findLadder(ladder, toFind - 1);
      if (ladder.size() == depth) // success!
        break;
      ladder.remove(ladder.size() - 1); // !success so remove that word
    }

    return ladder;
  }

}
