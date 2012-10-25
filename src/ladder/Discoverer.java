package ladder;

import graph.WordGraph;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Discoverer {

  private WordGraph graph;
  private List<String> unvisited;
  private HashMap<String, Integer> costs;
  private HashMap<String, String> predecessors;

  /**
   * The main entry-point for this class.
   *
   * Returns a word ladder from start to end if one is available
   * otherwise, returns an empty list.
   *
   * @param start the first word of the ladder
   * @param end   the last word of the ladder
   * @return      the full word ladder
   */
  public List<String> discoverLadder(String start, String end) {

    List<String> ladder = new LinkedList<String>();
    if (start.length() != end.length())
      return ladder;

    graph = new WordGraph(start.length());
    if (!graph.hasNode(start) || !graph.hasNode(end))
      return ladder;

    // Init some extra structures to track progress
    unvisited = new LinkedList<String>();
    costs = new HashMap<String, Integer>();
    predecessors = new HashMap<String, String>();
    costs.put(start, 0);
    unvisited.add(start);

    // While there are still paths to search...
    while (!unvisited.isEmpty()) {
      String current = getMinimum(unvisited);
      unvisited.remove(current);
      // Update the cost for the node being searched
      findMinimalDistance(current);
    }

    String current = end;
    if (predecessors.get(current) == null)
      return ladder; // We're out of ideas
    ladder.add(current);
    // Now work backwards through the predecessors map
    while (predecessors.get(current) != null) {
      current = predecessors.get(current);
      ladder.add(current);
    }

    // Since we traversed predecessors backwards, we need to reverse the ladder
    Collections.reverse(ladder);
    return ladder;
  }

  /**
   * This checks all of the words in the set of nodes connected to it
   * and updates the costs map.
   *
   * @param word
   */
  private void findMinimalDistance(String word) {
    List<String> next = graph.getConnected(word);
    for (String n : next) {
      if (pathCost(n) > pathCost(word) + 1) {
        costs.put(n, pathCost(word) + 1);
        predecessors.put(n, word);
        unvisited.add(n);
      }
    }
  }

  /**
   * This returns the word in the list with the lowest cost.
   *
   * @param next the list of words to search through
   * @return     the word with the lowest cost
   */
  private String getMinimum(List<String> next) {
    String min = null;
    for (String s : next) {
      if (min == null) {
        min = s;
      } else {
        if (pathCost(s) < pathCost(min)) {
          min = s;
        }
      }
    }
    return min;
  }

  /**
   * Returns the cost to this node.
   * Initialises to Integer.MAX_VALUE
   *
   * @param word
   * @return     the cost to this node
   */
  private int pathCost(String word) {
    Integer d = costs.get(word);
    if (d == null) {
      return Integer.MAX_VALUE;
    } else {
      return d;
    }
  }

  public static void main(String[] args) {
    Discoverer d = new Discoverer();
    List<String> ladder = d.discoverLadder("head", "foot");
    for (String s : ladder)
      System.out.println(s);
  }

}
