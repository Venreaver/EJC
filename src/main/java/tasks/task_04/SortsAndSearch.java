package tasks.task_04;

import java.util.Arrays;

/**
 * Class implements six sorting algorithms (in ascending and descending order) and binary search in int array
 * <p>
 * <p> Implementation of bubble sort, selection sort, insertion sort,
 * quick sort, merge sort, radix sort, binary search
 * <p> Class implements method to form array with random integers, sorting methods and search methods
 */
public class SortsAndSearch {
    public static void main(String[] args) {
        int[] intArrayForBubble = setRandomNumberArray(15);
        System.out.println(Arrays.toString(intArrayForBubble));
        bubbleSort(intArrayForBubble, false);
        System.out.println(Arrays.toString(intArrayForBubble));
        printBinarySearchResult(0, binarySearch(intArrayForBubble, 0));

        int[] intArrayForSelection = setRandomNumberArray(10);
        System.out.println(Arrays.toString(intArrayForSelection));
        selectionSort(intArrayForSelection, false);
        System.out.println(Arrays.toString(intArrayForSelection));
        printBinarySearchResult(0, binarySearch(intArrayForSelection, 0));

        int[] intArrayForInsertion = setRandomNumberArray(15);
        System.out.println(Arrays.toString(intArrayForInsertion));
        insertionSort(intArrayForInsertion, false);
        System.out.println(Arrays.toString(intArrayForInsertion));
        printBinarySearchResult(0, binarySearch(intArrayForInsertion, 0));

        int[] intArrayForQuick = setRandomNumberArray(15);
        System.out.println(Arrays.toString(intArrayForQuick));
        quickSort(intArrayForQuick, false);
        System.out.println(Arrays.toString(intArrayForQuick));
        printBinarySearchResult(0, binarySearch(intArrayForQuick, 0));

        int[] intArrayForMerge = setRandomNumberArray(15);
        System.out.println(Arrays.toString(intArrayForMerge));
        mergeSort(intArrayForMerge, false);
        System.out.println(Arrays.toString(intArrayForMerge));
        printBinarySearchResult(0, binarySearch(intArrayForMerge, 0));
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
     *
     * @param intArray input array with integer elements
     */
    static void bubbleSort(int[] intArray) {
        bubbleSort(intArray, true);
    }

    /**
     * BUBBLE SORT: Sort input array with optimizing bubble sort algorithm
     *
     * @param intArray input array with integer elements
     * @param isAsc    is sorting in ascending order or not
     */
    static void bubbleSort(int[] intArray, boolean isAsc) {
        for (int i = 0; i < intArray.length; ++i) {
            boolean isSwapped = false;
            for (int j = 0; j < intArray.length - i - 1; ++j) {
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
     *
     * @param intArray input array with integer elements
     */
    static void selectionSort(int[] intArray) {
        selectionSort(intArray, true);
    }

    /**
     * SELECTION SORT: Sort input list with selection sort algorithm
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
            if (minOrMax != i) {
                intSwapInArray(intArray, minOrMax, i);
            }
        }
    }

    /**
     * INSERTION SORT: Sort input list with insertion sort algorithm
     *
     * @param intArray input array with integer elements
     */
    static void insertionSort(int[] intArray) {
        insertionSort(intArray, true);
    }

    /**
     * INSERTION SORT: Sort input list with insertion sort algorithm
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
     *
     * @param intArray input array which will be sorted
     */
    static void quickSort(int[] intArray) {
        quickSort(intArray, true);
    }

    /**
     * QUICK SORT: Sort input array with quick sort algorithm with Hoare partitioning
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
     *
     * @param intArray input array with integer elements
     */
    static void mergeSort(int[] intArray) {
        mergeSort(intArray, true);
    }

    /**
     * MERGE SORT: Sort input array with merge sort algorithm
     * <p>
     * <p> 1. Split array into two parts
     * <p> 2. Recursively call this method for each part of array
     * <p> 3. Call method for merge sorted parts of array
     *
     * @param intArray input array with integer elements
     * @param isAsc    is sorting in ascending order or not
     */
    static void mergeSort(int[] intArray, boolean isAsc) {
        if (intArray.length == 1) {
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
                if (firstArray[firstArrayIndex] < secondArray[secondArrayIndex]) {
                    resultArray[resultIndex++] = firstArray[firstArrayIndex++];
                } else {
                    resultArray[resultIndex++] = secondArray[secondArrayIndex++];
                }
            } else {
                if (firstArray[firstArrayIndex] > secondArray[secondArrayIndex]) {
                    resultArray[resultIndex++] = firstArray[firstArrayIndex++];
                } else {
                    resultArray[resultIndex++] = secondArray[secondArrayIndex++];
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
     * BINARY SEARCH: Search index with key value in sorted array
     * <p>
     * Array must be sorted otherwise result will be undefined
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
     * Array must be sorted otherwise result will be undefined
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
            int midKey = intArray[midIndex];
            if (midKey < key) {
                firstIndex = midIndex + 1;
            } else if (midKey > key) {
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
