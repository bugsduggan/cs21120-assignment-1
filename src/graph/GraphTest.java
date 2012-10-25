package graph;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Graph package
 *
 * @author Tom Leaman (thl5@aber.ac.uk)
 */
public class GraphTest {

  private WordGraph graph = new WordGraph(5);

  @Test
  public void testGetAdjacentWords() {
    if(!graph.getConnected("clock").contains("click"))
      fail("click not adjacent to clock");
    if(!graph.getConnected("click").contains("clock"))
      fail("clock not adjacent to click");
    if(graph.getConnected("clock").contains("clock"))
      fail("clock is adjacent to clock");
    if(graph.getConnected("clock").contains("shock"))
      fail("shock is adjacent to clock");
  }

}
