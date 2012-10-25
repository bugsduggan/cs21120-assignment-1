package test;

import ladder.Discoverer;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Discoverer class
 *
 * @author Tom Leaman (thl5@aber.ac.uk)
 */
public class DiscovererTest {

  private Discoverer discoverer = new Discoverer();

  /**
   * Verifies that it fails sensibly
   */
  @Test
  public void testDiscoverLadderFails() {
    if (Utils.size(discoverer.discoverLadder("head", "head")) != 0)
      fail("Starting and ending on the same word should return empty");
  }

  /**
   * Verifies that it succeeds sensibly
   */
  @Test
  public void testDiscoverLadderSucceeds() {
    int result = Utils.size(discoverer.discoverLadder("head", "foot"));
    if (result == 0)
      fail("There should be a ladder from head to foot");
    if (result > 10)
      fail("It should take less than 10 moves to get from head to foot");
  }

}
