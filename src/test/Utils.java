package test;

import java.util.Iterator;

/**
 * Provides utility methods for the test package
 *
 * @author Tom Leaman (thl5@aber.ac.uk)
 */

class Utils {

  private Utils() {} // Do nothing

  /**
   * returns the size of the ladder
   *
   * @param ladder
   * @return       the size of the ladder
   */
  static int size(Iterable<String> ladder) {
    int result = 0;
    Iterator<String> iter = ladder.iterator();
    while (iter.hasNext()) {
      @SuppressWarnings("unused")
      String dontCare = iter.next();
      result++;
    }
    return result;
  }

}
