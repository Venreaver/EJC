package tasks.task_04;

import java.util.Arrays;

/**
 * Class implements six sorting algorithms (in ascending and descending order) and binary search in int array
 * <p>
 * <p> Implementation of bubble sort, selection sort, insertion sort,
 * quick sort, merge sort, radix sort, binary search
 * <p> Class implements method to form array with random integers, sorting methods and search methods
 */
public class Algorithms {
    public static void main(String[] args) {
        showSortsAndSearch();
    }

    /**
     * Print in console arrays before and after each sort, print result of binary search
     */
    private static void showSortsAndSearch() {
        System.out.println("BUBBLE SORT");
        int[] intArrayForBubble = setRandomNumberArray(110);
        System.out.println(Arrays.toString(intArrayForBubble));
        bubbleSort(intArrayForBubble);
        System.out.println(Arrays.toString(intArrayForBubble));
        printBinarySearchResult(0, binarySearch(intArrayForBubble, 0));
        bubbleSort(intArrayForBubble, false);
        System.out.println(Arrays.toString(intArrayForBubble));

        System.out.println("\nSELECTION SORT");
        int[] intArrayForSelection = setRandomNumberArray(115);
        System.out.println(Arrays.toString(intArrayForSelection));
        selectionSort(intArrayForSelection);
        System.out.println(Arrays.toString(intArrayForSelection));
        printBinarySearchResult(0, binarySearch(intArrayForSelection, 0));
        selectionSort(intArrayForSelection, false);
        System.out.println(Arrays.toString(intArrayForSelection));

        System.out.println("\nINSERTION SORT");
        int[] intArrayForInsertion = setRandomNumberArray(110);
        System.out.println(Arrays.toString(intArrayForInsertion));
        insertionSort(intArrayForInsertion);
        System.out.println(Arrays.toString(intArrayForInsertion));
        printBinarySearchResult(0, binarySearch(intArrayForInsertion, 0));
        insertionSort(intArrayForInsertion, false);
        System.out.println(Arrays.toString(intArrayForInsertion));

        System.out.println("\nQUICK SORT");
        int[] intArrayForQuick = setRandomNumberArray(115);
        System.out.println(Arrays.toString(intArrayForQuick));
        quickSort(intArrayForQuick);
        System.out.println(Arrays.toString(intArrayForQuick));
        printBinarySearchResult(0, binarySearch(intArrayForQuick, 0));
        quickSort(intArrayForQuick, false);
        System.out.println(Arrays.toString(intArrayForQuick));

        System.out.println("\nMERGE SORT");
        int[] intArrayForMerge = setRandomNumberArray(110);
        System.out.println(Arrays.toString(intArrayForMerge));
        mergeSort(intArrayForMerge);
        System.out.println(Arrays.toString(intArrayForMerge));
        printBinarySearchResult(0, binarySearch(intArrayForMerge, 0));
        mergeSort(intArrayForMerge, false);
        System.out.println(Arrays.toString(intArrayForMerge));

        System.out.println("\nRADIX SORT");
        int[] intArrayForRadix = setRandomNumberArray(115);
        System.out.println(Arrays.toString(intArrayForRadix));
        radixSortLSD(intArrayForRadix);
        System.out.println(Arrays.toString(intArrayForRadix));
        printBinarySearchResult(0, binarySearch(intArrayForRadix, 0));
        radixSortLSD(intArrayForRadix, false);
        System.out.println(Arrays.toString(intArrayForRadix));
    }

    /**
     * Return array with <code>n</code> random integer elements [0, 1000)
     *
     * @param n number of random integer elements which will be input in array
     * @return array with <code>n</code> random integer elements
     */
    private static int[] setRandomNumberArray(int n) {
        int[] resultArray = new int[n];
        for (int i = 0; i < resultArray.length; ++i) {
            resultArray[i] = Math.random() < 0.5 ? (int) (Math.random() * 1000) : -(int) (Math.random() * 1000);
        }
        return resultArray;
    }

    /**
     * BUBBLE SORT: Sort input array with optimizing bubble sort algorithm
     * <p>
     * <p> Complexity: time -- O(n) - O(n^2) - O(n^2), memory -- O(1)
     *
     * @param intArray input array with integer elements
     */
    static void bubbleSort(int[] intArray) {
        bubbleSort(intArray, true);
    }

