/**
 * divide and conquer
 * not in-place
 * space complexity O(n)
 * memory is proportional to the number of elements in the list
 * time complexity O(nlogn)
 */
package mergeSort;

public class MergeSort {
    /**
     * this function receives an array and sort it with divide and conquer technique
     * first divide into smaller problem
     * second conquer via recursive calls
     * third combine solution into a sorted array
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2)
            return;
        int mid = length/2;

        // create two arrays from first and second half of unsorted array
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        int index = 0;
        for (int j = mid; j < length; j++) {
            right[index] = arr[j];
            index++;
        }

        // sort the first half of the array
        mergeSort(left);
        // sort the second half of the array
        mergeSort(right);
        // merge together two smaller and sorted halves
        merge(left, right, arr);
        }

    /**
     * this function combines two sorted array into one sorted array.
     * @param left
     * @param right
     * @param arr
     */
    public static void merge(int[] left, int[] right, int[] arr) {
       int leftLength = left.length;
       int rightLength = right.length;
       int i, j, k;
       i = j = k = 0;

       while (i < leftLength && j < rightLength) {
           if (left[i] < right[j]) {
               arr[k] = left[i];
               k++;
               i++;
           } else {
               arr[k] = right[j];
               k++;
               j++;
           }
       }
       while (i < leftLength) {
           arr[k] = left[i];
           k++;
           i++;
       }
       while (j < rightLength) {
           arr[k] = right[j];
           k++;
           j++;
       }
    }

    public static void main(String[] args) {
        int[] numbers = {4, 3, 6, 2};
        MergeSort.mergeSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}