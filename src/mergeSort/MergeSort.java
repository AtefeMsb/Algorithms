package mergeSort;

public class MergeSort {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = {4, 3, 6, 2};
        MergeSort.mergeSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    /**
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (length < 2)
            return;
        int mid = length/2;

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

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
        }

    /**
     *
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
}
