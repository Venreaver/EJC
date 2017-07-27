package classwork.classwork27072017;

import java.util.Arrays;

/**
 * Class implements two sort algorithms: selection sort and radix sort
 * <p>
 * <p> Class implements method to form array with random integers and sorting methods
 */
public class Sorts {
    public static void main(String[] args) {
        System.out.println("\nSELECTION SORT");
        int[] intArrayForSelection = setRandomNumberArray(110);
        System.out.println(Arrays.toString(intArrayForSelection));
        selectionSort(intArrayForSelection);
        System.out.println(Arrays.toString(intArrayForSelection));

        System.out.println("\nRADIX SORT");
        int[] intArrayForRadix = setRandomNumberArray(115, false);
        System.out.println(Arrays.toString(intArrayForRadix));
        radixSortLSD(intArrayForRadix);
        System.out.println(Arrays.toString(intArrayForRadix));
    }

    /**
     * Return array with <code>n</code> random integer elements [0, 1000)
     *
     * @param n number of random integer elements which will be input in array
     * @return array with <code>n</code> random integer elements
     */
    private static int[] setRandomNumberArray(int n) {
        return setRandomNumberArray(n, true);
    }

    /**
     * Return array with <code>n</code> random integer elements [0, 1000)
     *
     * @param n number of random integer elements which will be input in array
     * @return array with <code>n</code> random integer elements
     */
    private static int[] setRandomNumberArray(int n, boolean negativeValues) {
        int[] resultArray = new int[n];
        for (int i = 0; i < resultArray.length; ++i) {
            if (negativeValues) {
                resultArray[i] = Math.random() < 0.5 ? (int) (Math.random() * 1000) : -(int) (Math.random() * 1000);
            } else {
                resultArray[i] = (int) (Math.random() * 1000);
            }
        }
        return resultArray;
    }

    /**
     * SELECTION SORT: Sort input list with selection sort algorithm
     *
     * @param intArray input array with integer elements
     */
    static void selectionSort(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; ++i) {
            int minOrMax = i;
            for (int j = minOrMax + 1; j < intArray.length; ++j) {
                if (intArray[minOrMax] > intArray[j]) {
                    minOrMax = j;
                }
            }
            if (minOrMax != i) {
                int temp = intArray[minOrMax];
                intArray[minOrMax] = intArray[i];
                intArray[i] = temp;
            }
        }
    }

    /**
     * RADIX SORT: Sort input array with radix sort algorithm
     *
     * @param intArray input array which will be sorted
     */
    static void radixSortLSD(int[] intArray) {
        int max = getMax(intArray);
        for (int digitPosition = 1; max / digitPosition > 0; digitPosition *= 10) {
            countSort(intArray, digitPosition);
        }
    }

    /**
     * RADIX SORT: Counting sort for radix sort
     *
     * @param intArray      input array which will be sorted
     * @param digitPosition digit position of number
     */
    private static void countSort(int[] intArray, int digitPosition) {
        int result[] = new int[intArray.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int number : intArray) {
            ++count[(number / digitPosition) % 10];
        }
        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
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
}
