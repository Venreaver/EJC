package tasks.task_04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgorithmsTest {
    private int[] intArray;
    private int[] sortedArrayWithoutSearchElement;
    private int[] ascendingSortedArray;
    private int[] descendingSortedArray;
    private int searchElement;
    private int searchElementIndex;
    private int noElementInArrayIndex;

    @Before
    public void beforeTest() {
        intArray = new int[]{-573, 261, -474, 780, -561, 0, 728, 996, 600, 242, 760, -243, -603, -907, -493};
        ascendingSortedArray = new int[]{-907, -603, -573, -561, -493, -474, -243, 0, 242, 261, 600, 728, 760, 780, 996};
        descendingSortedArray = new int[]{996, 780, 760, 728, 600, 261, 242, 0, -243, -474, -493, -561, -573, -603, -907};
        sortedArrayWithoutSearchElement = new int[]{-907, -603, -573, -561, -493, -474, -243, 78, 242, 261, 600, 728, 760, 780, 996};
        searchElementIndex = 7;
        noElementInArrayIndex = -1;
    }

    @Test
    public void testBubbleSortAscending() {
        Algorithms.bubbleSort(intArray);
        Assert.assertArrayEquals("Something going wrong",
                intArray, ascendingSortedArray);
    }

    @Test
    public void testBubbleSortDescending() {
        Algorithms.bubbleSort(intArray, false);
        Assert.assertArrayEquals("Something going wrong",
                intArray, descendingSortedArray);
    }

    @Test
    public void testSelectionSortAscending() {
        Algorithms.selectionSort(intArray);
        Assert.assertArrayEquals("Something going wrong",
                intArray, ascendingSortedArray);
    }

    @Test
    public void testSelectionSortDescending() {
        Algorithms.selectionSort(intArray, false);
        Assert.assertArrayEquals("Something going wrong",
                intArray, descendingSortedArray);
    }

    @Test
    public void testInsertionSortAscending() {
        Algorithms.insertionSort(intArray);
        Assert.assertArrayEquals("Something going wrong",
                intArray, ascendingSortedArray);
    }

    @Test
    public void testInsertionSortDescending() {
        Algorithms.insertionSort(intArray, false);
        Assert.assertArrayEquals("Something going wrong",
                intArray, descendingSortedArray);
    }

    @Test
    public void testQuickSortAscending() {
        Algorithms.quickSort(intArray);
        Assert.assertArrayEquals("Something going wrong",
                intArray, ascendingSortedArray);
    }

    @Test
    public void testQuickSortDescending() {
        Algorithms.quickSort(intArray, false);
        Assert.assertArrayEquals("Something going wrong",
                intArray, descendingSortedArray);
    }

    @Test
    public void testMergeSortAscending() {
        Algorithms.mergeSort(intArray);
        Assert.assertArrayEquals("Something going wrong",
                intArray, ascendingSortedArray);
    }

    @Test
    public void testMergeSortDescending() {
        Algorithms.mergeSort(intArray, false);
        Assert.assertArrayEquals("Something going wrong",
                intArray, descendingSortedArray);
    }

    @Test
    public void testRadixSortAscending() {
        Algorithms.radixSortLSD(intArray);
        Assert.assertArrayEquals("Something going wrong",
                intArray, ascendingSortedArray);
    }

    @Test
    public void testRadixSortDescending() {
        Algorithms.radixSortLSD(intArray, false);
        Assert.assertArrayEquals("Something going wrong",
                intArray, descendingSortedArray);
    }

    @Test
    public void testBinarySearchIndexFound() {
        Assert.assertEquals("Something going wrong", searchElementIndex,
                Algorithms.binarySearch(ascendingSortedArray, searchElement));
    }

    @Test
    public void testBinarySearchIndexNotFound() {
        Assert.assertEquals("Something going wrong", noElementInArrayIndex,
                Algorithms.binarySearch(sortedArrayWithoutSearchElement, searchElement));
    }
}
