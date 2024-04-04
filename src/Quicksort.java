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
    quicksort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>)

  // +----------------------+----------------------------------------
  // | Semi-private methods |
  // +----------------------+

  /**
   * Sort the subarray of T given by [lb..ub) in place using the Quicksort algorithm.
   */
  <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    if (ub - lb > 1) {
      int loc = partition(values, order, lb, ub);
      quicksort(values, order, lb, loc);
      quicksort(values, order, loc + 1, ub);
    } // if
  } // quicksort(T[], Comparator<? super T>, lb, ub)

  public static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    int pivotLoc = (ub - lb) / 2 + lb;
    T pivotVal = arr[pivotLoc];
    int small = lb;
    int large = ub;
    arr[pivotLoc] = arr[lb];
    arr[lb] = pivotVal;
    small++;
    while (small < large) {
      while ((small < large) && (order.compare(arr[small], pivotVal) < 1 || order.compare(arr[large - 1], pivotVal) == 1)) {
        if (order.compare(arr[small], pivotVal) < 1) {
          small++;
        } // if small
        if (order.compare(arr[large - 1], pivotVal) == 1) {
          large--;
        } // if large
      } // while we don't need to swap small and large
      if(small >= large) {
        break;
      }
      T temp = arr[small];
      arr[small] = arr[large - 1];
      arr[large -1] = temp;
      small++;
      large--;
    } // while
    arr[lb] = arr[small - 1];
    arr[small - 1] = pivotVal;

    return small - 1;
  } // partition(T[], Comparator<? super T>, lb, ub)
} // class Quicksort
