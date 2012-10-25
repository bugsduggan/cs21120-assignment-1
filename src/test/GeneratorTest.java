package test;

import ladder.Generator;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Generator class
 *
 * @author Tom Leaman (thl5@aber.ac.uk)
 */
public class GeneratorTest {

  private Generator generator = new Generator();

  /**
   * Verifies that sensible behaviour occurs with non-sensible input
   */
  @Test
  public void testGenerateLadderLimits() {
    if (Utils.size(generator.generateLadder("home", -3)) != 0)
      fail("Providing a negative depth should return an empty list");
    if (Utils.size(generator.generateLadder("home", 0)) != 0)
      fail("Providing a zero depth should return an empty list");
    if (Utils.size(generator.generateLadder("home", Integer.MAX_VALUE)) != 0)
      fail("You've found a ladder from home to the point where Java's Long can't hold the number!?!");
  }

  /**
   * Verifies that the expected depth is achieved
   */
  @Test
  public void testGenerateLadderSimple() {
    int result = Utils.size(generator.generateLadder("head", 3));
    if (result != 3)
      fail("Expected depth of 3 but got " + result);
    result = Utils.size(generator.generateLadder("head", 20));
    if (result != 20)
      fail("Expected depth of 20 but got " + result);
  }

}
