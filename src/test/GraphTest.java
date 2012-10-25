package test;
import static org.junit.Assert.*;
import graph.WordGraph;

import org.junit.Test;

/**
 * Tests the Graph package
 *
 * @author Tom Leaman (thl5@aber.ac.uk)
 */
public class GraphTest {

  private WordGraph graph = new WordGraph(5);

  /**
   * Verifies that two words which should be adjacent, are adjacent
   */
  @Test
  public void testGetAdjacentWordsSimple() {
    if(!graph.getConnected("clock").contains("click"))
      fail("click not adjacent to clock");
    if(!graph.getConnected("click").contains("clock"))
      fail("clock not adjacent to click");
  }

  /**
   * Verifies that a word will not be connected to itself
   */
  @Test
  public void testGetAdjacentWordsRepeatEntry() {
    if(graph.getConnected("clock").contains("clock"))
      fail("clock is adjacent to clock");
  }

  /**
   * Verifies that words which are two moves apart are not connected
   */
  @Test
  public void testGetAdjacentWordsOffByOne() {
    if(graph.getConnected("clock").contains("shock"))
      fail("shock is adjacent to clock");
  }

}
