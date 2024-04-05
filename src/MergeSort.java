import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Maya Flynn
 * @author Marina Ananias -> worked with me on merge from the merge sort lab
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */

  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int midnew = 0;
    int lownew = 0;
    T[] tempLow = Arrays.copyOfRange(vals, lo, mid);
    T[] tempHigh = Arrays.copyOfRange(vals, mid, hi + 1);
    if (hi - lo <= 1) {
      return;
    }

    for (int i = lo; i < hi; i++) {
      if ((midnew > (hi - mid - 1))) {
        vals[i] = tempLow[lownew];
        lownew++;
      } else if (lownew > mid - lo - 1) {
        vals[i] = tempHigh[midnew];
        midnew++;
      } else {
        if ((comparator.compare(tempLow[lownew], tempHigh[midnew])) < 0) {
          vals[i] = tempLow[lownew];
          lownew++;
        } else {
          vals[i] = tempHigh[midnew];
          midnew++;
        } // sorts elements
      } // if else (if one of tempLow/tempHigh has all of is elements used) or doesn't
    } // for all the elements
  } // merge(vals, int, int, int, Comparator<? super T>)


  static <T> void sortHelper(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    if (hi - lo > 1) {
      sortHelper(vals, lo, (lo + mid) / 2, mid, comparator);
      sortHelper(vals, mid, (mid + hi) / 2, hi, comparator);                                                     
      merge(vals, lo, mid, hi, comparator);
    } // if
  } // sortHelper(T[], Comparator<? super T>, int, int, int)





  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sortHelper(values, 0, (values.length / 2), values.length, order);
  } // sort(T[], Comparator<? super T>)
} // class MergeSort
