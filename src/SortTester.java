import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void arbitrarilyOrderedStringTest() {
    String[] original = { "bravo", "delta", "foxtrot", "charlie", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void sortWithDuplicateValuesStringTest() {
    String[] original = { "charlie", "foxtrot", "delta", "bravo", "foxtrot" };
    String[] expected = { "bravo", "charlie", "delta", "foxtrot", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void orderedIntegerTest() {
    Integer[] original = {0, 1, 2, 3, 4, 5, 6};
    Integer[] expected = {0, 1, 2, 3, 4, 5, 6};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void reverseOrderedIntegerTest() {
    Integer[] original = {6, 5, 4, 3, 2, 1, 0};
    Integer[] expected = {0, 1, 2, 3, 4, 5, 6};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void arbitrarilyOrderedIntegerTest() {
    Integer[] original = {4, 6, 0, 5, 1, 2, 3};
    Integer[] expected = {0, 1, 2, 3, 4, 5, 6};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void sortWithDuplicateValuesIntegerTest() {
    Integer[] original = {5, 1, 6, 1, 4, 5, 1};
    Integer[] expected = {1, 1, 1, 4, 5, 5, 6};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest



} // class SortTester
