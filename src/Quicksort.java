import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Maya Flynn
 * @author Sam R -> did the formating for the comments. Provided in the Quicksort Lab
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {} // Quicksort()



  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place.
   *
   * @param vals, an array to sort.
   * @param order, the order by which to sort the values.
   * @return The same array, now sorted.
   * @pre order can be applied to any two values in vals.
   * @pre VALS = vals.
   * @post vals is a permutation of VALS.
   * @post For all i, 0 < i < vals.length, order.compare(vals[i-1], vals[i]) <= 0
   */
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // STUB
  } // sort(T[], Comparator<? super T>)

  /**
   * Partition an array.
   */
  public <T> void partition(T[] values, Comparator<? super T> order) {
    partition(values, order, 0, values.length);
  } // partition(T[], Comparator<? super T>)

  // +----------------------+----------------------------------------
  // | Semi-private methods |
  // +----------------------+

  /**
   * Sort the subarray of T given by [lb..ub) in place using the Quicksort algorithm.
   */
  <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // STUB
  } // quicksort(T[], Comparator<? super T>, lb, ub)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  public static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    int pivotLoc = (ub - lb) / 2;
    T pivotVal = arr[pivotLoc];
    int small = lb;
    int large = ub;
    arr[pivotLoc] = arr[0];
    arr[0] = pivotVal;
    small++;
    while (small < large) {
      while (order.compare(arr[small], pivotVal) < 1 || order.compare(arr[large - 1], pivotVal) == 1) {
        if (order.compare(arr[small], pivotVal) < 1) {
          small++;
        } // if small
        if (order.compare(arr[large - 1], pivotVal) == 1) {
          large--;
        } // if large
      } // while
      T temp = arr[small];
      arr[small] = arr[large - 1];
      arr[large -1] = temp;
    } // while

    return 0;
  } // partition(T[], Comparator<? super T>, lb, ub)


} // class Quicksort
