package classwork.classwork24072017;

import java.util.Arrays;

/**
 * Class implements three algorithms: bubble sort, merge sort, binary search
 * <p>
 * <p> Class implements method to form array with random integers,
 * sorting methods and search methods
 */
public class SortsAndSearch {
    public static void main(String[] args) {
        int[] intArrayForMerge = setRandomNumberArray(115);
        System.out.println(Arrays.toString(intArrayForMerge));
        mergeSort(intArrayForMerge);
        System.out.println(Arrays.toString(intArrayForMerge));
        printBinarySearchResult(0, binarySearch(intArrayForMerge, 0));
        int[] intArrayForBubble = setRandomNumberArray(110);
        System.out.println(Arrays.toString(intArrayForBubble));
        bubbleSort(intArrayForBubble);
        System.out.println(Arrays.toString(intArrayForBubble));
        printBinarySearchResult(0, binarySearch(intArrayForBubble, 0));
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
     * Sort input array with merge sort algorithm
     * <p>
     * <p> 1. Split array into two parts
     * <p> 2. Recursively call this method for each part of array
     * <p> 3. Call method for merge sorted parts of array
     *
     * @param intArray input array with integer elements
     */
    static void mergeSort(int[] intArray) {
        if (intArray.length == 1) {
            return;
        }
        int[] firstArray = new int[intArray.length >>> 1];
        int[] secondArray = new int[intArray.length - firstArray.length];
        System.arraycopy(intArray, 0, firstArray, 0, firstArray.length);
        System.arraycopy(intArray, firstArray.length, secondArray, 0, secondArray.length);
        mergeSort(firstArray);
        mergeSort(secondArray);
        merge(firstArray, secondArray, intArray);
    }

    /**
     * Merge two sorted input arrays in one sorted array
     * <p>
     * Compare elements of two arrays and put them in resulting array in ascending order
     *
     * @param firstArray  first input sorted array
     * @param secondArray second input sorted array
     * @param resultArray result array in which will be merged first and second arrays
     */
    private static void merge(int[] firstArray, int[] secondArray, int[] resultArray) {
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int resultIndex = 0;

        while (firstArrayIndex < firstArray.length && secondArrayIndex < secondArray.length) {
            if (firstArray[firstArrayIndex] < secondArray[secondArrayIndex]) {
                resultArray[resultIndex++] = firstArray[firstArrayIndex++];
            } else {
                resultArray[resultIndex++] = secondArray[secondArrayIndex++];
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
     * Sort input array with optimizing bubble sort algorithm
     *
     * @param intArray input array with integer elements
     */
    static void bubbleSort(int[] intArray) {
        for (int i = 0; i < intArray.length; ++i) {
            boolean isSwapped = false;
            for (int j = 0; j < intArray.length - i - 1; ++j) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    /**
     * Search index with key value in sorted array
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
     * Search index with key value in sorted array
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
     * Print in console result of binary search
     *
     * @param key    value which was searched in array
     * @param result result of searching
     */
    private static void printBinarySearchResult(int key, int result) {
        System.out.println(result == -1 ? "Array doesn't contain value " + key
                : "Array contains value " + key + " index is " + result);
    }
}
