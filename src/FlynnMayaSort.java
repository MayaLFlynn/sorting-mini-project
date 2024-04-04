import java.util.Comparator;

/**
 * A heap sorting algorithm that takes a uses a binary tree method to order the elements.
 * ChatGPT wrote this code with me. More information about my ChatGPT expierence is in the README.md file.
 * 
 * @author Maya Flynn
 */

public class FlynnMayaSort {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i, comparator);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0, comparator);
        }
    }
  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+


// To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
public static <T> void heapify(T[] array, int n, int i, Comparator<T> comparator) {
  int largest = i; // Initialize largest as root
  int left = 2 * i + 1; // left = 2*i + 1
  int right = 2 * i + 2; // right = 2*i + 2

  // If left child is larger than root
  if (left < n && comparator.compare(array[left], array[largest]) > 0)
      largest = left;

  // If right child is larger than largest so far
  if (right < n && comparator.compare(array[right], array[largest]) > 0)
      largest = right;

  // If largest is not root
  if (largest != i) {
      T swap = array[i];
      array[i] = array[largest];
      array[largest] = swap;

      // Recursively heapify the affected sub-tree
      heapify(array, n, largest, comparator);
  }
}

} // class MergeSorter
