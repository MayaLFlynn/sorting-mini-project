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
    T[] tempLow = Arrays.copyOfRange(vals, lo, mid);
    T[] tempHigh = Arrays.copyOfRange(vals, mid, hi + 1);
    for (int i = 0; i < hi + 1; i++) {
      if ((midnew > (hi - mid))) {
        vals[i] = tempLow[lo];
        lo++;
      } else if (lo > mid - 1) {
        vals[i] = tempHigh[midnew];
        midnew++;
      } else {
        if ((comparator.compare(tempLow[lo], tempHigh[midnew])) == -1) {
          vals[i] = tempLow[lo];
          lo++;
        } else {
          vals[i] = tempHigh[midnew];
          midnew++;
        } // sorts elements
      } // if else (if one of tempLow/tempHigh has all of is elements used) or doesn't
    } // for all the elements
  } // merge(T[], Comparator<? super T>, int, int, int)

  static <T> void sortHelper(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    if(hi - lo > 1) {
      sortHelper(vals, lo, mid / 2, mid, comparator);
      sortHelper(vals, mid, 3 * mid / 2, hi, comparator); // one of the mids is wrong but I don't know where I am putting the midpaint at the moment
    } else {
      merge(vals, lo, mid, hi, comparator);
    }
  } // sortHelper(T[], Comparator<? super T>, int, int, int)

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    
  } // sort(T[], Comparator<? super T>)
} // class MergeSort