    /**
     * BUBBLE SORT: Sort input array with optimizing bubble sort algorithm
     * <p>
     * <p> Complexity: time -- O(n) - O(n^2) - O(n^2), memory -- O(1)
     *
     * @param intArray input array with integer elements
     * @param isAsc    is sorting in ascending order or not
     */
    static void bubbleSort(int[] intArray, boolean isAsc) {
        for (int i = 0; i < intArray.length - 1; ++i) {
            boolean isSwapped = false;
            for (int j = 0; j < intArray.length - 1 - i; ++j) {
                if (isAsc) {
                    if (intArray[j] > intArray[j + 1]) {
                        isSwapped = intSwapInArray(intArray, j, j + 1);
                    }
                } else {
                    if (intArray[j] < intArray[j + 1]) {
                        isSwapped = intSwapInArray(intArray, j, j + 1);
                    }
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    /**
     * SELECTION SORT: Sort input list with selection sort algorithm
     * <p>
     * <p> Complexity: time -- O(n^2) - O(n^2) - O(n^2), memory -- O(1)
     *
     * @param intArray input array with integer elements
     */
    static void selectionSort(int[] intArray) {
        selectionSort(intArray, true);
    }

    /**
     * SELECTION SORT: Sort input list with selection sort algorithm
     * <p>
     * <p> Complexity: time -- O(n^2) - O(n^2) - O(n^2), memory -- O(1)
     *
     * @param intArray input array with integer elements
     * @param isAsc    is sorting in ascending order or not
     */
    static void selectionSort(int[] intArray, boolean isAsc) {
        for (int i = 0; i < intArray.length - 1; ++i) {
            int minOrMax = i;
            for (int j = minOrMax + 1; j < intArray.length; ++j) {
                if (isAsc) {
                    if (intArray[minOrMax] > intArray[j]) {
                        minOrMax = j;
                    }
                } else {
                    if (intArray[minOrMax] < intArray[j]) {
                        minOrMax = j;
                    }
                }
            }
            intSwapInArray(intArray, minOrMax, i);
        }
    }

    /**
     * INSERTION SORT: Sort input list with insertion sort algorithm
     * <p>
     * <p> Complexity: time -- O(n) - O(n^2) - O(n^2), memory -- O(1)
     *
     * @param intArray input array with integer elements
     */
    static void insertionSort(int[] intArray) {
        insertionSort(intArray, true);
    }

    /**
     * INSERTION SORT: Sort input list with insertion sort algorithm
     * <p>
     * <p> Complexity: time -- O(n) - O(n^2) - O(n^2), memory -- O(1)
     *
     * @param intArray input array with integer elements
     * @param isAsc    is sorting in ascending order or not
     */
    static void insertionSort(int[] intArray, boolean isAsc) {
        for (int i = 1; i < intArray.length; ++i) {
            int key = intArray[i];
            int j = i;
            if (isAsc) {
                while (j > 0 && intArray[j - 1] > key) {
                    intArray[j] = intArray[--j];
                }
            } else {
                while (j > 0 && intArray[j - 1] < key) {
                    intArray[j] = intArray[--j];
                }
            }
            intArray[j] = key;
        }
    }

    /**
     * QUICK SORT: Sort input array with quick sort algorithm with Hoare partitioning
     * <p>
     * <p> Complexity: time -- O(n log(n)) - O(n log(n)) - O(n^2), memory -- O(n) / O(log n)
     *
     * @param intArray input array which will be sorted
     */
    static void quickSort(int[] intArray) {
        quickSort(intArray, true);
    }

    /**
     * QUICK SORT: Sort input array with quick sort algorithm with Hoare partitioning
     * <p>
     * <p> Complexity: time -- O(n log(n)) - O(n log(n)) - O(n^2), memory -- O(n) / O(log n)
     *
     * @param intArray input array which will be sorted
     * @param isAsc    is sorting in ascending order or not
     */
    static void quickSort(int[] intArray, boolean isAsc) {
        quickSort(intArray, 0, intArray.length - 1, isAsc);
    }

    /**
     * QUICK SORT: Sort input array with quick sort algorithm with Hoare partitioning
     * <p>
     * <p> Complexity: time -- O(n log(n)) - O(n log(n)) - O(n^2), memory -- O(n) / O(log n)
     * <p> 1. Determine pivot index in array
     * <p> if low index < high index:
     * <p> 2. Recursively call of this method for left part of array (from low Index to pivot index inclusive)
     * <p> 3. Recursively call of this method for right part of array
     * (from next index after pivot index to high index inclusive)
     *
     * @param intArray  input array which will be sorted
     * @param lowIndex  first index which represent start index in part of the array which will be sorted
     * @param highIndex last index which represent end index in part of the array which will be sorted
     * @param isAsc     is sorting in ascending order or not
     */
    private static void quickSort(int[] intArray, int lowIndex, int highIndex, boolean isAsc) {
        if (highIndex > lowIndex) {
            int pivotIndex = partition(intArray, lowIndex, highIndex, isAsc);
            quickSort(intArray, lowIndex, pivotIndex, isAsc);
            quickSort(intArray, pivotIndex + 1, highIndex, isAsc);
        }
    }

    /**
     * QUICK SORT: Sort elements and find index of pivot element (implementation of Hoare partition scheme)
     *
     * @param intArray  input array in which will be found index of pivot
     * @param lowIndex  first index which represents start index in part
     *                  of the array in which will be found  index of pivot element
     * @param highIndex last index which represents end index in part
     *                  of the array in which will be found index of pivot element
     * @param isAsc     is sorting in ascending order or not
     * @return index of pivot element
     */
    private static int partition(int[] intArray, int lowIndex, int highIndex, boolean isAsc) {
        int pivot = intArray[(highIndex + lowIndex) >>> 1];
        while (true) {
            if (isAsc) {
                while (intArray[lowIndex] < pivot) {
                    ++lowIndex;
                }
                while (intArray[highIndex] > pivot) {
                    --highIndex;
                }
            } else {
                while (intArray[lowIndex] > pivot) {
                    ++lowIndex;
                }
                while (intArray[highIndex] < pivot) {
                    --highIndex;
                }
            }
            if (highIndex <= lowIndex) {
                return highIndex;
            }
            intSwapInArray(intArray, lowIndex++, highIndex--);
        }
    }

    /**
     * MERGE SORT: Sort input array with merge sort algorithm in ascending order
     * <p>
     * <p> Complexity: time -- O(n log(n)) /sorted array - O(n)/ - O(n log(n)) - O(n log(n)), memory -- O(n)
     *
     * @param intArray input array with integer elements
     */
    static void mergeSort(int[] intArray) {
        mergeSort(intArray, true);
    }

    /**
     * MERGE SORT: Sort input array with merge sort algorithm
     * <p>
     * <p> Complexity: time -- O(n log(n)) /sorted array - O(n)/ - O(n log(n)) - O(n log(n)), memory -- O(n)
     * <p> 1. Split array into two parts
     * <p> 2. Recursively call this method for each part of array
     * <p> 3. Call method for merge sorted parts of array
     *
     * @param intArray input array with integer elements
     * @param isAsc    is sorting in ascending order or not
     */
    static void mergeSort(int[] intArray, boolean isAsc) {
        if (intArray.length < 2) {
            return;
        }
        int[] firstArray = new int[intArray.length >>> 1];
        int[] secondArray = new int[intArray.length - firstArray.length];
        System.arraycopy(intArray, 0, firstArray, 0, firstArray.length);
        System.arraycopy(intArray, firstArray.length, secondArray, 0, secondArray.length);
        mergeSort(firstArray, isAsc);
        mergeSort(secondArray, isAsc);
        merge(firstArray, secondArray, intArray, isAsc);
    }

    /**
     * MERGE SORT: Merge two sorted input arrays in one sorted array
     * <p>
     * Compare elements of two arrays and put them in resulting array in ascending order
     *
     * @param firstArray  first input sorted array
     * @param secondArray second input sorted array
     * @param resultArray result array in which will be merged first and second arrays
     * @param isAsc       is sorting in ascending order or not
     */
    private static void merge(int[] firstArray, int[] secondArray, int[] resultArray, boolean isAsc) {
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int resultIndex = 0;

        while (firstArrayIndex < firstArray.length && secondArrayIndex < secondArray.length) {
            if (isAsc) {
                if (secondArray[secondArrayIndex] < firstArray[firstArrayIndex]) {
                    resultArray[resultIndex++] = secondArray[secondArrayIndex++];
                } else {
                    resultArray[resultIndex++] = firstArray[firstArrayIndex++];
                }
            } else {
                if (secondArray[secondArrayIndex] > firstArray[firstArrayIndex]) {
                    resultArray[resultIndex++] = secondArray[secondArrayIndex++];
                } else {
                    resultArray[resultIndex++] = firstArray[firstArrayIndex++];
                }
            }
        }
        while (firstArrayIndex < firstArray.length) {
            resultArray[resultIndex++] = firstArray[firstArrayIndex++];
        }
        while (secondArrayIndex < secondArray.length) {
            resultArray[resultIndex++] = secondArray[secondArrayIndex++];
        }
    }

    /**
     * Swap two integer elements in array
     *
     * @param intArray    array in which elements will be swapped
     * @param firstIndex  index of the first element
     * @param secondIndex index of the second element
     */
    private static boolean intSwapInArray(int[] intArray, int firstIndex, int secondIndex) {
        if (firstIndex < intArray.length && secondIndex < intArray.length) {
            int temp = intArray[firstIndex];
            intArray[firstIndex] = intArray[secondIndex];
            intArray[secondIndex] = temp;
            return true;
        }
        return false;
    }

    /**
     * RADIX SORT: Sort input array with radix sort algorithm
     * <p>
     * <p> Complexity: time -- O(nk) - O(nk) - O(nk), memory -- O(n + k)
     *
     * @param intArray input array which will be sorted
     */
    static void radixSortLSD(int[] intArray) {
        radixSortLSD(intArray, true);
    }

    /**
     * RADIX SORT: Sort input array with radix sort algorithm
     * <p>
     * <p> Complexity: time -- O(nk) - O(nk) - O(nk), memory -- O(n + k)
     * <p> Supporting negative values sorting:
     * <p> 1. Divide input array on two: negative and positive
     * <p> 2. Mark all negative values in negative array as positive
     * <p> 3. Sort negative values as positive in reverse order
     * <p> 4. Mark values in negative array as negative
     * <p> 5. Merge of two arrays in the given order
     * <p> For arrays with only positive values just sort them without division in two arrays
     *
     * @param intArray input array which will be sorted
     * @param isAsc    is sorting in ascending order or not
     */
    static void radixSortLSD(int[] intArray, boolean isAsc) {
        int min = getMin(intArray);
        if (min < 0) {
            int[] negativeArray = new int[countNegative(intArray)];
            int[] positiveArray = new int[intArray.length - countNegative(intArray)];
            int positiveIndex = 0;
            int negativeIndex = 0;
            for (int number : intArray) {
                if (number < 0) {
                    negativeArray[negativeIndex++] = -number;
                } else {
                    positiveArray[positiveIndex++] = number;
                }
            }
            positiveValuesRadixSortLSD(positiveArray, isAsc);
            positiveValuesRadixSortLSD(negativeArray, !isAsc);
            for (int i = 0; i < negativeArray.length; ++i) {
                negativeArray[i] = -negativeArray[i];
            }
            if (isAsc) {
                System.arraycopy(negativeArray, 0, intArray, 0, negativeArray.length);
                System.arraycopy(positiveArray, 0, intArray, negativeArray.length, positiveArray.length);
            } else {
                System.arraycopy(positiveArray, 0, intArray, 0, positiveArray.length);
                System.arraycopy(negativeArray, 0, intArray, positiveArray.length, negativeArray.length);
            }
        } else {
            positiveValuesRadixSortLSD(intArray, isAsc);
        }
    }

    /**
     * RADIX SORT: Sort input array with radix sort algorithm (for positive values)
     * <p>
     * <p> Complexity: time -- O(nk) - O(nk) - O(nk), memory -- O(n + k)
     * <p> 1. Get max value from array to define max digit position
     * <p> 2. Call counting sort for each digit position
     *
     * @param intArray input array which will be sorted
     * @param isAsc    is sorting in ascending order or not
     */
    private static void positiveValuesRadixSortLSD(int[] intArray, boolean isAsc) {
        int max = getMax(intArray);
        for (int digitPosition = 1; max / digitPosition > 0; digitPosition *= 10) {
            countSort(intArray, digitPosition, isAsc);
        }
    }

    /**
     * RADIX SORT: Counting sort for radix sort (in ascending and descending order)
     * <p>
     * <p> Complexity for counting sort: time -- O(n) - O(n) - O(n), memory -- O(n + k)
     *
     * @param intArray      input array which will be sorted
     * @param digitPosition digit position of number
     * @param isAsc         is sorting in ascending order or not
     */
    private static void countSort(int[] intArray, int digitPosition, boolean isAsc) {
        int result[] = new int[intArray.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int number : intArray) {
            ++count[(number / digitPosition) % 10];
        }
        for (int i = 1; i < count.length; ++i) {
            if (isAsc) {
                count[i] += count[i - 1];
            } else {
                count[count.length - i - 1] += count[count.length - i];
            }
        }
        for (int i = intArray.length - 1; i > -1; --i) {
            result[--count[(intArray[i] / digitPosition) % 10]] = intArray[i];
        }
        System.arraycopy(result, 0, intArray, 0, intArray.length);
    }

    /**
     * RADIX SORT: Get max integer element from array
     *
     * @param intArray input array with integer elements
     * @return maximum value from array
     */
    private static int getMax(int[] intArray) {
        int max = intArray[0];
        for (int i = 1; i < intArray.length; ++i) {
            if (intArray[i] > max) {
                max = intArray[i];
            }
        }
        return max;
    }

    /**
     * RADIX SORT: Get min integer element from array
     *
     * @param intArray input array with integer elements
     * @return minimum value from array
     */
    private static int getMin(int[] intArray) {
        int min = intArray[0];
        for (int i = 1; i < intArray.length; ++i) {
            if (intArray[i] < min) {
                min = intArray[i];
            }
        }
        return min;
    }

    /**
     * RADIX SORT: Count negative integer elements in array
     *
     * @param intArray input array with integer elements
     * @return amount of negative values in array
     */
    private static int countNegative(int[] intArray) {
        int count = 0;
        for (int number : intArray) {
            if (number < 0) {
                ++count;
            }
        }
        return count;
    }

    /**
     * BINARY SEARCH: Search index with key value in sorted array
     * <p>
     * <p> Array must be sorted otherwise result will be undefined
     * <p> Complexity: time -- O(log(n)) - O(log(n)), memory -- O(1)
     *
     * @param intArray array to be searched
     * @param key      value to be searched for
     * @return index of search key if array contains key otherwise <code>-1</code>
     */
    static int binarySearch(int[] intArray, int key) {
        return binarySearch(intArray, 0, intArray.length - 1, key);
    }

    /**
     * BINARY SEARCH: Search index with key value in sorted array
     * <p>
     * <p> Array must be sorted otherwise result will be undefined
     * <p> Complexity: time -- O(log(n)) - O(log(n)), memory -- O(1)
     *
     * @param intArray   array to be searched
     * @param firstIndex index of the first element (inclusive) to be searched
     * @param lastIndex  index of the last element (inclusive) to be searched
     * @param key        value to be searched for
     * @return index of search key if array contains key otherwise <code>-1</code>
     */
    private static int binarySearch(int[] intArray, int firstIndex, int lastIndex, int key) {
        while (firstIndex <= lastIndex) {
            int midIndex = (firstIndex + lastIndex) >>> 1;
            if (intArray[midIndex] < key) {
                firstIndex = midIndex + 1;
            } else if (intArray[midIndex] > key) {
                lastIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    /**
     * BINARY SEARCH: Print in console result of binary search
     *
     * @param key    value which was searched in array
     * @param result result of searching
     */
    private static void printBinarySearchResult(int key, int result) {
        System.out.println(result == -1 ? "Array doesn't contain value " + key
                : "Array contains value " + key + " index is " + result);
    }
}
