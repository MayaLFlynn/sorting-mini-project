import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Maya Flynn
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {} // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    for (int i = 1; i < values.length; i++) {
      T temp = values[i];
      int j = 0;
      while (true) {
        if (i > j && order.compare(temp, values[i - j - 1]) < 0) {
          j++;
        } else {
          for (int m = i; m > i - j; m--) {
            values[m] = values[m - 1];
          }
          values[i - j] = temp;
          break;
        } // if
      } // while
    } // for
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
